package com.example.si_dung

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.example.si_dung.Fragment.BookingFragment
import com.example.si_dung.Fragment.HomeFragment
import kotlinx.android.synthetic.main.activity_booking.*
import org.json.JSONArray
import java.util.*

class BookingActivity : AppCompatActivity() {

    lateinit var bookingFragment: BookingFragment

    lateinit var radioGedungbtn: RadioButton
    lateinit var radioJenisbtn: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        pickDate.setOnClickListener(){
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, nyear, nmonth, ndayOfMonth ->
                dateTv.setText(""+ nyear +"/"+ nmonth +"/"+ ndayOfMonth)
            }, year, month, day)
            dpd.show()
        }

        btn_send.setOnClickListener(){
            var no_pinjam: String = "202002323" // no_pinjam sementara, nantinya bisa auto generat
            var nama: String = book_nama.text.toString()
            var nim: String = book_nim.text.toString()
            var fakultas: String = book_fakultas.text.toString()
            var orga: String = book_orga.text.toString()

            val selectedGedung = radioGedung.checkedRadioButtonId
            radioGedungbtn = findViewById(selectedGedung)
            var nama_gedung: String = radioGedungbtn.text.toString()

            var tanggal_pinjam = dateTv.text.toString()
            var waktu_pinjam = book_waktu.text.toString()

            val selectedJenis = radioJenis.checkedRadioButtonId
            radioJenisbtn = findViewById(selectedJenis)
            var jenis_acara: String = radioJenisbtn.text.toString()

            var deskripsi: String = book_deskripsi.text.toString()

            var surat_permohonan: String = "-"
            var ktm: String = "-"
            var status: String = "-"

            booking(no_pinjam, nama, nim, fakultas, orga, nama_gedung, tanggal_pinjam, waktu_pinjam, jenis_acara, deskripsi, surat_permohonan, ktm, status)

            book_nama.setText("")
            book_nim.setText("")
            book_fakultas.setText("")
            book_deskripsi.setText("")
            book_orga.setText("")
            book_waktu.setText("")
            dateTv.setText("")
            radioGedung.clearCheck()
            radioJenis.clearCheck()
        }

    }

    fun booking(data1: String, data2: String, data3: String, data4: String, data5: String, data6: String, data7: String, data8: String, data9: String, data10: String, data11: String, data12: String, data13: String){
        AndroidNetworking.post("http://192.168.43.18/sidung/users/proses-create-peminjaman.php")
            .addBodyParameter("no_pinjam", data1)
            .addBodyParameter("nama", data2)
            .addBodyParameter("nim", data3)
            .addBodyParameter("fakultas", data4)
            .addBodyParameter("nama_organisasi", data5)
            .addBodyParameter("nama_gedung", data6)
            .addBodyParameter("tanggal_pinjam", data7)
            .addBodyParameter("waktu_pinjam", data8)
            .addBodyParameter("jenis_acara", data9)
            .addBodyParameter("deskripsi_acara", data10)
            .addBodyParameter("surat_permohonan", data11)
            .addBodyParameter("ktm", data12)
            .addBodyParameter("status", data13)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONArray(object : JSONArrayRequestListener{
                override fun onResponse(response: JSONArray?) {
                    Toast.makeText(this@BookingActivity, "Data Berhasil Dikirim", Toast.LENGTH_SHORT).show()
                }

                override fun onError(anError: ANError?) {

                }
            })

    }

}

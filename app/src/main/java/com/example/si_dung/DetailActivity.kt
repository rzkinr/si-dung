package com.example.si_dung

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_gedung.*
import org.json.JSONObject

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val data: Intent = intent
        val no: String = data.getStringExtra("id_pinjam")
        getDetailRiwayat(no)
    }

    fun getDetailRiwayat(id_pinjam: String){
        AndroidNetworking.post("http://192.168.43.18/sidung/users/read-peminjaman-single-json.php")
            .addBodyParameter("id", id_pinjam)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()){
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTittle", jsonObject.optString("no_pinjam"))

                        val data1: String = jsonObject.optString("nama").toString()
                        val data2: String = jsonObject.optString("nim").toString()
                        val data3: String = jsonObject.optString("fakultas").toString()
                        val data4: String = jsonObject.optString("nama_organisasi").toString()
                        val data5: String = jsonObject.optString("tanggal_pinjam").toString()
                        val data7: String = jsonObject.optString("waktu_pinjam").toString()
                        val data8: String = jsonObject.optString("jenis_acara").toString()
                        val data9: String = jsonObject.optString("deskripsi_acara").toString()
                        val data10: String = jsonObject.optString("surat_permohonan").toString()
                        val data11: String = jsonObject.optString("ktm").toString()
                        val data12: String = jsonObject.optString("status").toString()
                        val data13: String = jsonObject.optString("deskripsi").toString()


                        detail_namagedung.text = jsonObject.optString("nama_gedung").toString()
                        detail_nama.text = "Nama : $data1"
                        detail_nim.text = "Nim : $data2"
                        detail_fakultas.text = "Fakultas : $data3"
                        detail_orga.text = "Nama Organisasi : $data4"
                        detail_tanggal.text = "Tanggal Pinjam : $data5"
                        detail_waktu.text = "Waktu Pinjam : $data7"
                        detail_jenis.text = "Jenis Acara : $data8"
                        detail_desacara.text = "Deskripsi Acara : $data9"
                        detail_surat.text = "Surat Permohonan : $data10"
                        detail_ktm.text = "Ktm : $data11"
                        detail_status.text = "Status : $data12"
                        detail_desk.text = "Deskripsi : $data13"

                        val nid: String = jsonObject.optString("nama_gedung")

                        if (nid == "GOR Pertamina"){
                            riwayat_gambar.setImageResource(R.drawable.gor0)
                        }else if(nid== "Samantha Krida"){
                            riwayat_gambar.setImageResource(R.drawable.sakri0)
                        }else {
                            riwayat_gambar.setImageResource(R.drawable.gkm0)
                        }

                    }
                }

                override fun onError(anError: ANError?) {

                }
            })
    }
}

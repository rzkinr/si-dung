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
import org.json.JSONObject

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val data: Intent =intent
        val no: String = data.getStringExtra("no_pinjam")
        getDetailRiwayat(no)
    }

    fun getDetailRiwayat(no_pinjam: String){
        AndroidNetworking.post("http://192.168.43.18/sidung/users/read-peminjaman-single-json.php")
            .addBodyParameter("no_pinjam", no_pinjam)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()){
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTittle", jsonObject.optString("no_pinjam"))

                        detail_namagedung.text = jsonObject.optString("nama_gedung").toString()
                        detail_nama.text = jsonObject.optString("nama").toString()
                        detail_nim.text = jsonObject.optString("nim").toString()
                        detail_fakultas.text = jsonObject.optString("fakultas").toString()
                        detail_orga.text = jsonObject.optString("nama_organisasi").toString()
                        detail_tanggal.text = jsonObject.optString("tanggal_pinjam").toString()
                        detail_waktu.text = jsonObject.optString("waktu_pinjam").toString()
                        detail_jenis.text = jsonObject.optString("jenis_acara").toString()
                        detail_desacara.text = jsonObject.optString("deskripsi_acara").toString()
                        detail_surat.text = jsonObject.optString("surat_permohonan").toString()
                        detail_ktm.text = jsonObject.optString("ktm").toString()
                        detail_desk.text = jsonObject.optString("deskripsi").toString()

                    }
                }

                override fun onError(anError: ANError?) {

                }
            })
    }
}

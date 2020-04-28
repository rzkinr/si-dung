package com.example.si_dung

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_gedung.*
import org.json.JSONObject

class GedungActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gedung)

        val data_object: Intent = intent
        val ndata = data_object.getStringExtra("data")

        getGedungOne(ndata)

    }

    fun getGedungOne(data: String){
        AndroidNetworking.post("http://192.168.43.18/sidung/users/read-gedung-single-json.php")
            .addBodyParameter("id", data)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()){
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTittle", jsonObject.optString("nama_gedung"))
                        Log.d("namagedung", jsonObject.optString("nama_gedung"))

                        val nnama_gedung: String = jsonObject.optString("nama_gedung")
                        val nluas: String = jsonObject.optString("luas_gedung")
                        val nkapasitas: String = jsonObject.optString("kapasitas")
                        val nparkir: String = jsonObject.optString("parkir")

                        nama_gedung.text = "$nnama_gedung"
                        luas_gedung.text = "Luas Gedung : $nluas"
                        kapasitas.text = "Kapasitas : $nkapasitas"
                        parkir.text = "Parkir : $nparkir"

                        getJadwalOne(nnama_gedung)

                        val nid: String = jsonObject.optString("id")

                        if (nid == "1"){
                            img_detail.setImageResource(R.drawable.gor0)
                        }else if(nid== "2"){
                            img_detail.setImageResource(R.drawable.sakri0)
                        }else {
                            img_detail.setImageResource(R.drawable.gkm0)
                        }
                    }


                }

                override fun onError(anError: ANError?) {

                }
            })
    }

    fun getJadwalOne(data: String){
        val recyclerView = findViewById(R.id.jadwal) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val jadwal = ArrayList<ClassModelJadwal>()

        AndroidNetworking.post("http://192.168.43.18/sidung/users/read-jadwal-json.php")
            .addBodyParameter("nama_gedung", data)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()){
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTittle", jsonObject.optString("nama_gedung"))
                        Log.d("nama_gedung", jsonObject.optString("nama_gedung"))

                        val nnama_gedung: String = jsonObject.optString("nama_gedung")
                        val ntanggal: String = jsonObject.optString("tanggal_pinjam")
                        val nwaktu: String = jsonObject.optString("waktu_pinjam")

                        jadwal.add(ClassModelJadwal("$ntanggal", "$nwaktu"))

                    }

                    val adapter = JadwalAdapter(jadwal)
                    recyclerView.adapter = adapter

                }

                override fun onError(anError: ANError?) {

                }
            })
    }
}

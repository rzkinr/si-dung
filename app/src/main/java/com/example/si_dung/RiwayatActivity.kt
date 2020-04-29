package com.example.si_dung

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import org.json.JSONObject

class RiwayatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_riwayat)

        val nomor = getSharedPreferences("NOMOR", Context.MODE_PRIVATE)
        val ndata = nomor.getString("no_pinjam","").toString()
        Log.d("NOMOR", ndata)
        getRiwayat(ndata)
    }

    fun getRiwayat(data: String){
        val recyclerView = findViewById(R.id.recycleView) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val riwayat = ArrayList<ClassModelRiwayat>()

        AndroidNetworking.post("http://192.168.43.18/sidung/users/read-peminjaman-json.php")
            .addBodyParameter("no_pinjam", data)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()){
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTittle", jsonObject.optString("nama_gedung"))

                        val data1 = jsonObject.optString("id").toString()
                        val data2 = jsonObject.optString("no_pinjam").toString()
                        val data3 = jsonObject.optString("nama_gedung").toString()
                        val data4 = jsonObject.optString("status").toString()

                        riwayat.add(ClassModelRiwayat("$data1","$data2","$data3", "$data4"))
                    }

                    val adapter = RiwayatAdapter(riwayat, {riwayat -> onclick(riwayat)})
                    recyclerView.adapter = adapter


                }

                override fun onError(anError: ANError?) {

                }
            })
    }

    private fun onclick(classModelRiwayat: ClassModelRiwayat){
        val intent = Intent(applicationContext, DetailActivity::class.java)
        intent.putExtra("id_pinjam", classModelRiwayat.id)
        startActivity(intent)
    }
}

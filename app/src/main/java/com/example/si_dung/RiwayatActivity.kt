package com.example.si_dung

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
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
        getRiwayat()
    }

    fun getRiwayat(){
        val recyclerView = findViewById(R.id.recycleView) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val riwayat = ArrayList<ClassModelRiwayat>()

        AndroidNetworking.get("http://192.168.43.18/sidung/users/read-peminjaman-json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()){
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTittle", jsonObject.optString("nama_gedung"))

                        val data1 = jsonObject.optString("nama_gedung").toString()
                        val data2 = jsonObject.optString("status").toString()

                        riwayat.add(ClassModelRiwayat("$data1", "$data2"))
                    }

                    val adapter = RiwayatAdapter(riwayat)
                    recyclerView.adapter = adapter
                }

                override fun onError(anError: ANError?) {

                }
            })
    }
}

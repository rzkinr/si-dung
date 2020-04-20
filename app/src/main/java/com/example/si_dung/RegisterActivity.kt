package com.example.si_dung

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import kotlinx.android.synthetic.main.activity_register.*
import org.json.JSONArray

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_backregister.setOnClickListener(){
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        }
    }

    fun postkeserver(data1:String, data2:String, data3:String){
        AndroidNetworking.post("http://192.168.43.214/sidung/users/proses-create-users.php")
            .addBodyParameter("nama_lengkap", data1)
            .addBodyParameter("email", data2)
            .addBodyParameter("password", data3)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONArray(object : JSONArrayRequestListener {
                override fun onResponse(response: JSONArray?) {
                }

                override fun onError(anError: ANError?) {
                }
            })
    }
}

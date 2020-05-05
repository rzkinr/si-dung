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

        btn_signup.setOnClickListener(){
            var data_nama: String = txt_nuser.text.toString()
            var data_email: String = txt_nemail.text.toString()
            var data_password: String = txt_npassword.text.toString()

            postkeserver(data_nama,data_email,data_password)

            val intent = Intent(applicationContext,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        btn_regtolog.setOnClickListener(){
            val intent = Intent(applicationContext,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun postkeserver(data1:String, data2:String, data3:String){
        AndroidNetworking.post("http://192.168.43.18/sidung/users/proses-create-users.php")
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

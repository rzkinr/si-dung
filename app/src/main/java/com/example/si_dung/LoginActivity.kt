package com.example.si_dung

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.example.si_dung.Fragment.BookingFragment
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONObject

class LoginActivity : AppCompatActivity() {

    var email: String = ""
    var password: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val sharedPreferences = getSharedPreferences("CEKLOGIN", Context.MODE_PRIVATE)
        val stat=sharedPreferences.getString("STATUS","")

        if (stat=="1"){
            startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
            finish()
        }else {
            btn_signin.setOnClickListener(){
                email =login_email.text.toString()
                password =login_pass.text.toString()
                postkerserver(email,password)
            }
        }

        btn_register.setOnClickListener(){
            val intent = Intent(applicationContext, RegisterActivity::class.java)
            startActivity(intent)
        }

    }

    fun postkerserver(data1:String,data2:String){
        AndroidNetworking.post("http://192.168.43.18/sidung/users/ceklogin-users.php")
            .addBodyParameter("email", data1)
            .addBodyParameter("password", data2)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("status"))
                        var statuslogin= jsonObject.optString("status")

                        if (statuslogin=="1"){

                            val sharedPreferences=getSharedPreferences("CEKLOGIN", Context.MODE_PRIVATE)
                            val editor=sharedPreferences.edit()

                            editor.putString("STATUS",statuslogin)
                            editor.apply()

                            val profil = getSharedPreferences("profil", Context.MODE_PRIVATE)
                            val edit=profil.edit()
                            edit.putString("email", email)
                            edit.apply()

                            startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
                            finish()

                            Toast.makeText(applicationContext, "Login berhasil", Toast.LENGTH_SHORT).show()
                        }else {
                            login_email.setText("")
                            login_pass.setText("")
                            Toast.makeText(this@LoginActivity, "Login gagal", Toast.LENGTH_SHORT).show()
                        }
                    }
                }

                override fun onError(error: ANError) { // handle error
                }
            })
    }
}

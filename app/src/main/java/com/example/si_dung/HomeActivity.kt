package com.example.si_dung

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentTransaction
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.denzcoskun.imageslider.ImageSlider
import com.example.si_dung.Fragment.BookingFragment
import com.example.si_dung.Fragment.HomeFragment
import com.example.si_dung.Fragment.ProfilFragment
import kotlinx.android.synthetic.main.activity_booking.*
import kotlinx.android.synthetic.main.activity_home.*
import org.json.JSONObject

class HomeActivity : AppCompatActivity() {

    lateinit var homeFragment: HomeFragment
    lateinit var bookingFragment: BookingFragment
    lateinit var profilFragment: ProfilFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        menu_bottom.setItemSelected(R.id.home, true)

        homeFragment = HomeFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, homeFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()

        menu_bottom.setOnItemSelectedListener { id ->
            when(id) {
                R.id.home -> {
                    homeFragment = HomeFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, homeFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()

                }
                R.id.booking -> {
                    bookingFragment = BookingFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, bookingFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()

                }
                R.id.profil -> {
                    profilFragment = ProfilFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, profilFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()

                }

            }


        }

        val sharedPref = getSharedPreferences("profil", Context.MODE_PRIVATE)
        val ndata = sharedPref.getString("email","").toString()
//        Log.d("email", ndata)
        getUsers(ndata)


    }

    fun getUsers(data: String){
        AndroidNetworking.post("http://192.168.43.18/sidung/users/read-users-json.php")
            .addBodyParameter("email", data)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("id"))
                        val id: String = jsonObject.optString("id")
                        val nama: String = jsonObject.optString("nama_lengkap")
                        val email: String = jsonObject.optString("email")

                        val nomor = getSharedPreferences("NOMOR", Context.MODE_PRIVATE)
                        val edit=nomor.edit()
                        edit.putString("no_pinjam", "PMJ$id")
                        edit.putString("nama", "$nama")
                        edit.putString("email", "$email")
                        edit.apply()
                    }
                }

                override fun onError(anError: ANError?) {

                }
            })
    }

}

package com.example.si_dung

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentTransaction
import com.denzcoskun.imageslider.ImageSlider
import com.example.si_dung.Fragment.BookingFragment
import com.example.si_dung.Fragment.HomeFragment
import com.example.si_dung.Fragment.ProfilFragment
import kotlinx.android.synthetic.main.activity_home.*

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


    }


}

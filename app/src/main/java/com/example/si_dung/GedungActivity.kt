package com.example.si_dung

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_gedung.*

class GedungActivity : AppCompatActivity() {

    private lateinit var tvNamaGedung : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gedung)

        val data_object: Intent = intent
        val ngedung = data_object.getStringExtra("nama_gedung")
        val nluas = data_object.getStringExtra("luas_gedung")
        val nkapasitas = data_object.getStringExtra("kapasitas")
        val nparkir = data_object.getStringExtra("parkir")

        nama_gedung.text = "$ngedung"
        luas_gedung.text = "Luas Gedung : $nluas"
        kapasitas.text = "Kapasitas : $nkapasitas"
        parkir.text = "Parkir : $nparkir"
    }
}

package com.example.si_dung

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import com.example.si_dung.Fragment.BookingFragment
import kotlinx.android.synthetic.main.activity_booking.*
import java.util.*

class BookingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        pickDate.setOnClickListener(){
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, nyear, nmonth, ndayOfMonth ->
                dateTv.setText(""+ nyear +"/"+ nmonth +"/"+ ndayOfMonth)
            }, year, month, day)
            dpd.show()
        }

        btn_backbooking.setOnClickListener(){

        }
    }
}

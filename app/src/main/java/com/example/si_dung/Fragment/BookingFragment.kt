package com.example.si_dung.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.si_dung.BookingActivity
import com.example.si_dung.HomeActivity

import com.example.si_dung.R
import kotlinx.android.synthetic.main.activity_booking.*
import kotlinx.android.synthetic.main.fragment_booking.*

/**
 * A simple [Fragment] subclass.
 */
class BookingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_booking, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_booking.setOnClickListener(){
            val intent = Intent(view.context, BookingActivity::class.java)
            startActivity(intent)
        }
    }

}

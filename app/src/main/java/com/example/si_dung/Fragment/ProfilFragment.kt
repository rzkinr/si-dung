package com.example.si_dung.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.si_dung.R
import com.example.si_dung.RiwayatActivity
import kotlinx.android.synthetic.main.fragment_profil.*

/**
 * A simple [Fragment] subclass.
 */
class ProfilFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profil, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_pengajuan.setOnClickListener(){
            val intent = Intent(view.context, RiwayatActivity::class.java)
            startActivity(intent)
        }
    }

}

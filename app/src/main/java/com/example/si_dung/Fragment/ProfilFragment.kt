package com.example.si_dung.Fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.si_dung.LoginActivity
import com.example.si_dung.MainActivity

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

        btn_logout.setOnClickListener(){
            val sharedPreferences = activity?.getSharedPreferences("CEKLOGIN", Context.MODE_PRIVATE)
            val editor = sharedPreferences?.edit()

            editor?.putString("STATUS","0")
            editor?.apply()

            startActivity(Intent(view.context, LoginActivity::class.java))
        }

        val nomor = activity?.getSharedPreferences("NOMOR", Context.MODE_PRIVATE)
        val nnama = nomor?.getString("nama","").toString()
        val nemail = nomor?.getString("email","").toString()

        profil_username.text = nnama
        profil_email.text = nemail


    }

}

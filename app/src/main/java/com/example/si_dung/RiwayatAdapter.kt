package com.example.si_dung

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RiwayatAdapter (val riwayatList: ArrayList<ClassModelRiwayat>):RecyclerView.Adapter<RiwayatAdapter.ViewHolder>() {

    lateinit var mContext: Context

    override fun onBindViewHolder(holder: RiwayatAdapter.ViewHolder, position: Int) {
        val riwayat: ClassModelRiwayat = riwayatList[position]
        holder?.tvNamaGedung?.text = riwayat.nama_gedung
        holder?.tvStatus?.text = riwayat.status

        holder?.itemView?.setOnClickListener(){
            val intent = Intent(mContext.applicationContext, DetailActivity::class.java)
            intent.putExtra("no_pinjam", riwayat.no_pinjam)
            mContext.startActivity(intent)

            Toast.makeText(holder?.itemView.context, "Pilih " + riwayat.nama_gedung, Toast.LENGTH_SHORT).show()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.list_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return  riwayatList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvNamaGedung = itemView.findViewById(R.id.riwayatNamaGedung) as TextView
        val tvStatus = itemView.findViewById(R.id.riwayatStatus) as TextView
    }
}
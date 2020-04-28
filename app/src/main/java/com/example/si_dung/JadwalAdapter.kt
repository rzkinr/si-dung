package com.example.si_dung

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class JadwalAdapter (val jadwalList: ArrayList<ClassModelJadwal>): RecyclerView.Adapter<JadwalAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: JadwalAdapter.ViewHolder, position: Int) {
        val jadwal: ClassModelJadwal = jadwalList[position]
        holder?.tvtanggal?.text = jadwal.tanggal_pinjam
        holder?.tvwaktu?.text = jadwal.waktu_pinjam

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.list_jadwal, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return  jadwalList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvtanggal = itemView.findViewById(R.id.tv_tanggal) as TextView
        val tvwaktu = itemView.findViewById(R.id.tv_waktu) as TextView
    }
}
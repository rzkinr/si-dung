package com.example.si_dung

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.interfaces.ItemClickListener

class RiwayatAdapter(val riwayatList: ArrayList<ClassModelRiwayat>, val clickListener: (ClassModelRiwayat) -> Unit):RecyclerView.Adapter<RiwayatAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: RiwayatAdapter.ViewHolder, position: Int) {
        val riwayat: ClassModelRiwayat = riwayatList[position]
        holder?.tvNamaGedung?.text = riwayat.nama_gedung
        holder?.tvStatus?.text = riwayat.status

//        holder?.itemView?.setOnClickListener(){
//            val intent = Intent(mContext, DetailActivity::class.java)
//            intent.putExtra("no_pinjam", riwayat.no_pinjam)
//            mContext.startActivity(intent)
//
//            Toast.makeText(holder?.itemView.context, "Pilih " + riwayat.nama_gedung, Toast.LENGTH_SHORT).show()
//        }

        holder.bind(riwayat, clickListener)

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

        fun bind(classModelRiwayat: ClassModelRiwayat, clickListener: (ClassModelRiwayat) -> Unit){
            itemView.setOnClickListener{
                clickListener(classModelRiwayat)
            }
        }
    }


}
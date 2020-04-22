package com.example.si_dung.Fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.si_dung.GedungActivity

import com.example.si_dung.R
import kotlinx.android.synthetic.main.fragment_home.*
import org.json.JSONObject

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    var nama_gedung: String = ""
    var luas_gedung: String = ""
    var kapasitas: String = ""
    var parkir: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.gorpertaminaub))
        imageList.add(SlideModel(R.drawable.gkm))
        imageList.add(SlideModel(R.drawable.sakri))
        val imageSlider = view.findViewById<ImageSlider>(R.id.image_slider)
        imageSlider.setImageList(imageList)
        imageSlider.stopSliding()

        imageSlider.setItemClickListener(object : ItemClickListener {
            override fun onItemSelected(position: Int) {
                if (position==0){
                    Toast.makeText(view.context,"Gor UB", Toast.LENGTH_LONG ).show()
                    getGedungOne("1")
                    val intent = Intent(view.context, GedungActivity::class.java)
                    intent.putExtra("nama_gedung", nama_gedung)
                    intent.putExtra("luas_gedung", luas_gedung)
                    intent.putExtra("kapasitas", kapasitas)
                    intent.putExtra("parkir", parkir)
                    startActivity(intent)
                }else if (position==1){
                    Toast.makeText(view.context,"GKM UB", Toast.LENGTH_LONG ).show()
                    getGedungOne("2")
                    val intent = Intent(view.context, GedungActivity::class.java)
                    intent.putExtra("nama_gedung", nama_gedung)
                    intent.putExtra("luas_gedung", luas_gedung)
                    intent.putExtra("kapasitas", kapasitas)
                    intent.putExtra("parkir", parkir)
                    startActivity(intent)
                }else if (position==2){
                    Toast.makeText(view.context,"Sakri UB", Toast.LENGTH_LONG ).show()
                    getGedungOne("3")
                    val intent = Intent(view.context, GedungActivity::class.java)
                    intent.putExtra("nama_gedung", nama_gedung)
                    intent.putExtra("luas_gedung", luas_gedung)
                    intent.putExtra("kapasitas", kapasitas)
                    intent.putExtra("parkir", parkir)
                    startActivity(intent)
                }
            }
        })
    }

    fun getGedungOne(data: String){
        AndroidNetworking.post("http://192.168.43.18/sidung/users/read-gedung-single-json.php")
            .addBodyParameter("id", data)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()){
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTittle", jsonObject.optString("nama_gedung"))
                        Log.d("namagedung", jsonObject.optString("nama_gedung"))

                        nama_gedung = jsonObject.optString("nama_gedung")
                        luas_gedung = jsonObject.optString("luas_gedung")
                        kapasitas = jsonObject.optString("kapasitas")
                        parkir = jsonObject.optString("parkir")

                    }
                }

                override fun onError(anError: ANError?) {

                }
            })
    }



}

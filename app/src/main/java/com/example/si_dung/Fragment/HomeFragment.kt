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
        imageList.add(SlideModel(R.drawable.gor1))
        imageList.add(SlideModel(R.drawable.sakri))
        imageList.add(SlideModel(R.drawable.gkm))
        val imageSlider = view.findViewById<ImageSlider>(R.id.image_slider)
        imageSlider.setImageList(imageList)
        imageSlider.stopSliding()

        imageSlider.setItemClickListener(object : ItemClickListener {
            override fun onItemSelected(position: Int) {
                if (position==0){
                    Toast.makeText(view.context,"Gor UB", Toast.LENGTH_LONG ).show()
                    val intent = Intent(view.context, GedungActivity::class.java)
                    intent.putExtra("data", "1")
                    startActivity(intent)
                }else if (position==1){
                    Toast.makeText(view.context,"Sakri UB", Toast.LENGTH_LONG ).show()
                    val intent = Intent(view.context, GedungActivity::class.java)
                    intent.putExtra("data", "2")
                    startActivity(intent)
                }else if (position==2){
                    Toast.makeText(view.context,"GKM UB", Toast.LENGTH_LONG ).show()
                    val intent = Intent(view.context, GedungActivity::class.java)
                    intent.putExtra("data", "3")
                    startActivity(intent)
                }
            }
        })
    }

}

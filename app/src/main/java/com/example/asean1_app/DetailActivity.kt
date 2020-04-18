package com.example.asean1_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val CountryName = intent.getStringExtra("CountryName")
        val description = intent.getStringExtra("description")
        val imageFile = intent.getStringExtra("imageFile")
        val imageFile2 = intent.getStringExtra("imageFile2")
        val caption = intent.getStringExtra("caption")
        val travel = intent.getStringExtra("travel")
        TravelName.setText(travel)

        des.setText(description)





        val res = resources


        val drawableId2:Int = res.getIdentifier(imageFile2,"drawable",packageName)
        pictravel.setImageResource(drawableId2)

    }
}

package com.example.asean1_app

import Utils.getJsonDataFromAsset
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import data.asean
import data.aseanAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var itemList:ArrayList<asean> = ArrayList<asean>()
    lateinit var arrayAdapter: ArrayAdapter<asean>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jsonFileString = getJsonDataFromAsset(applicationContext,"asean_data.json")
        Log.i("data",jsonFileString)
        val gson = Gson()
        val listItemType = object: TypeToken<ArrayList<asean>>(){}.type
        var aseanlist:  ArrayList<asean> = gson.fromJson(jsonFileString,listItemType)

        itemList = aseanlist

        val adapter = aseanAdapter(this@MainActivity,itemList)

        list_itemView.adapter = adapter
        list_itemView.setOnItemClickListener { parent, view, position, id ->

            var intent = Intent(this@MainActivity,DetailActivity::class.java)    //ต้นทางไปปลายททาง
            intent.putExtra("CountryName",itemList[position].CountryName)
            intent.putExtra("description",itemList[position].description)
            intent.putExtra("imageFile",itemList[position].imageFile)
            intent.putExtra("imageFile2",itemList[position].imageFile2)
            intent.putExtra("caption",itemList[position].caption)
            intent.putExtra("travel",itemList[position].travel)



            startActivity(intent)
        }
    }
}

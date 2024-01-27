package com.example.jsonparse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jsonKisilerSonuc =
            "{\"kisiler\":[{\"kisi_id\":\"1\",\"kisi_ad\":\"Eren\",\"kisi_tel\":\"123\"},{\"kisi_id\":\"2\",\"kisi_ad\":\"G\\u00fcl\\u00e7in\",\"kisi_tel\":\"1324\"},{\"kisi_id\":\"3\",\"kisi_ad\":\"Muhammet\",\"kisi_tel\":\"123\"},{\"kisi_id\":\"4\",\"kisi_ad\":\"\\u00c7i\\u011fdem\",\"kisi_tel\":\"123\"},{\"kisi_id\":\"5\",\"kisi_ad\":\"Ceren\",\"kisi_tel\":\"123\"}],\"success\":1}";

        try{

            val jsonObject = JSONObject(jsonKisilerSonuc)
            val kisilerList = jsonObject.getJSONArray("kisiler")

            for(i in 0 until kisilerList.length()){

                val kuyruktakiVeri = kisilerList.getJSONObject(i)
                val kisi_id = kuyruktakiVeri.getInt("kisi_id")
                val kisi_ad = kuyruktakiVeri.getString("kisi_ad")
                val kisi_tel = kuyruktakiVeri.getInt("kisi_tel")

                Log.e("******","******")
                Log.e("KisiID",kisi_id.toString())
                Log.e("KisiAD",kisi_ad)
                Log.e("KisiTEL",kisi_tel.toString())
                Log.e("******","******")
            }

        }catch (e:JSONException){
            e.printStackTrace()
        }
    }
}
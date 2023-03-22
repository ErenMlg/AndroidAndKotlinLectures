package com.example.notapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mainDesign:ActivityMainBinding
    lateinit var adapter:NotlarAdapter
    lateinit var notList: ArrayList<Notlar>
    lateinit var vty: VeritabaniYardimcisi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainDesign = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainDesign.root)

        vty = VeritabaniYardimcisi(this)
        notList = ArrayList()
        notList = NotlarDao().notGetir(vty)

        var toplam=0
        for (not in notList){
            toplam += (not.not1+not.not2)/2
        }

        if (toplam != 0){
            mainDesign.mainTb.subtitle="Ortalama :${toplam/notList.size}"
        }

        setSupportActionBar(mainDesign.mainTb)
        mainDesign.rv.setHasFixedSize(true)
        mainDesign.rv.layoutManager = LinearLayoutManager(this)

        adapter = NotlarAdapter(this,notList)
        mainDesign.rv.adapter = adapter

        mainDesign.fabAdd.setOnClickListener {
            val intent = Intent(this@MainActivity,NotKayitActivity::class.java)
            startActivity(intent)
        }
    }
}
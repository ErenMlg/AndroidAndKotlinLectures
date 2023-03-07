package com.example.ask.card_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.ask.card_recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var design:ActivityMainBinding
    private lateinit var ulkelerList:ArrayList<Ulkeler>
    private lateinit var adapter:RvAdaptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        design= ActivityMainBinding.inflate(layoutInflater)
        setContentView(design.root)

        design.rv.setHasFixedSize(true) // Tasarım üzerine güzel şekilde oturmasını sağlıyor
        design.rv.layoutManager = LinearLayoutManager(this)
        // Listenin görünümleri ile alakalı (Linear, StaggeredGrid) vb. olabilir
        /*
        design.rv.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        2 : Satırda kaç tane veri olacağını bildiriyor.
        design.rv.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL)
        */

        ulkelerList = ArrayList<Ulkeler>()
        val u1 = Ulkeler(1,"Türkiye")
        val u2 = Ulkeler(2,"Almanya")
        val u3 = Ulkeler(3,"Japonya")
        val u4 = Ulkeler(4,"Rusya")
        val u5 = Ulkeler(5,"İtalya")
        val u6 = Ulkeler(6,"ABD")
        ulkelerList.add(u1)
        ulkelerList.add(u2)
        ulkelerList.add(u3)
        ulkelerList.add(u4)
        ulkelerList.add(u5)
        ulkelerList.add(u6)

        adapter = RvAdaptor(this@MainActivity,ulkelerList)

        design.rv.adapter = adapter // oluşturduğumuz adapter sınıfını Rvye bağladık
    }
}
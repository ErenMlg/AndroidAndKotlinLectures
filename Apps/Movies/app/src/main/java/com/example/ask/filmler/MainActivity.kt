package com.example.ask.filmler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.ask.filmler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mainDesign:ActivityMainBinding
    private lateinit var myDatas:ArrayList<Movies>
    private lateinit var rvAdptr:RVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainDesign = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainDesign.root)

        mainDesign.rv.setHasFixedSize(true)
        mainDesign.rv.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        val movie1 = Movies("Bir Zamanlar Anadolula",23.5,"birzamanlaranadoluda",1)
        val movie2 = Movies("Django",56.5,"django",2)
        val movie3 = Movies("İnception",23.3,"inception",3)
        val movie4 = Movies("İnterstellar",59.7,"interstellar",4)
        val movie5 = Movies("The Hateful Eight",239.4,"thehatefuleight",5)
        val movie6 = Movies("The Pianist",99.99,"thepianist",6)
        myDatas = ArrayList<Movies>()
        myDatas.add(movie1)
        myDatas.add(movie2)
        myDatas.add(movie3)
        myDatas.add(movie4)
        myDatas.add(movie5)
        myDatas.add(movie6)

        rvAdptr = RVAdapter(this@MainActivity,myDatas)
        mainDesign.rv.adapter = rvAdptr
    }
}
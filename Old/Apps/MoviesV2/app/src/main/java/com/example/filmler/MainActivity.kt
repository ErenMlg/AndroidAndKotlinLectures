package com.example.filmler

import android.database.sqlite.SQLiteException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.filmler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainDesign: ActivityMainBinding
    private lateinit var adapter: KategorilerRVAdapter
    private lateinit var vt: VeritabaniYardimcisi

    private lateinit var kategoriler: ArrayList<Kategoriler>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainDesign = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainDesign.root)
        veritabaniCopy()

        mainDesign.mainTB.title = "Filmler"
        setSupportActionBar(mainDesign.mainTB)

        vt = VeritabaniYardimcisi(this)
        kategoriler = KategorilerDao().tumKategoriler(vt)

        adapter = KategorilerRVAdapter(this@MainActivity, kategoriler)
        mainDesign.filmlerRv.setHasFixedSize(true)
        mainDesign.filmlerRv.layoutManager = LinearLayoutManager(this@MainActivity)
        mainDesign.filmlerRv.adapter = adapter
    }

    fun veritabaniCopy() {
        val copyHelper = DatabaseCopyHelper(this)
        try {
            copyHelper.createDataBase()
            copyHelper.openDataBase()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
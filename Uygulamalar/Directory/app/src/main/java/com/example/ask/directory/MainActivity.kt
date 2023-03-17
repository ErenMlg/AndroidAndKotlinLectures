package com.example.ask.directory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ask.directory.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() ,SearchView.OnQueryTextListener{

    lateinit var mainDesign:ActivityMainBinding
    private lateinit var kelimeListesi:ArrayList<Kelimeler>
    private lateinit var adapter:RVadapter
    private lateinit var dbHelper:DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainDesign = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainDesign.root)

        copyDB()
        dbHelper = DatabaseHelper(this)
        kelimeListesi = KelimelerDao().kelimeleriGetir(dbHelper)

        mainDesign.toolbar.title = "İngilizce Türkçe Sözlük"
        setSupportActionBar(mainDesign.toolbar)


        mainDesign.rv.setHasFixedSize(true)
        mainDesign.rv.layoutManager = LinearLayoutManager(this)
        adapter = RVadapter(this@MainActivity,kelimeListesi)
        mainDesign.rv.adapter = adapter
    }

    fun copyDB(){
            val dbCopyHelper = DatabaseCopyHelper(this)
        try {
            dbCopyHelper.createDataBase()
            dbCopyHelper.openDataBase()
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)

        val item = menu?.findItem(R.id.action_search)
        val searchView = item?.actionView as SearchView
        searchView.setOnQueryTextListener(this)

        return super.onCreateOptionsMenu(menu)
    }


    override fun onQueryTextSubmit(query: String): Boolean {
        arama(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        arama(newText)
        return true
    }

    fun arama(aramaKelime:String){
        kelimeListesi = KelimelerDao().kelimeAra(dbHelper,aramaKelime)
        adapter = RVadapter(this@MainActivity,kelimeListesi)
        mainDesign.rv.adapter = adapter
    }


}
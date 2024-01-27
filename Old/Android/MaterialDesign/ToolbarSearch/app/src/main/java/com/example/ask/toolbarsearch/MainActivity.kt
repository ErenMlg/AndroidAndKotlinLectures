package com.example.ask.toolbarsearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.widget.SearchView
import com.example.ask.toolbarsearch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),SearchView.OnQueryTextListener {

    lateinit var design:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        design= ActivityMainBinding.inflate(layoutInflater)
        setContentView(design.root)

        design.toolbar.title="Search Toolbar"

        setSupportActionBar(design.toolbar)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_search,menu)

        val item = menu.findItem(R.id.action_search)
        val searchView = item.actionView as SearchView // Arama menü itemini SearchViewe dönüştürdük
        searchView.setOnQueryTextListener(this) // Arama işlemini tetikledik
        return  super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        Log.e("onQueryTextSubmit",query!!)
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        Log.e("onQueryTextChange",newText!!)
        return true
    }

}
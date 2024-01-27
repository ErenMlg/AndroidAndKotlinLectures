package com.example.ask.toolbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.ask.toolbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var design:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        design = ActivityMainBinding.inflate(layoutInflater)
        setContentView(design.root)

        design.toolbar.title = "Özel Toolbar Başlığı"
        design.toolbar.subtitle = "Özel Toolbar AltBaşlığı"
        design.toolbar.setLogo(R.drawable.resim)
        design.toolbar.setTitleTextColor(resources.getColor(R.color.purple_700))
        // resources.getColor Fonksiyonu color dosyasına erişmemizi sağlıyor.

        setSupportActionBar(design.toolbar)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){

            R.id.action_bilgi -> {
               Toast.makeText(this@MainActivity,"Bilgi",Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_ayarlar -> {
               Toast.makeText(this@MainActivity,"Ayarlar",Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_ekle -> {
               Toast.makeText(this@MainActivity,"Eklendi",Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_çikis -> {
               finish()
                return true
            }
            else -> {
                return true
            }
        }
    }
}
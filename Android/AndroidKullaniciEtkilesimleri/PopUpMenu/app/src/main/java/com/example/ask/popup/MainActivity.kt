package com.example.ask.popup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import com.example.ask.popup.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var design:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        design = ActivityMainBinding.inflate(layoutInflater)
        setContentView(design.root)
        design.ac.setOnClickListener {
            val popup = PopupMenu(this@MainActivity,design.ac)
            popup.menuInflater.inflate(R.menu.popup_menu,popup.menu)
            // Kodsal olarak bir tasarımı bağlamak istediğimiz zaman layoutInflater kullandığımız gibi menu bağlamak için de menuInflater kullanırız.

            popup.setOnMenuItemClickListener {item ->
                when(item.itemId){

                    R.id.action_sil -> {
                        Toast.makeText(this,"Silindi...",Toast.LENGTH_SHORT).show()
                        true // Bu true değeri yukarıdaki listenera yollanıyor ve bu ifadeye tıklanıldığı sonucunu alıyor
                    }

                    R.id.action_duzenle -> {
                        Toast.makeText(this,"Düzenlendi...",Toast.LENGTH_SHORT).show()
                        true // Bu true değeri yukarıdaki listenera yollanıyor ve bu ifadeye tıklanıldığı sonucunu alıyor
                    }

                    else -> false
                }

            }

            popup.show()
        }
    }
}
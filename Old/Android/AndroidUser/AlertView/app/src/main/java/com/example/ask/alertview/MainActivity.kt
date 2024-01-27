package com.example.ask.alertview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.ask.alertview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var design:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        design= ActivityMainBinding.inflate(layoutInflater)
        setContentView(design.root)

        design.normalBtn.setOnClickListener {
            val ad=AlertDialog.Builder(this@MainActivity)
            ad.setMessage("Mesaj")
            ad.setTitle("Başlık")
            ad.setIcon(R.drawable.deneme_icon)
            ad.setPositiveButton("Tamam"){ dialogInterface, i ->

                Toast.makeText(applicationContext,"Tamam tıklanıldı",Toast.LENGTH_SHORT).show()

            }
            ad.setNegativeButton("İptal"){ dialogInterface, i ->

                Toast.makeText(applicationContext,"İptal tıklanıldı",Toast.LENGTH_SHORT).show()

            }
            ad.create().show()
        }

        design.ozelBtn.setOnClickListener {
            val ad=AlertDialog.Builder(this@MainActivity)
            ad.setMessage("Mesaj")
            ad.setTitle("Başlık")
            ad.setIcon(R.drawable.deneme_icon)
            var tasarim = layoutInflater.inflate(R.layout.alert_design,null)
            val editText = tasarim.findViewById(R.id.alertEditText) as EditText
            ad.setView(tasarim)
            // Root kısmına null dememizin amacı bunu başka bir tasarıma bağlamayacak olmamız...


            ad.setPositiveButton("Kaydet"){ dialogInterface, i ->

                Toast.makeText(applicationContext,"Kaydet tıklanıldı",Toast.LENGTH_SHORT).show()
                Log.e("Girilen Veri",editText.text.toString())

            }
            ad.setNegativeButton("İptal"){ dialogInterface, i ->

                Toast.makeText(applicationContext,"İptal tıklanıldı",Toast.LENGTH_SHORT).show()

            }
            ad.create().show()
        }
    }
}
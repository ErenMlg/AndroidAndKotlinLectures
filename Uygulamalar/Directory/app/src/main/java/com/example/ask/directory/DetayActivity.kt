package com.example.ask.directory

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import com.example.ask.directory.databinding.ActivityDetayBinding
import java.io.Serializable
import java.util.Objects

class DetayActivity : AppCompatActivity() {

    lateinit var detayDesign:ActivityDetayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detayDesign = ActivityDetayBinding.inflate(layoutInflater)
        setContentView(detayDesign.root)

        var gelenKelime = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("veri",Kelimeler::class.java)
        } else {
            intent.getParcelableExtra<Kelimeler>("veri")
        }

        detayDesign.englishDetailTxt.text = gelenKelime?.kelimeIng.toString()
        detayDesign.turkishDetailTxt.text = gelenKelime?.kelimeTr.toString()


    }
}
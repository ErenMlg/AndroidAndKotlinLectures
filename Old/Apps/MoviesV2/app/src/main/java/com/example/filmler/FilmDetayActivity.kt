package com.example.filmler

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.filmler.databinding.ActivityFilmDetayBinding

class FilmDetayActivity : AppCompatActivity() {

    lateinit var binding: ActivityFilmDetayBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilmDetayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val film = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("Film", Filmler::class.java)
        } else {
            intent.getParcelableExtra("Film")
        }

        with(binding) {
            filmAdDetay.text = film?.filmAd
            filmYil.text = film?.filmYil.toString()
            filmYonetmen.text = film?.yonetmen?.yonetmenAdi
            filmDetayResim.setImageResource(
                applicationContext.resources.getIdentifier(
                    film?.filmResim,
                    "drawable",
                    packageName
                )
            )
        }

    }
}
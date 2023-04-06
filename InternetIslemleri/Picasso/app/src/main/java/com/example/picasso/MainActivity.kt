package com.example.picasso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.picasso.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val url = "https://lavinya.net/wp-content/uploads/2022/11/5d6f55-sisli-gol-rihtiminda-gun-batimi-manzarasi-sunset-view-on-misty-lake-dock-scaled.jpeg"
            Picasso.get()
                .load(url)
                .resize(300,500)
                .rotate(90f)
                .placeholder(R.drawable.baseline_downloading_24)
                .error(R.drawable.baseline_error_24)
                .into(binding.imageView)
        }
    }
}
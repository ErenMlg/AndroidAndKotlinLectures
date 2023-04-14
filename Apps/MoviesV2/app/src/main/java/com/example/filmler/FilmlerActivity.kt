package com.example.filmler

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.filmler.databinding.ActivityFilmlerBinding

class FilmlerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFilmlerBinding
    private lateinit var adapter: FilmlerRVAdapter
    private lateinit var vt: VeritabaniYardimcisi

    private lateinit var filmler: ArrayList<Filmler>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilmlerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.mainTB2)

        val kategori = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("Kategori", Kategoriler::class.java)
        } else {
            intent.getParcelableExtra("Kategori")
        }
        vt = VeritabaniYardimcisi(this)
        filmler = FilmlerDao().kategoriyeGoreFilmler(vt,kategori)


        adapter = FilmlerRVAdapter(this, filmler)
        binding.filmlerRv.adapter = adapter
        binding.filmlerRv.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)


    }
}
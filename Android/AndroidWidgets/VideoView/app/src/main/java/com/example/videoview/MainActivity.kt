package com.example.videoview

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.videoview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    final lateinit var MainActivityBinding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(MainActivityBinding.root)

        MainActivityBinding.baslaBtn.setOnClickListener {
            var adress = Uri.parse("android.resource://"+packageName+"/"+R.raw.video)
            MainActivityBinding.videoView.setVideoURI(adress)
            MainActivityBinding.videoView.start()
        }

        MainActivityBinding.bitirBtn.setOnClickListener {

            MainActivityBinding.videoView.stopPlayback()

        }
    }
}
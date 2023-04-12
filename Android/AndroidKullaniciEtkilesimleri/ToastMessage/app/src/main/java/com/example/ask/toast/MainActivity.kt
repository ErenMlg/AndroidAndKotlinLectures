package com.example.ask.toast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import com.example.ask.toast.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var design:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        design = ActivityMainBinding.inflate(layoutInflater)
        setContentView(design.root)

        design.button.setOnClickListener {
            val tasarim = layoutInflater.inflate(R.layout.custom_toast,null)
            val textMessage = tasarim.findViewById(R.id.messageTxt) as TextView
            val toastOzel = Toast(this)
            toastOzel.view = tasarim // Kullanılmamaktadır.
            toastOzel.setGravity(Gravity.CENTER_HORIZONTAL or Gravity.CENTER_VERTICAL,0,0)
            toastOzel.duration = Toast.LENGTH_SHORT
            toastOzel.show()
        }
    }
}
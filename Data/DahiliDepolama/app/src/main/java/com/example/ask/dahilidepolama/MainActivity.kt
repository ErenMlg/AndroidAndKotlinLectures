package com.example.ask.dahilidepolama

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ask.dahilidepolama.databinding.ActivityMainBinding
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class MainActivity : AppCompatActivity() {

    lateinit var mainDesign:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainDesign = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainDesign.root)
        // Cache ve Files dosyası kullanılır ancak genellikle Files kullanılır.
        // Cache dosyası 1MB den fazla yer kaplarsa otomatik olarak silinir.

        mainDesign.okuBtn.setOnClickListener {
            dahiliOku()
        }
        mainDesign.yazBtn.setOnClickListener {
            dahiliYaz()
        }
        mainDesign.silBtn.setOnClickListener {
            dahiliSil()
        }
    }

    fun dahiliYaz(){
        try {

            val fo = openFileOutput("dosyam.txt", Context.MODE_PRIVATE)
            //Harici dosya ile aynı isimde olabilir,    Dosya önemli demek en son sil.
            val wrtr = OutputStreamWriter(fo)
            wrtr.write(mainDesign.editTxt.text.toString())
            wrtr.close()
            mainDesign.editTxt.setText("")

        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    fun dahiliOku(){
        try {
            val fi = openFileInput("dosyam.txt")
            val isr = InputStreamReader(fi)
            val rdr = BufferedReader(isr)

            val sb = StringBuilder()
            var satir:String?=null
            var satirCount:Int = 0

            while ({satir = rdr.readLine();satir}() != null){
                satirCount++
                if (satirCount == 1){
                    sb.append(satir)
                }else{
                    sb.append(satir+"\n")
                }
            }
            rdr.close()
            mainDesign.editTxt.setText(sb.toString())

        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    fun dahiliSil(){
        val dir = filesDir
        val dosya = File(dir,"dosyam.txt")
        dosya.delete()
    }


}
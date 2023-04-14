package com.example.ask.haricidepolama

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ask.haricidepolama.databinding.ActivityMainBinding
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.FileReader
import java.io.FileWriter

class MainActivity : AppCompatActivity() {

    lateinit var baseDesign:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        baseDesign = ActivityMainBinding.inflate(layoutInflater)
        setContentView(baseDesign.root)
        // Harici depolama : Telefonun dosya sistemine yaptığımız kayıtlar, java.io sınıfı ile yapılır

        baseDesign.yazBtn.setOnClickListener {
            hariciYaz()
        }
        baseDesign.okuBtn.setOnClickListener {
            hariciOku()
        }
        baseDesign.silBtn.setOnClickListener {
            hariciSil()
        }
    }
        // Java.io işlemlerinde(Okuma,Yazma, vb.) hata olma ihtimalı yüksek olduğundan try-catch kullanıyoruz

        fun hariciYaz(){

            try{
                checkPermissions(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                val path = applicationContext.getExternalFilesDir(null)?.absolutePath
                // Dosya yolunu tanımladık ve dosyayı yazılımsal olarak oluşturduk
                val file = File(path,"dosyam.txt")

                if(!file.exists()){
                    file.createNewFile()
                    //Dosyayı fiziki oluşturduk
                }

                val fw = FileWriter(file)
                val bw = BufferedWriter(fw)
                // BufferedWriterın performansı FileWriterdan daha iyi olduğundan böyle yapıyoruz.

                bw.write(baseDesign.editTxt.text.toString())
                baseDesign.editTxt.setText("")
                //yazma ve okuma işlemi olduktan sonra java.io aralarında bir bağlantı oluşturuyor
                bw.close()
                fw.close()
                //Yukarıdaki bağlantıları kapatmamızı sağlıyor eğer kapatmaz isek performansı düşürebilir.
                fw.flush()
                // Yazma işleminde hata olursa kalan yazma işlemini bir anda yazmaya çalışıyor.


            }catch (e:Exception){
                e.printStackTrace()
            }
        }
        fun hariciOku(){
            try{
                checkPermissions(android.Manifest.permission.READ_EXTERNAL_STORAGE)
                val path = applicationContext.getExternalFilesDir(null)?.absolutePath
                // Dosya yolunu tanımladık ve dosyayı oluşturduk
                val file = File(path,"dosyam.txt")

                val fr = FileReader(file)
                val br = BufferedReader(fr)

                // Dosya okuma işlemi tek tek satır satır okuduğundan dolayı bunları birleştirmemiz için aşağıdaki sınıfı kullanıyoruz.
                val sb = StringBuilder()

                var rowTxt:String? = null
                var rowCalculator:Int = 0

                while ({rowTxt = br.readLine();rowTxt}() != null){
                    //Satır satır okuyacağım ve rowTxt değişkenine aktaracağım eğer null değilse devam edecek
                    rowCalculator++
                    if (rowCalculator==1){
                        sb.append(rowTxt)
                    }else{
                        sb.append(rowTxt+"\n")
                    }
                }

                br.close()
                baseDesign.editTxt.setText(sb.toString())

            }catch (e:Exception){
                e.printStackTrace()
            }
        }
        fun hariciSil(){

            val path = applicationContext.getExternalFilesDir(null)?.absolutePath
            // Dosya yolunu tanımladık ve dosyayı oluşturduk
            val file = File(path,"dosyam.txt")

            file.delete()
            //Silme işlemini gerçekleştirdik

        }
        fun checkPermissions(permission: String) {
            if (checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED) {
                if (permission == android.Manifest.permission.WRITE_EXTERNAL_STORAGE) {
                    hariciYaz()
                }else if (permission == android.Manifest.permission.READ_EXTERNAL_STORAGE) {
                    hariciOku()
                }
            }else{
                requestPermissions(arrayOf(permission), 100) // izin yoksa sistemden uygulamamız için izin istiyoruz.
            }
        }
    }

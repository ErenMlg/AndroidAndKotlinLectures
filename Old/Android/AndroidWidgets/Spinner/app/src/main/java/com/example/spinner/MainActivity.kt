package com.example.spinner

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import com.example.spinner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    final lateinit var mainDesign:ActivityMainBinding
    private val ulkeler = ArrayList<String>()
    private lateinit var veriAdapter:ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainDesign = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainDesign.root)

        ulkeler.add("Ülke Seçiniz...")
        ulkeler.add("Türkiye")
        ulkeler.add("Almanya")
        ulkeler.add("Japonya")
        ulkeler.add("Fransa")
        ulkeler.add("İspanya")
        ulkeler.add("Çin")
        ulkeler.add("Rusya")
        ulkeler.add("Hindistan")
        ulkeler.add("ABD")

        veriAdapter = object : ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,ulkeler){
            //Context, Liste Modeli, Yazı Modeli, Veri Kümesi
            override fun isEnabled(position: Int): Boolean {
                // Disable the first item from Spinner
                return position !=0
            }

            override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup
            ): View {
                val view : TextView = super.getDropDownView(position, convertView, parent) as TextView
                if(position==0){
                    //set the color of first item in the drop down list to gray
                    view.setTextColor(Color.GRAY)
                }
                return view
            }

        }

        mainDesign.spinner.adapter = veriAdapter

        mainDesign.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {                         // position : seçilen elemanın indexi
                //Seçim yapıldığında yapılacaklar
                val value = parent!!.getItemAtPosition(position).toString()
                if(value==ulkeler[0]){
                    // Set the ground color for first item
                    (view as TextView).setTextColor(Color.GRAY)
                }
                if(position > 0){
                    Toast.makeText(this@MainActivity,"Seçilen Ülke ${ulkeler[position]}",Toast.LENGTH_SHORT).show()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //Hiçbir seçim yapılmadığında yapılacaklar
                Toast.makeText(this@MainActivity,"Seçim Yapmadınız..",Toast.LENGTH_SHORT).show()
            }
        }

        mainDesign.button.setOnClickListener {
            Toast.makeText(this@MainActivity,"Kaydedilen Ülke ${ulkeler[mainDesign.spinner.selectedItemPosition]}",Toast.LENGTH_SHORT).show()
        }
    }
}
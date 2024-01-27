package com.example.datetimepicker

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.datetimepicker.databinding.ActivityMainBinding
import java.util.Calendar
import kotlin.math.min

class MainActivity : AppCompatActivity() {

    final lateinit var mainDesign:ActivityMainBinding
    val calendar = Calendar.getInstance()
    var hour = calendar.get(Calendar.HOUR_OF_DAY) // 24 Saatlik dilime göre
    // val hour = calendar.get(Calendar.HOUR) 12 Saatlik dilime göre
    var minute = calendar.get(Calendar.MINUTE)
    var year = calendar.get(Calendar.YEAR)
    var month = calendar.get(Calendar.MONTH)
    var day = calendar.get(Calendar.DAY_OF_MONTH)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainDesign = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainDesign.root)

        mainDesign.editTextClock.setOnClickListener{
            val timePicker = TimePickerDialog(this@MainActivity,TimePickerDialog.OnTimeSetListener { view, hourOfDay, minuteOfNow ->
                mainDesign.editTextClock.setText("$hourOfDay:$minuteOfNow")
                hour=hourOfDay
                minute=minuteOfNow // Bu iki satır, saat bir daha açıldığı zaman son seçilen saati göstermesini sağlar
            },hour, minute,true)

            timePicker.setTitle("Saat Seçiniz..")
            timePicker.setButton(DialogInterface.BUTTON_POSITIVE,"AYARLA",timePicker)
            timePicker.setButton(DialogInterface.BUTTON_NEGATIVE,"İPTAL",timePicker)
            timePicker.show()
        }
        mainDesign.editTextDate.setOnClickListener{
            val datePicker = DatePickerDialog(this@MainActivity,DatePickerDialog.OnDateSetListener { view, y, m, d ->
                mainDesign.editTextDate.setText("$d/${m+1}/$y")
                year = y;
                month = m;
                day = d;
            },year,month,day)

            datePicker.setTitle("Tarih Seçiniz..")
            datePicker.setButton(DialogInterface.BUTTON_POSITIVE,"SEÇ",datePicker)
            datePicker.setButton(DialogInterface.BUTTON_NEGATIVE,"İPTAL",datePicker)
            datePicker.show()
        }
    }
}
package com.example.kisiler.util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

/*
2 adet oluşturarak fonksiyonu genişlettik, adapterdaki geçiş için NavDirections kısmı çalışıcak

 */
fun Navigation.gecisYap(it: View, id: Int) {
    findNavController(it).navigate(id)
}

fun Navigation.gecisYap(it: View, id: NavDirections) {
    findNavController(it).navigate(id)
}
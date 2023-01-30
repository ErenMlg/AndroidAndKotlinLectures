package com.example.kosullarvb

import java.util.Scanner

fun main(){
    val girdi = Scanner(System.`in`)

    print("İşlenecek Veri Miktarını giriniz : ")
    val veriAdeti = girdi.nextInt()

    var verilerDizisi = ArrayList<Int>();
    var i=1
    while (i<=veriAdeti){
        print("$i.Veriyi Giriniz : ")
        verilerDizisi.add(girdi.nextInt())
        i++
    }
    println("Verileriniz;")
    for (deger in 0 until verilerDizisi.size ){
        println(verilerDizisi[deger])
    }
}
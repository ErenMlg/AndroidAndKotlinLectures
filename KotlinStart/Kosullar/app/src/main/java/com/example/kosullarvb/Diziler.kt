package com.example.kosullarvb

import java.util.*
import kotlin.collections.ArrayList

fun main(){
    val girdi = Scanner(System.`in`)
    val meyveler = arrayOf("Kivi","Elma","Armut","Mandalina")
    println(meyveler.size)
    println(meyveler.max())
    println(meyveler.min())
    println(meyveler.indexOf("Kivi"))
    println(meyveler.sort())
    println(meyveler.contentToString())
    println(meyveler.contains("Eşşek"))
    println("${meyveler.reverse()}\n${meyveler.contentToString()}")
    meyveler.set(1,"Yer Elması")
    meyveler[3]="Portakal"
    println(meyveler.contentToString())

    for(meyve in meyveler){
        println("Sonuç : $meyve")
    }

    for((index,meyve) in meyveler.withIndex()){
        println("Sonuç : $meyve\nİndex : $index")
    }

    val dersler = Array<String>(5){""}
    val notlar = Array<Int>(5){0}
    var ortalama=0

    for (index in 1..5){
        print("$index.Dersin Adını Giriniz : ")
        dersler[index-1]=girdi.next()
        print("$index.Dersin Notunu Giriniz : ")
        notlar[index-1]=girdi.nextInt()
        ortalama += notlar[index-1]
    }
    if((ortalama/5)>=50){
        println("Geçtiniz... :)")
    }else{
        println("Kaldınız... :(")
    }

}
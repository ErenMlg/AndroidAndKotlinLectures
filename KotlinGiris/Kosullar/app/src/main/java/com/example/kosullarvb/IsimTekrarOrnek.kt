package com.example.kosullarvb

import java.util.Scanner

fun main(){
    val giris = Scanner(System.`in`)

    print("Bir isim giriniz : ")
    val isim = giris.next()
    print("Bu ismi kaç kere tekrarlamak istersiniz : ")
    val tekrar = giris.nextInt()

    println("-----------------------------------\nFor Döngüsü\n-----------------------------------")
    for(deger in 1..tekrar){
        println("$deger.$isim")
    }

    println("-----------------------------------\nWhile Döngüsü\n-----------------------------------")
    var i=1;
    while (i<=tekrar){
        println("$i.$isim")
        i++
    }
}

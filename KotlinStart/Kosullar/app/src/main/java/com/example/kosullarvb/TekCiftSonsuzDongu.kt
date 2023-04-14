package com.example.kosullarvb

import java.util.Scanner

fun main(){
    val girdi = Scanner(System.`in`)
    while(true){
        print("Tek mi Çift mi öğrenmek için sayı giriniz : ")
        val sayi = girdi.nextInt()
        when(sayi%2){
            0 -> println("Sayı Çifttir")
            1 -> println("Sayı Tektir")
        }

        print("Çıkmak için (1) - Devam etmek için (2) : ")
        val secim=girdi.nextInt()
        if(secim==1){
            break;
        }else{
            continue; // Kullanılmasa da olur
        }
    }
}
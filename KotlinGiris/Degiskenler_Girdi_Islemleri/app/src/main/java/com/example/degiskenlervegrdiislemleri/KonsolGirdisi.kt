package com.example.degiskenlervegrdiislemleri

import java.util.Scanner

fun main(){

    print("Adınızı giriniz : ")
    val girdi = Scanner(System.`in`)
    val ad = girdi.next()
    print("Adınız $ad mı?\n(E/H) : ")
    val onay = Scanner(System.`in`).next()
    if(onay=="E"){
        println("Girişiniz Onaylandı, İyi Günler...")
    }else{
        println("Hatalı Giriş Yaptınız...")
    }
}
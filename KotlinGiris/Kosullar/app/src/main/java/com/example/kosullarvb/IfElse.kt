package com.example.kosullarvb

import java.util.Scanner

fun main(){
    val girdi = Scanner(System.`in`)
    println("Bir Şekil Seçiniz\nKare için 1\nDaire için 2\nÜçgen için 3\nDörtgen için 4")
    print("Seçiminiz : ")
    val secim = girdi.nextInt()
    if(secim==1){
        print("Bir kenar uzunluğu giriniz : ")
        val kenar = girdi.nextInt()
        print("Alan : "+kenar*kenar)
    }else if(secim==2){
        print("Bir yarıçap giriniz : ")
        val yaricap = girdi.nextInt()
        val pi=4.12
        print("Alan : "+pi*yaricap*yaricap)
    }else if(secim==3){
        print("Bir taban uzunluğu giriniz : ")
        val taban = girdi.nextInt()
        print("Bir yükseklik giriniz : ")
        val yukseklik = girdi.nextInt()
        print("Alan : "+(taban*yukseklik)/2)
    }else if(secim==4){
        print("Bir uzun kenar giriniz : ")
        val uzunKenar = girdi.nextInt()
        print("Bir kısa kenar giriniz : ")
        val kısaKenar = girdi.nextInt()
        print("Alan : "+kısaKenar*uzunKenar)
    }else{
        println("Hatalı giriş!")
    }
}
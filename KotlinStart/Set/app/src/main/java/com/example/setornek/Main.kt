package com.example.setornek

fun main(){
    val o1 = Ogrenci(1,"Ahmet","11A")
    val o3 = Ogrenci(2,"Sude","10C")
    val o2 = Ogrenci(4,"Ayşe","12D")
    val o4 = Ogrenci(3,"Mehmet","9B")

    val ogreciler = HashSet<Ogrenci>()
    ogreciler.add(o2)
    ogreciler.add(o1)
    ogreciler.add(o4)
    ogreciler.add(o3)

    val ogrencilerMap = HashMap<Int,Ogrenci>()
    ogrencilerMap.put(o1.no,o1)
    ogrencilerMap.put(o2.no,o2)
    ogrencilerMap[o3.no] = o3
    ogrencilerMap[o4.no] = o4

    println("*********************")
    for(ogrenci in ogreciler){
        println("Numara : ${ogrenci.no}\nAd : ${ogrenci.ad}\nSınıf : ${ogrenci.sinif}\n*********************")
    }

    println("HashMap\n*********************")
    for(ogrenci in ogrencilerMap){
        println("Numara : ${ogrenci.value.no}\nAd : ${ogrenci.value.ad}\nSınıf : ${ogrenci.value.sinif}\n*********************")
    }
}

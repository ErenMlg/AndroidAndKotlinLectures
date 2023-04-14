package com.example.nesne_yonelik_programlama

fun main(){
    var k1 = Kategori(1,"Korku")
    var k2 = Kategori(2,"Gerilim")
    var k3 = Kategori(3,"Aksiyon")

    var y1 = Yonetmen(1,"Nuri Bilge Ceylan")
    var y2 = Yonetmen(1,"Quentin Tarantino")

    var film1 = Filmler(1, "Django",2003,k3,y2)
    var film2 = Filmler(1, "Korku Kapanı",2000,k1,y1)

}

package com.example.ask.hazirveritabanikullanma

data class filmler(var film_id:Int,
                   var film_ad:String,
                   var film_yıl:Int,
                   var film_resim:String,
                   var kategori: kategoriler,
                   var yonetmen: yonetmenler){

}

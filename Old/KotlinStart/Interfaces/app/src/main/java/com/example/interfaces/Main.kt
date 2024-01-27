package com.example.interfaces

fun main(){
    val aslan = Aslan()
    val amasyaElmasi:Elma = AmasyaElmasi()
    val elma = Elma()
    val tavuk:Yenilebilir = Tavuk()

    val nesneler = arrayOf(aslan,amasyaElmasi,elma,tavuk)
    for(nesne in nesneler){
        if (nesne is Yenilebilir){
            nesne.nasilYenilir()
        }else if(nesne is Sikilabilir){
            nesne.nasilSikilir()
        }else{
            println("Nesne hem yenilemez hem sıkılamaz.")
        }
    }
}
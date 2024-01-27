package com.example.kosullarvb

fun main(){
    val test = ArrayList<String>();
    test.add("Eren")
    test.add("Ceren")
    test.add("Emre")

    for(deger in 0 until test.size){
        println(test[deger])
    }

    for(deger in 10 downTo  0 step 2){
        println(deger)
    }
}
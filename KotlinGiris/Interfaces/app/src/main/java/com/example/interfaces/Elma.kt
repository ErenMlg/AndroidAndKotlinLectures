package com.example.interfaces

open class Elma:Yenilebilir,Sikilabilir {
    override fun nasilYenilir() {
        println("ELmayı dilimleyip yiyebilirsin.")
    }

    override fun nasilSikilir() {
        println("ELmayı blendıra atıp sıkabilir suyunu içebilirsin.")
    }
}
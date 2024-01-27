package com.example.setornek

class Ogrenci(var no:Int, var ad:String, var sinif:String) {
    override fun hashCode(): Int {
        return this.no // Hash içerisinde no'ya göre ekleme yapacağını belirtir.
    }

    override fun equals(other: Any?): Boolean { // Hash yapısında aynı nodan eleman var mı kontrol eder.
        if(this.no == (other as Ogrenci).no){
            return true
        }else{
            return false
        }
    }
}
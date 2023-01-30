package com.example.nesne_yonelik_programlama

fun main(){

    fun tempConvert(celcius: Double): Double {
        return (celcius * 1.8) + 32
    }

    fun rectanglePerimeter(longEdge:Double, shortEdge:Double):Double {
        return (longEdge*2)+(shortEdge*2)
    }

    fun factorielCalc(number:Int):Int{
        var result=1;
        var fact = number;
        while (fact>=1){
            result*=fact
            fact--
        }
        return result
    }

    fun wordsCalc(message:String, searchKey:Char):Int{
        var result=0
        for(key in message.lowercase()){ // Büyük küçük harf duyarlı olduğu için lowercase yaptım.
            if (key==searchKey){
                result++
            }
        }
        return result
    }

    fun anglesCalc(edgeNumber:Int){
        println("İç açılar toplamı ${(edgeNumber-2)*180}'dır.")
    }

    fun salaryCalc(workedDay:Int){
        var salary = workedDay*8*10
        val workedHour = workedDay*8
        if (workedHour>160){
            salary = ((workedHour-160)*20) + (160*10)
        }
        println("Çalışılan gün sayisi $workedDay,\nÇalışılan saat sayısı ${workedDay*8}\nMaaş $salary TL")
    }

    fun overQuotaCalc(quata:Int){
        var amount=100
        if(quata>50){
            amount+=(quata-50)*4
        }
        println("Harcanılan kota miktarı $quata GB, ödenecek tutar $amount TL")
    }

    println("İnsanın normal vücut sıcaklığı 27 derecedir bu da ${tempConvert(27.0)} Fahrenayta denk gelir.")
    println("Kenarları 3 ve 5 olan bir dikdörtgenin çevresi ${rectanglePerimeter(3.0,5.0)}'dir.")
    println("4 Sayısının faktöriyeli ${factorielCalc(4)}'dir.")
    println("Eren adının içerisinde ${wordsCalc("Eren",'e')} adet 'E' harfi geçer.")
    anglesCalc(3)
    salaryCalc(30)
    overQuotaCalc(55)
}
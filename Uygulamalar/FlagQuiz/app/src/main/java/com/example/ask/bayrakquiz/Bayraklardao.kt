package com.example.ask.bayrakquiz

class Bayraklardao {

    fun rastgele10BayrakGetir(vtHelper:VeritabaniYardimcisi) : ArrayList<Bayraklar>{
        var rastgeleOlusanBayraklar = ArrayList<Bayraklar>()
        var vt = vtHelper.writableDatabase
        var cursor = vt.rawQuery("SELECT * FROM bayraklar ORDER BY RANDOM() LIMIT 10",null)
        while (cursor.moveToNext()){
            var bayrak = Bayraklar(cursor.getInt(cursor.getColumnIndexOrThrow("bayrak_id")),
                cursor.getString(cursor.getColumnIndexOrThrow("bayrak_ad")),
                cursor.getString(cursor.getColumnIndexOrThrow("bayrak_resim")))
            rastgeleOlusanBayraklar.add(bayrak)
        }
        return rastgeleOlusanBayraklar
    }

    fun rastgele3YanlisSecenekGetir(vtHelper:VeritabaniYardimcisi, bayrak_id:Int):ArrayList<Bayraklar>{
        var rastgeleOlusanYanlisSecenekler = ArrayList<Bayraklar>()
        var vt = vtHelper.writableDatabase
        var cursor = vt.rawQuery("SELECT * FROM bayraklar WHERE bayrak_id != $bayrak_id ORDER BY RANDOM() LIMIT 3",null)

        while (cursor.moveToNext()){
            var yanlisCevap = Bayraklar(cursor.getInt(cursor.getColumnIndexOrThrow("bayrak_id")),
                cursor.getString(cursor.getColumnIndexOrThrow("bayrak_ad")),
                cursor.getString(cursor.getColumnIndexOrThrow("bayrak_resim")))
            rastgeleOlusanYanlisSecenekler.add(yanlisCevap)
        }
        return rastgeleOlusanYanlisSecenekler
    }


}
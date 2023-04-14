package com.example.ask.preferencesdatastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

class AppPref(var context:Context) {
    val Context.ds : DataStore<Preferences> by preferencesDataStore("bilgiler")
    //Dosyamızı oluşturduk, Contexten extension fonksiyon kullanarak ds'i oluşturduk

    companion object{
    //Statik method oluşturuyoruz
        val AD_KEY = stringPreferencesKey("AD")
    }

    suspend fun kayitAd(ad:String) {
        /*
        * Coroutin: Thread tarafından yürütülen görev parçalarıdır
        * Suspend fun ise çalışmak için bir coroutunin içinde çalışır ve bekleme durdurma gibi durumlara karşılık verebilir
        * Coroutin ile asenkron çalışmasını sağlar
        */

        context.ds.edit {
            it[AD_KEY] = ad
            //Kayıt etme işlemi
        }
    }

    suspend fun okuAd():String{
        val p = context.ds.data.first()
        return p[AD_KEY] ?: "Null"
        //Okuma işlemi
    }

    suspend fun silAd() {
        context.ds.edit {
            it.remove(AD_KEY)
            //Silme işlemi
        }
    }

}
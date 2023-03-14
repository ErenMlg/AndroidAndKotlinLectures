package com.example.ask.sayac

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

class AppPref(var context:Context) {
    val Context.ds : DataStore<Preferences> by preferencesDataStore("Sayac")

    companion object{
        val SAYAC_KEY = intPreferencesKey("SAYAC")
    }

    suspend fun sayacEkle(sayac:Int){
        context.ds.edit {
            it[SAYAC_KEY] = sayac
        }
    }

    suspend fun sayacOku():Int{
        val read = context.ds.data.first()
        return read[SAYAC_KEY] ?: 0
    }

}
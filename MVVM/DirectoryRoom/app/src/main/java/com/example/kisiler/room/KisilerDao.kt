package com.example.kisiler.room

import androidx.room.*
import com.example.kisiler.data.entity.Kisiler

@Dao
interface KisilerDao {

    // Veritabanından sorgu yaptırdık
    @Query("SELECT * FROM kisiler")
    suspend fun tumKisiler() : List<Kisiler>

    @Delete
    suspend fun kisiSil(kisi:Kisiler)

    @Update
    suspend fun kisiGuncelle(kisi:Kisiler)

    @Insert
    suspend fun kisiEkle(kisi:Kisiler)

    @Query("SELECT * FROM kisiler WHERE kisi_ad like '%' || :key || '%'")
    suspend fun kisiAra(key:String) : List<Kisiler>

}
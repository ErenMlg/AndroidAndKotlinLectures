package com.example.room

import androidx.room.*

@Dao
interface KisilerDao {

    @Query("SELECT * FROM kisiler")
    suspend fun tumKisiler(): List<Kisiler>

    @Insert
    suspend fun kisiEkle(kisi: Kisiler)

    @Update
    suspend fun kisiGuncelle(kisi: Kisiler)

    @Delete
    suspend fun kisiSil(kisi: Kisiler)

    @Query("SELECT * FROM kisiler WHERE kisi_ad like '%' || :key || '%'")
    suspend fun kisiAra(key:String) : List<Kisiler>
}
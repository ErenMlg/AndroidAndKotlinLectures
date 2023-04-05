package com.example.retrofit

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface KisilerDaoInterface {

    @POST("delete_users.php")
    @FormUrlEncoded //Türkçe karakter desteği
    fun kisiSil(@Field("kisi_id") kisi_id: Int): Call<CRUDCevap>
    // Field içerisindeki alana değişkendeki veriyi yollamış oluyoruz

    @POST("insert_users.php")
    @FormUrlEncoded
    fun kisiEkle(
        @Field("kisi_ad") kisi_ad: String,
        @Field("kisi_tel") kisi_tel: String
    ): Call<CRUDCevap>


    @POST("update_user.php")
    @FormUrlEncoded
    fun kisiGuncelle(
        @Field("kisi_id") kisi_id: Int,
        @Field("kisi_ad") kisi_ad: String,
        @Field("kisi_tel") kisi_tel: String
    ): Call<CRUDCevap>


    @GET("tum_kisiler.php")
    fun tumKisiler(): Call<KisilerCevap>

    @POST("tum_kisiler_arama.php")
    @FormUrlEncoded
    fun tumKisilerArama(@Field("kisi_ad") kisi_ad: String): Call<KisilerCevap>
}
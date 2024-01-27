package com.softcross.customapidemo

import retrofit2.Call
import retrofit2.http.GET

interface CharactersDaoInterface {


    @GET("characters")
    fun allCharacters(): Call<CharactersList>



}
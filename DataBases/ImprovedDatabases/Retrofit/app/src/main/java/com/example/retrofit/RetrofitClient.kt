package com.example.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {

        fun getClient(baseURL: String): Retrofit {

            return Retrofit.Builder().baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create()).build()
            //GsonConverterFactory JSON convert işlemini otomatik yapar
        }

    }

}
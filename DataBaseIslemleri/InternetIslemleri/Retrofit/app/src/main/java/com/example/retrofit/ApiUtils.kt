package com.example.retrofit

class ApiUtils {

    companion object {

        val BASE_URL = "http://192.168.1.106/PHP_WebService/"

        fun getKisilerDaoInterface(): KisilerDaoInterface {
            return RetrofitClient.getClient(BASE_URL).create(KisilerDaoInterface::class.java)
        }
    }

}
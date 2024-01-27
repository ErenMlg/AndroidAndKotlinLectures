package com.softcross.customapidemo

class AppUtils {

    companion object {

        val BASE_URL = "http://192.168.38.243:8000/"

        fun getCharactersDaoInterface(): CharactersDaoInterface =
            RetrofitClient.getClient(BASE_URL).create(CharactersDaoInterface::class.java)

    }

}
package com.softcross.customapidemo

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        allCharacters()
    }

    private fun allCharacters() {

        val kdi = AppUtils.getCharactersDaoInterface()
        kdi.allCharacters().enqueue(object : Callback<CharactersList> {
            override fun onResponse(
                call: Call<CharactersList>,
                response: Response<CharactersList>
            ) {

                if (response != null) {
                    val charctersList = response.body()!!.charactersList
                    for (character in charctersList) {
                        Toast.makeText(
                            this@MainActivity,
                            character.characterName,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }else{
                    Toast.makeText(
                        this@MainActivity,
                        "Veri Çekilemedi",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }

            override fun onFailure(call: Call<CharactersList>, t: Throwable) {
                Toast.makeText(
                    this@MainActivity,
                    t.message,
                    Toast.LENGTH_LONG
                ).show()
                t.message?.let { Log.e("Error:", it) }
            }

        })

    }

}
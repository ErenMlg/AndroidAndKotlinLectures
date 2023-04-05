package com.example.retrofit

import android.app.appsearch.SearchResult
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private val kdi = ApiUtils.getKisilerDaoInterface()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //kisiSil()
        //kisiEkle()
        //kisiGuncelle()
        //tumKisiler()
        kisiArama()
    }

    fun kisiSil() {
        kdi.kisiSil(1).enqueue(object : Callback<CRUDCevap> {
            override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>?) {
                if (response != null) {
                    Log.e(
                        "Cevap ",
                        response.body().sucsess.toString() + " Mesaj : " + response.body().message
                    )
                } else {
                    Log.e("Cevap", " Null")
                }
            }

            override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {

            }
        })
    }

    fun kisiEkle() {
        kdi.kisiEkle("Eren", "05301138818").enqueue(object : Callback<CRUDCevap> {
            override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>?) {
                if (response != null) {
                    Log.e(
                        "Cevap ",
                        response.body().sucsess.toString() + " Mesaj : " + response.body().message
                    )
                } else {
                    Log.e("Cevap", " Null")
                }
            }

            override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {}
        })

    }

    fun kisiGuncelle() {
        kdi.kisiGuncelle(4, "Çiğdem Oğurlu", "05334153533").enqueue(object : Callback<CRUDCevap> {
            override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>?) {
                if (response != null) {
                    Log.e(
                        "Güncelleme İşlemi ",
                        "${response.body().sucsess} Mesaj : ${response.body().sucsess}"
                    )
                } else {
                    Log.e("Cevap", " Null")
                }
            }

            override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {}

        })
    }

    fun tumKisiler() {
        kdi.tumKisiler().enqueue(object : Callback<KisilerCevap> {
            override fun onResponse(call: Call<KisilerCevap>?, response: Response<KisilerCevap>?) {
                if (response != null) {
                    val kisilerListe = response.body().kisiler

                    for (kisi in kisilerListe) {
                        Log.e(
                            "Kişi ",
                            "ID :${kisi.kisi_id}\nAD :${kisi.kisi_ad}\nTEL :${kisi.kisi_tel}"
                        )
                    }

                } else {
                    Log.e("Cevap", " Null")
                }
            }

            override fun onFailure(call: Call<KisilerCevap>?, t: Throwable?) {}
        })
    }

    fun kisiArama() {
        kdi.tumKisilerArama("Gülçin").enqueue(object : Callback<KisilerCevap> {
            override fun onResponse(call: Call<KisilerCevap>?, response: Response<KisilerCevap>?) {
                if (response != null) {
                    val searchResult = response.body().kisiler
                    for (kisi in searchResult) {
                        Log.e(
                            "Kişi ",
                            "ID :${kisi.kisi_id}\nAD :${kisi.kisi_ad}\nTEL :${kisi.kisi_tel}"
                        )
                    }
                }else{
                    Log.e("Cevap", " Null")
                }

            }

            override fun onFailure(call: Call<KisilerCevap>?, t: Throwable?) {}
        })
    }
}
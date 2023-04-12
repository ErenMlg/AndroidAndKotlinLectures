package com.example.volley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject
import java.util.Objects
import javax.net.ssl.SSLEngineResult.HandshakeStatus

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // kisiSil("3")
        // kisiEkle()
        // kisiGuncelle()
        //tumKisiler()
        kisiArama()
    }

    fun kisiSil(kisi_id: String) {
        val url = "http://192.168.1.106/PHP_WebService/delete_users.php"
        // Kullanacağımız URL

        //Sınıf yapısı oluşturup onu objecte aktarıp ardından objecti de istek değişkenine atadık
        val istek = object : StringRequest(
            // Veri gönderdiğimizde POST, aldığımızda GET
            Method.POST,
            // İşlem yapacağımız URL
            url,
            // Cevabı yakalamamız için bir listener oluşturdul
            Response.Listener { cevap -> Log.e("Silme ", cevap) },
            // Hatayı yakalamamız için bir listener oluşturduk
            Response.ErrorListener { hata -> hata.printStackTrace() }
        ) {
            override fun getParams(): MutableMap<String, String>? {
                // Veri gönderme işlemimizi yapıyoruz
                val params = HashMap<String, String>()
                params["kisi_id"] = kisi_id
                return params
            }
        }
        Volley.newRequestQueue(this@MainActivity).add(istek)
    }

    fun kisiEkle() {
        val url = "http://192.168.1.106/PHP_WebService/insert_users.php"
        val istek = object :
            StringRequest(Method.POST, url,
                Response.Listener { cevap -> Log.e("Cevap ", cevap) },
                Response.ErrorListener { hata -> hata.printStackTrace() }
            ) {
            override fun getParams(): MutableMap<String, String>? {
                val params = HashMap<String, String>()
                params["kisi_ad"] = "Ayşenur"
                params["kisi_tel"] = "05301324562"
                return params
            }
        }
        Volley.newRequestQueue(this@MainActivity).add(istek)
    }

    fun kisiGuncelle() {
        val url = "http://192.168.1.106/PHP_WebService/update_user.php"
        val istek = object : StringRequest(Method.POST, url,
            Response.Listener { cevap -> Log.e("Cevap ", cevap) },
            Response.ErrorListener { hata -> hata.printStackTrace() }) {
            override fun getParams(): MutableMap<String, String>? {
                var params = HashMap<String, String>()
                params["kisi_id"] = "6"
                params["kisi_ad"] = "Muhammet"
                params["kisi_tel"] = "05301134582"
                return params
            }
        }
        Volley.newRequestQueue(this@MainActivity).add(istek)
    }

    fun tumKisiler() {
        val url = "http://192.168.1.106/PHP_WebService/tum_kisiler.php"
        val istek = object : StringRequest(Method.GET, url,
            Response.Listener { cevap ->
                try {
                    // cevap olarak gelen kisiler JSONını Parse ediyoruz.
                    val jsonObject = JSONObject(cevap)
                    val kisiList = jsonObject.getJSONArray("kisiler")

                    for (i in 0 until kisiList.length()) {
                        val siradakiEleman = kisiList.getJSONObject(i)
                        val kisi_id = siradakiEleman.getInt("kisi_id")
                        val kisi_ad = siradakiEleman.getString("kisi_ad")
                        val kisi_tel = siradakiEleman.getString("kisi_tel")
                        Log.e("Kisi ", "$kisi_id $kisi_ad $kisi_tel")
                        Log.e("****", "****")
                    }
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            },
            Response.ErrorListener { error -> error.printStackTrace() }) {}

        Volley.newRequestQueue(this@MainActivity).add(istek)
    }

    fun kisiArama() {
        val url = "http://192.168.1.106/PHP_WebService/tum_kisiler_arama.php"
        val istek = object : StringRequest(Method.POST, url,
            Response.Listener { cevap ->
                try {
                    val jsonObject = JSONObject(cevap)
                    val kisiList = jsonObject.getJSONArray("kisiler")

                    for (i in 0 until kisiList.length()) {
                        val siradakiEleman = kisiList.getJSONObject(i)
                        val kisi_id = siradakiEleman.getInt("kisi_id")
                        val kisi_ad = siradakiEleman.getString("kisi_ad")
                        val kisi_tel = siradakiEleman.getString("kisi_tel")
                        Log.e("Kisi ", "$kisi_id $kisi_ad $kisi_tel")
                        Log.e("****", "****")
                    }
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            },
            Response.ErrorListener { error -> error.printStackTrace() }) {
            override fun getParams(): MutableMap<String, String>? {
                val params = HashMap<String, String>()
                params["kisi_ad"] = "E"
                return params
            }
        }
        Volley.newRequestQueue(this@MainActivity).add(istek)
    }
}
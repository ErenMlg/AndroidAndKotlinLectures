package com.example.cutebird.ui.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.cutebird.R
import com.example.cutebird.databinding.FragmentGameScreenBinding
import java.util.Timer
import kotlin.concurrent.schedule
import kotlin.math.floor

class GameScreenFragment : Fragment() {

    private lateinit var binding: FragmentGameScreenBinding

    //Pozisyonlar
    private var anakarakterX = 0.0f
    private var anakarakterY = 0.0f

    private var kargaX = -800.0f
    private var kargaY = -800.0f
    private var coinX = -800.0f
    private var coinY = -800.0f
    private var moneyX = -800.0f
    private var moneyY = -800.0f


    //Boyutlar
    private var ekranGenisligi = 0
    private var ekranYuksekligi = 0
    private var karakterGenisligi = 0
    private var karakterYuksekligi = 0
    private var odulGenisligi = 0

    //Kontroller
    private var dokunmaKontrol = true
    private var baslangicKontrol = false

    private val timer = Timer()
    private var skor = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game_screen, container, false)
        val karakter = binding.anaKarakterImg

        binding.cl.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                if (baslangicKontrol) {
                    if (event?.action == MotionEvent.ACTION_DOWN) {
                        dokunmaKontrol = true
                    } else if (event?.action == MotionEvent.ACTION_UP) {
                        dokunmaKontrol = false
                    }
                } else {
                    //Eğer bu şekilde başlangıç kontrolü yapmazsak her basıldığında timer tekrar çalışır
                    binding.oyunBaslaTxt.visibility = View.INVISIBLE
                    baslangicKontrol = true
                    anakarakterX = karakter.x
                    anakarakterY = karakter.y

                    karakterGenisligi = karakter.width
                    karakterYuksekligi = karakter.height
                    ekranGenisligi = binding.cl.width
                    ekranYuksekligi = binding.cl.height
                    odulGenisligi = binding.coinBagImg.width

                    //0 delay 20 hangi aralıklarla çalışıcağı
                    timer.schedule(0, 20) {
                        Handler(Looper.getMainLooper()).post {
                            anakarakterHareketEttirme()
                            cisimleriHareketEttirme()
                            carpismaKontrol()
                        }
                    }
                }
                return true
            }
        })
        return binding.root
    }

    fun anakarakterHareketEttirme() {

        val anakarakterHiz = ekranYuksekligi / 60.0f

        if (dokunmaKontrol) {
            anakarakterY -= anakarakterHiz
        } else {
            anakarakterY += anakarakterHiz
        }
        binding.anaKarakterImg.y = anakarakterY
        if (anakarakterY <= 0.0f) {
            anakarakterY = 0.0f
        } else if (anakarakterY >= ekranYuksekligi - karakterYuksekligi) {
            anakarakterY = (ekranYuksekligi - karakterYuksekligi).toFloat()
        }
    }

    fun cisimleriHareketEttirme() {
        // Tüm ekranlarda hızın sabit bir değer olması açısından bu şekil işlem yapıyoruz
        kargaX -= ekranGenisligi / 44.0f
        coinX -= ekranGenisligi / 54.0f
        moneyX -= ekranGenisligi / 36.0f

        if (kargaX < 0.0f - karakterGenisligi) {
            kargaX = ekranGenisligi + 20.0f
            kargaY = floor(Math.random() * ekranYuksekligi).toFloat()
        }
        binding.crowImg.x = kargaX
        binding.crowImg.y = kargaY

        if (coinX < 0.0f - odulGenisligi) {
            coinX = ekranGenisligi + 20.0f
            coinY = floor(Math.random() * ekranYuksekligi).toFloat()
        }
        binding.coinImg.x = coinX
        binding.coinImg.y = coinY

        if (moneyX < 0.0f - odulGenisligi) {
            moneyX = ekranGenisligi + 20.0f
            moneyY = floor(Math.random() * ekranYuksekligi).toFloat()
        }
        binding.coinBagImg.x = moneyX
        binding.coinBagImg.y = moneyY
    }

    fun carpismaKontrol() {
        val coinMerkezX = coinX + binding.coinImg.width / 2.0f
        val coinMerkezY = coinY + binding.coinImg.height / 2.0f

        if (0.0f <= coinMerkezX
            && coinMerkezX <= karakterGenisligi
            && anakarakterY <= coinMerkezY
            && coinMerkezY <= anakarakterY + karakterYuksekligi
        ){
            skor+=50
            coinX = ekranGenisligi + 20.0f
        }

        val moneyMerkezX = moneyX + binding.coinBagImg.width / 2.0f
        val moneyMerkezY = moneyY + binding.coinBagImg.height / 2.0f

        if (0.0f <= moneyMerkezX
            && moneyMerkezX <= karakterGenisligi
            && anakarakterY <= moneyMerkezY
            && moneyMerkezY <= anakarakterY + karakterYuksekligi
        ){
            skor+=100
            moneyX = ekranGenisligi + 20.0f
        }

        val kargaMerkezX = kargaX + binding.crowImg.width / 2.0f
        val kargaMerkezY = kargaY + binding.crowImg.height / 2.0f

        if (0.0f <= kargaMerkezX
            && kargaMerkezX <= karakterGenisligi
            && anakarakterY <= kargaMerkezY
            && kargaMerkezY <= anakarakterY + karakterYuksekligi
        ){
            kargaX = ekranGenisligi + 20.0f
            timer.cancel()
            val bundle = Bundle()
            bundle.putInt("skor",skor)
            Navigation.findNavController(binding.cl).navigate(R.id.finishToGame, bundle)
        }

        binding.skorTxt.text = skor.toString()

    }

}
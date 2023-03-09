package com.example.ask.tablayouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.ask.tablayouts.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private val fragmentList=ArrayList<Fragment>()
    private val fragmentBaslikListesi=ArrayList<String>()
    lateinit var design: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        design= ActivityMainBinding.inflate(layoutInflater)
        setContentView(design.root)

        fragmentList.add(FragmentBir())
        fragmentList.add(FragmentIki())
        fragmentList.add(FragmentUc())

        fragmentBaslikListesi.add("Bir")
        fragmentBaslikListesi.add("İki")
        fragmentBaslikListesi.add("Üç")

        val adapter = myViewerPagerAdapter(this)
        design.viewPager2.adapter = adapter

        TabLayoutMediator(design.tabLayout,design.viewPager2){tab,position ->
            tab.setText(fragmentBaslikListesi[position])
        }.attach()
        //Tablayout ile viewPageri birleştirip senkron çalışmalarını sağlıyor.

    }

    inner class myViewerPagerAdapter(fragmentActivity:FragmentActivity):FragmentStateAdapter(fragmentActivity){
        override fun getItemCount(): Int {
            //Fragment adetini istiyor
            return fragmentList.size
        }

        override fun createFragment(position: Int): Fragment {
            //Fragmentleri sırayla belirtmemiz gerekiyor
            return fragmentList[position]
        }

    }
}
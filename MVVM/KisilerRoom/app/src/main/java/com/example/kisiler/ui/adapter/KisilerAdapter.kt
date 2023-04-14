package com.example.kisiler.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.kisiler.R
import com.example.kisiler.data.entity.Kisiler
import com.example.kisiler.databinding.KisilerCardBinding
import com.example.kisiler.ui.fragment.AnasayfaFragmentDirections
import com.example.kisiler.ui.viewModel.AnasayfaViewModel
import com.example.kisiler.util.gecisYap
import com.google.android.material.snackbar.Snackbar

class KisilerAdapter(
    var mContext: Context, var kisiList: List<Kisiler>, var viewModel: AnasayfaViewModel
) : RecyclerView.Adapter<KisilerAdapter.CardHolder>() {

    inner class CardHolder(binding: KisilerCardBinding) : RecyclerView.ViewHolder(binding.root) {
        var binding: KisilerCardBinding

        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding: KisilerCardBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.kisiler_card, parent, false)
        return CardHolder(binding)
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        val kisi = kisiList[position]
        val design = holder.binding

        with(design) {
            kisiNesnesi = kisi
            design.kisiCard.setOnClickListener {
                val gecis = AnasayfaFragmentDirections.kisiDetayGecis(Kisi = kisi)
                Navigation.gecisYap(it, gecis)
            }
            design.imgDelete.setOnClickListener {
                Snackbar.make(
                    it, "${kisi.kisi_ad} silinsin mi?", Snackbar.LENGTH_SHORT
                ).setAction("EVET") {
                    viewModel.sil(kisi_id = kisi.kisi_id)
                }.show()
            }
        }
    }

    override fun getItemCount(): Int {
        return kisiList.size
    }


}
package com.example.filmler

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class KategorilerRVAdapter(
    private val mContext: Context,
    private val data: ArrayList<Kategoriler>
) : RecyclerView.Adapter<KategorilerRVAdapter.ObjectHolder>() {

    inner class ObjectHolder(view: View) : RecyclerView.ViewHolder(view) {
        val kategoriCard: CardView
        val kategoriAd: TextView

        init {
            kategoriCard = view.findViewById(R.id.kategoriCard)
            kategoriAd = view.findViewById(R.id.kategoriAd)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObjectHolder {
        val tasarim =
            LayoutInflater.from(mContext).inflate(R.layout.kategoriler_card_tasarim, parent, false)
        return ObjectHolder(tasarim)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ObjectHolder, position: Int) {
        var dataOnQue = data[position]
        holder.kategoriAd.text = dataOnQue.kategori_adi
        holder.kategoriCard.setOnClickListener {
            val intent = Intent(mContext, FilmlerActivity::class.java)
            intent.putExtra("Kategori", dataOnQue)
            mContext.startActivity(intent)
        }
    }

}
package com.example.filmler

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class FilmlerRVAdapter(private val mContext: Context, private val data: ArrayList<Filmler>) :
    RecyclerView.Adapter<FilmlerRVAdapter.ObjectHolder>() {

    inner class ObjectHolder(view: View) : RecyclerView.ViewHolder(view) {
        val filmCard:CardView
        val filmAd: TextView
        val filmResim: ImageView

        init {
            filmCard = view.findViewById(R.id.filmCard)
            filmAd = view.findViewById(R.id.filmAd)
            filmResim = view.findViewById(R.id.filmResim)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObjectHolder {
        val tasarim =
            LayoutInflater.from(mContext).inflate(R.layout.filmler_card_tasarim, parent, false)
        return ObjectHolder(tasarim)
    }

    override fun onBindViewHolder(holder: FilmlerRVAdapter.ObjectHolder, position: Int) {
        var dataOnQue = data[position]
        with(holder){
            filmAd.text = dataOnQue.filmAd
            filmResim.setImageResource(
                mContext.resources.getIdentifier(
                    dataOnQue.filmResim,
                    "drawable",
                    mContext.packageName
                )
            )
            filmCard.setOnClickListener {
                val intent = Intent(mContext,FilmDetayActivity::class.java)
                intent.putExtra("Film",dataOnQue)
                mContext.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

}
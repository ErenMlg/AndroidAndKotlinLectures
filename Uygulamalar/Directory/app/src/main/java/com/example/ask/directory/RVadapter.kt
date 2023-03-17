package com.example.ask.directory

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class RVadapter(private val mContext:Context, private val dataList:List<Kelimeler>) : RecyclerView.Adapter<RVadapter.objectHolder>() {

    inner class objectHolder(view:View):RecyclerView.ViewHolder(view){
        var cardView:CardView
        var englishTxt:TextView
        var turkishTxt:TextView

        init {
            cardView = view.findViewById(R.id.cardView)
            englishTxt = view.findViewById(R.id.engTxt)
            turkishTxt = view.findViewById(R.id.trTxt)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): objectHolder {
        val cardDesign = LayoutInflater.from(mContext).inflate(R.layout.card_design,parent,false)
        return objectHolder(cardDesign)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: objectHolder, position: Int) {
        var kuyruktakiVeri = dataList[position]
        holder.englishTxt.text = kuyruktakiVeri.kelimeIng
        holder.turkishTxt.text = kuyruktakiVeri.kelimeTr

        if(position%2==0){
            holder.cardView.setCardBackgroundColor(mContext.getColor(R.color.secondCard))
            holder.englishTxt.setTextColor(mContext.getColor(R.color.white))
            holder.turkishTxt.setTextColor(mContext.getColor(R.color.white))
        }else{
            holder.cardView.setCardBackgroundColor(mContext.getColor(R.color.white))
            holder.englishTxt.setTextColor(mContext.getColor(R.color.secondCard))
            holder.turkishTxt.setTextColor(mContext.getColor(R.color.secondCard))
        }

        holder.cardView.setOnClickListener {
            val intent = Intent(mContext,DetayActivity::class.java)
            intent.putExtra("veri",kuyruktakiVeri)
            mContext.startActivity(intent)
        }
    }


}
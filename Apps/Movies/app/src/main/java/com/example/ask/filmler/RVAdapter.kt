package com.example.ask.filmler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

class RVAdapter(private var mContext:Context, private var dataClass:List<Movies>)
    :RecyclerView.Adapter<RVAdapter.cardEntityPlaceHolder>(){

    inner class cardEntityPlaceHolder(view:View):RecyclerView.ViewHolder(view){

        val moviePic:ImageView
        val movieName:TextView
        val moviePrice:TextView
        val addToCartButton:Button

        init{
            moviePic = view.findViewById(R.id.moviePic)
            movieName = view.findViewById(R.id.movieName)
            moviePrice = view.findViewById(R.id.moviePrice)
            addToCartButton = view.findViewById(R.id.addToCart)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardEntityPlaceHolder {

        var cardDesign = LayoutInflater.from(mContext).inflate(R.layout.card_design,parent,false)

        return cardEntityPlaceHolder(cardDesign)
    }

    override fun getItemCount(): Int {
        return dataClass.size
    }

    override fun onBindViewHolder(holder: cardEntityPlaceHolder, position: Int) {

        var movieInQuery = dataClass[position]

        holder.movieName.text = movieInQuery.movieName
        holder.moviePrice.text = "${movieInQuery.moviePrice.toString()} TL"
        holder.moviePic.setImageResource(mContext.resources.getIdentifier(movieInQuery.moviePicture,"drawable",mContext.packageName))

    }


}
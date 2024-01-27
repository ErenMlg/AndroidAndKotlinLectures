package com.example.notapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class NotlarAdapter(private val mContext:Context, private val notlarListe:List<Notlar>):RecyclerView.Adapter<NotlarAdapter.ObjectHolder>() {

    inner class ObjectHolder(tasarim:View):RecyclerView.ViewHolder(tasarim){
        val ders_card:CardView
        val ders_adi:TextView
        val not1:TextView
        val not2:TextView
        init {
            ders_card = tasarim.findViewById(R.id.lessonCard)
            ders_adi = tasarim.findViewById(R.id.lessonTxt)
            not1 = tasarim.findViewById(R.id.note1Txt)
            not2 = tasarim.findViewById(R.id.note2Txt)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObjectHolder {
        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.lessons_card,parent,false)
        return ObjectHolder(tasarim)
    }

    override fun getItemCount(): Int {
        return notlarListe.size
    }

    override fun onBindViewHolder(holder: ObjectHolder, position: Int) {
        var lessonOnTheQuery = notlarListe[position]
        holder.ders_adi.text = lessonOnTheQuery.ders_adi
        holder.not1.text = lessonOnTheQuery.not1.toString()
        holder.not2.text = lessonOnTheQuery.not2.toString()

        holder.ders_card.setOnClickListener {
            val intent = Intent(mContext,DetayActivity::class.java)
            intent.putExtra("not",lessonOnTheQuery)
            mContext.startActivity(intent)

        }
    }

}
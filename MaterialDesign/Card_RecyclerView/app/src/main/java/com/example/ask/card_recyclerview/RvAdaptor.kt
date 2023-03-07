package com.example.ask.card_recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

/* mContext bu classı kullanacak kişiden hangi activityi kullandığını belirtmesini istiyor...
Amacı daha sonra toast mesaj vb. şeyler kullanmak istediğimiz zaman context değerini kullanarak hangi activityde çalışmasını
istediğimizi belirtiriz.
*/

class RvAdaptor(private val mContext:Context, private val ulkelerDisaridanGelenListesi:List<Ulkeler>)
    : RecyclerView.Adapter<RvAdaptor.CardViewNesneleriniTutucu>() {
    // Alttaki sınıfı adaptere bağlamış olduk, RvAdaptor sınıfı Adapter özelliğini alan bir sınıf oldu


    inner class CardViewNesneleriniTutucu(view:View):RecyclerView.ViewHolder(view){
        /*
        - Bu sınıfı dışarıda da oluşturabiliriz ancak profesyonel olarak bu sınıf Adapter ile bağlantılı olduğundan
        inner class oluşturmak daha iyidir.
        - Bu sınıf card nesnesindeki görsel ögeleri temsil ediyor
        - view nesnesi ile card tasarımındaki nesnelere erişiyoruz (RecyclerView.ViewHolder sayesinde)
        */

        var rowCardView:CardView
        var rowTxt:TextView
        var addIcon:ImageView

        init { // Nesne oluşturulduğu zaman çalışır (Flutterdaki gibi)
            rowCardView = view.findViewById(R.id.rowCardView)
            rowTxt = view.findViewById(R.id.rowTxt)
            addIcon = view.findViewById(R.id.addIcon)
            // Oluşturdugumuz değişkenlere nesnelerimizi atadık
        }

    }

    override fun onCreateViewHolder(yazilimsalTasarim: ViewGroup, viewType: Int): CardViewNesneleriniTutucu {
        /* Tasarımı aktardığımız kısım  */

        val design = LayoutInflater.from(mContext).inflate(R.layout.card_design,yazilimsalTasarim,false)

        return CardViewNesneleriniTutucu(design)
    }

    override fun getItemCount(): Int {
        /* CardViewNesneleriniTutucu ile bağlamış olduğumuz tasarımdan kaç tane olacak onun değerini istiyor */
        return ulkelerDisaridanGelenListesi.size
    }

    override fun onBindViewHolder(holder: CardViewNesneleriniTutucu, position: Int) {
        // Position: 0 1 2 3... diye artar ve sırayla verileri tutar
        /* Burası hangi nesneyi hangi carda aktaracağını belirtir, kısacası verilerin tasarıma dönüştürüldüğü kısım */

        val ulke = ulkelerDisaridanGelenListesi[position]
        holder.rowTxt.text = ulke.UlkeAdi
        holder.rowCardView.setOnClickListener {
            Toast.makeText(mContext,"Ulke adı : ${ulke.UlkeAdi}\nUlke No : ${ulke.UlkeNo}",Toast.LENGTH_SHORT).show()
        }

        holder.addIcon.setOnClickListener {
            val popup = PopupMenu(mContext,holder.addIcon) // Popup nesnesi oluşturduk
            popup.menuInflater.inflate(R.menu.card_popup,popup.menu) // Popup nesnemize menüyü bağladık
            popup.show()

            popup.setOnMenuItemClickListener { item ->

                when(item.itemId){
                    R.id.action_add -> {
                        Toast.makeText(mContext,"${ulke.UlkeAdi} Eklendi..",Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.action_buy -> {
                        Toast.makeText(mContext,"${ulke.UlkeAdi} Satın Alınıyor..",Toast.LENGTH_SHORT).show()
                        true
                    }
                    else ->{
                        false
                    }
                }


            }
        }
    }

}
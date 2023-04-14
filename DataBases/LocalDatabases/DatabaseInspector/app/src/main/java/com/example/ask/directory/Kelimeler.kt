package com.example.ask.directory

import android.os.Parcel
import android.os.Parcelable

class Kelimeler(var kelimeID:Int, var kelimeIng:String, var kelimeTr:String) : Parcelable {
    constructor(parcel: Parcel) : this(
        // Aktarılan verileri okumak için yeni bir Kelimeler nesnesi üretiyor ve parcelden okuyor.
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        // Verileri Parcel nesnesi haline getirip transfere hazırlıyor
        parcel.writeInt(kelimeID)
        parcel.writeString(kelimeIng)
        parcel.writeString(kelimeTr)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Kelimeler> {
        // Parcel datasını okuyoruz
        override fun createFromParcel(parcel: Parcel): Kelimeler {
            return Kelimeler(parcel)
        }

        override fun newArray(size: Int): Array<Kelimeler?> {
            return arrayOfNulls(size)
        }
    }
}
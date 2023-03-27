package com.example.filmler

import android.os.Parcel
import android.os.Parcelable

class Kategoriler(var kategori_id:Int, var kategori_adi:String) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(kategori_id)
        parcel.writeString(kategori_adi)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Kategoriler> {
        override fun createFromParcel(parcel: Parcel): Kategoriler {
            return Kategoriler(parcel)
        }

        override fun newArray(size: Int): Array<Kategoriler?> {
            return arrayOfNulls(size)
        }
    }
}
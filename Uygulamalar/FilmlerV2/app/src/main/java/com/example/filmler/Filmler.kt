package com.example.filmler

import android.os.Parcel
import android.os.Parcelable

class Filmler(
    var filmID: Int,
    var filmAd: String?,
    var filmYil: Int,
    var filmResim: String?,
    var kategori: Kategoriler?,
    var yonetmen: Yonetmenler?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readParcelable(Kategoriler::class.java.classLoader),
        parcel.readParcelable(Yonetmenler::class.java.classLoader)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(filmID)
        parcel.writeString(filmAd)
        parcel.writeInt(filmYil)
        parcel.writeString(filmResim)
        parcel.writeParcelable(kategori, flags)
        parcel.writeParcelable(yonetmen, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Filmler> {
        override fun createFromParcel(parcel: Parcel): Filmler {
            return Filmler(parcel)
        }

        override fun newArray(size: Int): Array<Filmler?> {
            return arrayOfNulls(size)
        }
    }
}
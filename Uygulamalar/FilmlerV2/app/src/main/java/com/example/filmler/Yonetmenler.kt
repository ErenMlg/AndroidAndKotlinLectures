package com.example.filmler

import android.os.Parcel
import android.os.Parcelable

class Yonetmenler(var yonetmenID: Int, var yonetmenAdi: String?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(yonetmenID)
        parcel.writeString(yonetmenAdi)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Yonetmenler> {
        override fun createFromParcel(parcel: Parcel): Yonetmenler {
            return Yonetmenler(parcel)
        }

        override fun newArray(size: Int): Array<Yonetmenler?> {
            return arrayOfNulls(size)
        }
    }

}
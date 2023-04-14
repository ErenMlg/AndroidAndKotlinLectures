package com.example.sayfalararasiveritasima

import android.os.Parcel
import android.os.Parcelable

class Kisiler(var tcno:Int, var isim: String?, var boy:Double):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readDouble()
    ) {
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        TODO("Not yet implemented")
    }

    companion object CREATOR : Parcelable.Creator<Kisiler> {
        override fun createFromParcel(parcel: Parcel): Kisiler {
            return Kisiler(parcel)
        }

        override fun newArray(size: Int): Array<Kisiler?> {
            return arrayOfNulls(size)
        }
    }

}
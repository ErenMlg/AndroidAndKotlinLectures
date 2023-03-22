package com.example.notapp

import android.os.Parcel
import android.os.Parcelable

class Notlar(var not_id:Int, var ders_adi:String, var not1:Int, var not2:Int) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(not_id)
        parcel.writeString(ders_adi)
        parcel.writeInt(not1)
        parcel.writeInt(not2)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Notlar> {
        override fun createFromParcel(parcel: Parcel): Notlar {
            return Notlar(parcel)
        }

        override fun newArray(size: Int): Array<Notlar?> {
            return arrayOfNulls(size)
        }
    }
}
package com.example.startup

import android.os.Parcel
import android.os.Parcelable

data class Kisiler(var ad:String?, var yas:Int) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt()
    )

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(ad)
        dest.writeInt(yas)
    }

    companion object CREATOR : Parcelable.Creator<Kisiler> {
        override fun createFromParcel(parcel: Parcel): Kisiler {
            return Kisiler(parcel)
        }

        override fun newArray(size: Int): Array<Kisiler?> {
            return arrayOfNulls(size)
        }
    }

    override fun toString(): String {
        return "$ad $yas"
    }

}
package com.example.kisiler.data.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

// Room ile veritabanındaki hangi tabloyu temsil edeceğini belirttik
@Entity(tableName = "kisiler")
data class Kisiler(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "kisi_id") @NotNull var kisi_id: Int,
    @ColumnInfo(name = "kisi_ad") @NotNull var kisi_ad: String,
    @ColumnInfo(name = "kisi_tel") @NotNull var kisi_tel: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(), parcel.readString() ?: "", parcel.readString() ?: ""
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(kisi_id)
        parcel.writeString(kisi_ad)
        parcel.writeString(kisi_tel)
    }

    override fun describeContents(): Int {
        return 0
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

package com.example.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CRUDCevap(
    @SerializedName("sucsess")
    @Expose
    var sucsess:Int,
    @SerializedName("message")
    @Expose
    var message:String
) {
}
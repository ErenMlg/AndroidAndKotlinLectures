package com.example.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class KisilerCevap(
    @SerializedName("kisiler")
    @Expose
    var kisiler: List<Kisiler>,
    @SerializedName("sucsess")
    @Expose
    var sucsess: Int
) {}
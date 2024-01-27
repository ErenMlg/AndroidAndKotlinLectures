package com.softcross.customapidemo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CRUD(
    @SerializedName("message")
    @Expose
    var message: String,
    @SerializedName("status")
    @Expose
    var status: Int
)

package com.softcross.customapidemo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CharactersList(
    @SerializedName("characters")
    @Expose
    var charactersList: List<Characters>,
    @SerializedName("status")
    @Expose
    var status: Int
)

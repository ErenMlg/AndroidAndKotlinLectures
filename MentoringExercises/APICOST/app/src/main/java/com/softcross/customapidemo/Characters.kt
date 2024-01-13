package com.softcross.customapidemo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Characters(
    @SerializedName("_id")
    @Expose
    var characterID:String,
    @SerializedName("name")
    @Expose
    var characterName:String,
    @SerializedName("status")
    @Expose
    var characterStatus:String,
    @SerializedName("origin")
    @Expose
    var characterOrigin:String,
    @SerializedName("crew")
    @Expose
    var characterCrew:String,
    @SerializedName("occupation")
    @Expose
    var characterOccupation:String,
    @SerializedName("bounty")
    @Expose
    var characterBounty:Double,
    @SerializedName("devilFruit")
    @Expose
    var characterDevilFruit:String,
    @SerializedName("abilities")
    @Expose
    var characterAbilities:String,
)

package com.nowik.numberslight.model

import com.google.gson.annotations.SerializedName

data class Number(
    @SerializedName("name")
    val id : String,
    @SerializedName("image")
    val iconUrl : String
)
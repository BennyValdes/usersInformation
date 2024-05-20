package com.example.adptest.data.model.userdata


import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("page")
    val page: Any,
    @SerializedName("results")
    val results: Any,
    @SerializedName("seed")
    val seed: String,
    @SerializedName("version")
    val version: String
)
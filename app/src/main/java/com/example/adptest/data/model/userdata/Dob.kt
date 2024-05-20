package com.example.adptest.data.model.userdata


import com.google.gson.annotations.SerializedName

data class Dob(
    @SerializedName("age")
    val age: Any,
    @SerializedName("date")
    val date: String
)
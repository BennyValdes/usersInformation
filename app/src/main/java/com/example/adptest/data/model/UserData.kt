package com.example.adptest.data.model

import com.example.adptest.data.model.userdata.Info
import com.example.adptest.data.model.userdata.Result
import com.google.gson.annotations.SerializedName

data class UserData(
    @SerializedName("info")
    val info: Info?,
    @SerializedName("results")
    val results: List<Result>?
)
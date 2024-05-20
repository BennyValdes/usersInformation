package com.example.adptest.data.network

import com.example.adptest.data.model.UserData
import retrofit2.Response
import retrofit2.http.GET

interface UserApiClient {
    @GET("api/")
    suspend fun getUserData(): Response<UserData>
}
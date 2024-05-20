package com.example.adptest.data.network

import com.example.adptest.data.model.userdata.Info
import com.example.adptest.data.model.UserData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getUserData(): UserData {
        return withContext(Dispatchers.IO) {
            val response : Response<UserData> = retrofit.create(UserApiClient::class.java).getUserData()
            response.body() ?: UserData(Info(0,0,"",""), emptyList())
        }
    }
}
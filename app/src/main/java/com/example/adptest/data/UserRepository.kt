package com.example.adptest.data

import com.example.adptest.data.model.UserData
import com.example.adptest.data.model.UserProvider
import com.example.adptest.data.network.UserService
import kotlinx.coroutines.runBlocking

class UserRepository {
    private val api = UserService()

    suspend fun getUserData(): List<UserData>{
        val listUsers = mutableListOf<UserData>()
        var i=0
        while (i<=20) {
            listUsers.add(getUserInformation())
            i++
        }
        UserProvider.usersList = listUsers
        return listUsers
    }

    private suspend fun getUserInformation() = api.getUserData()
}
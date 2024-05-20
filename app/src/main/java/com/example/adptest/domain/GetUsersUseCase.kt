package com.example.adptest.domain

import com.example.adptest.data.UserRepository
import com.example.adptest.data.model.UserData

class GetUsersUseCase {
    private val repository = UserRepository()

    suspend operator fun invoke():List<UserData>? = repository.getUserData()
}
package com.example.adptest.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.adptest.data.model.UserData
import com.example.adptest.domain.GetUsersUseCase
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val userModel = MutableLiveData<List<UserData>?>()

    var getUsersUseCase = GetUsersUseCase()

    fun onCreate() {

        viewModelScope.launch {
            val result = getUsersUseCase()

            if(!result.isNullOrEmpty()){
                userModel.postValue(result)
            }
        }
    }
}
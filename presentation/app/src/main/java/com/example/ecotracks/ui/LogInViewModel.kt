package com.example.ecotracks.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class LoginViewModel: ViewModel() {


    fun login(email: String, password: String) {
        viewModelScope.launch {

        }
    }

}

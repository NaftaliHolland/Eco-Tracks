package com.example.ecotracks.ui

import androidx.lifecycle.ViewModel
import com.example.ecotracks.model.LogInUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LogInViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(LogInUiState())
    val uiState: StateFlow<LogInUiState> = _uiState.asStateFlow()

    fun login(username: String, password: String) {
        _uiState.value = LogInUiState(loading = true)
    }
}
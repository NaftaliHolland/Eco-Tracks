package com.example.ecotracks.model

data class LogInUiState(
    val loading: Boolean = false,
    val loggedIn: Boolean = false,
    val error: String = ""
)

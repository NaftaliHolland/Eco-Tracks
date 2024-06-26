package com.example.ecotracks.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import com.example.ecotracks.model.SignUpState
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.room.Room
import com.example.ecotracks.data.UserDatabase
import kotlinx.coroutines.flow.update

class SignUpViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(SignUpState())
    val uiState: StateFlow<SignUpState> = _uiState.asStateFlow()

    fun setPassword(value: String, valid: Boolean) {
        _uiState.update { currentState ->
            currentState.copy(
                password = value,
                isPasswordValid = valid
            )
        }
    }

    fun setEmail(value: String, valid: Boolean) {
        _uiState.update { currentState ->
            currentState.copy(
                email = value,
                isEmailValid = valid
            )
        }
    }

    fun setPrivacy(value: Boolean) {
        _uiState.update { currentState ->
            currentState.copy(
                acceptedTerms = true
            )
        }
    }

    fun validateData(
        nameValid: Boolean,
        emailValid: Boolean,
        passwordValid: Boolean,
        repeatPasswordValid: Boolean,
        termsAccepted: Boolean,
    ): Boolean {
        var isValid = (nameValid && emailValid && passwordValid && repeatPasswordValid && termsAccepted)
        _uiState.update { currentState ->
            currentState.copy(
                everythingValid = isValid
            )
        }
        return isValid
    }
}
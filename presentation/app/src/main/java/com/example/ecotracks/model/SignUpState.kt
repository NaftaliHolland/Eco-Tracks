package com.example.ecotracks.model

data class SignUpState(
    val name: String = "",
    val isNameValid: Boolean = false,
    val email: String = "",
    val isEmailValid: Boolean = false,
    val password: String = "",
    val isPasswordValid: Boolean = false,
    val repeatedPassword: String = "",
    val isRepeatedPasswordValid: Boolean = false,
    val acceptedTerms: Boolean = false,
    val termsError: String? = null,

    val everythingValid: Boolean = true
)

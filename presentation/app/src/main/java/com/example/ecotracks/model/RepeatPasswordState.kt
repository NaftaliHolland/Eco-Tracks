package com.example.ecotracks.model

class RepeatPasswordState: TextFieldState(
    validator = { repeatPassword -> isRepeatPasswordValid(repeatPassword) },
    errorMessage = { repeatPassword -> repeatPasswordErrorMessage() }
) {
}

private fun isRepeatPasswordValid(repeatPassword: String): Boolean {
    return repeatPassword != null
}

private fun repeatPasswordErrorMessage(): String {
    return "Passwords do not match"
}
package com.example.ecotracks.model

import java.util.regex.Pattern


class PasswordState: TextFieldState(
    validator = { password -> isPasswordValid(password) },
    errorMessage = { password -> passwordErrorMessage(password)}
) {
}

private const val PASSWORD_VALIDATION_REGEX = "^(?=.*[a-zA-Z])(?=.*\\d).+"
private fun isPasswordValid(password: String): Boolean {

    return (password.length >= 7) && Pattern.matches(PASSWORD_VALIDATION_REGEX, password)
}

private fun passwordErrorMessage(password: String): String {
    return "Password must contain a mix of letters and digits and must not be less than 7 characters long"
}
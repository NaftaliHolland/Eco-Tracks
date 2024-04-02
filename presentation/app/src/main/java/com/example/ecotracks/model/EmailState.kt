package com.example.ecotracks.model

import java.util.regex.Pattern

class EmailState: TextFieldState(
    validator = { email -> isEmailValid(email) },
    errorMessage = {email -> emailErrorMessage(email)}

) {
}

private const val EMAIL_VALIDATION_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}\$"
private fun isEmailValid(email: String): Boolean {
    //return email.length > 5
    return Pattern.matches(EMAIL_VALIDATION_REGEX, email)
}

private fun emailErrorMessage(email: String): String {
    return "Email $email is invalid"
}
package com.example.ecotracks.model



class NameState: TextFieldState(
    validator = { name -> isNameValid(name) },
    errorMessage = { name -> nameErrorMessage(name) }
) {
}

private fun isNameValid(name: String): Boolean {
    return !(name.any {it.isDigit() })
}

private fun nameErrorMessage(name: String): String {
    return "$name is invalid. Name cannot contain digits"
}
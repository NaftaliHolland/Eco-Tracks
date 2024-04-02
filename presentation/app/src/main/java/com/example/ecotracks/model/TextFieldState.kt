package com.example.ecotracks.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

open class TextFieldState(
    private val validator: (String) -> Boolean = { true },
    private val errorMessage: (String) -> String = { "" }
) {

    var text = ""
    var error by mutableStateOf<String>("")

    fun validate(value: String) {
        error = if (validator(value)){
            ""
        }
        else {
            errorMessage(value)
        }
    }
}
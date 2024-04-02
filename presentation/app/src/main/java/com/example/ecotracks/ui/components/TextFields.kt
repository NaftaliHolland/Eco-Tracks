package com.example.ecotracks.ui.components

import androidx.compose.foundation.border
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.IconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import com.example.ecotracks.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.material3.Checkbox
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.foundation.layout.heightIn
import com.example.ecotracks.model.TextFieldState
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.BorderStroke
import androidx.compose.ui.graphics.Brush
import com.example.ecotracks.ui.components.ErrorTextComponent

@Composable
fun MyTextField(
    labelValue: String,
    leadingIconRes: Int,
    state: TextFieldState = TextFieldState(),
    onValueChanged: (String) -> Unit) {
    //var textValue by rememberSaveable { mutableStateOf("") }
    var textValue by rememberSaveable { mutableStateOf(state.text)}
    var isError = state.error != ""
    /*val textValue = remember {
        mutableStateOf("")
    }*/

    OutlinedTextField(
        value = textValue,
        onValueChange = {
            textValue = it
            state.validate(it)
            onValueChanged(it)},
        singleLine = true,
        shape = MaterialTheme.shapes.small,
        label = { Text(text = labelValue) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = dimensionResource(id = R.dimen.padding_medium)),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.surface,
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            disabledContainerColor = MaterialTheme.colorScheme.surface,
        ),
        isError = isError,
        supportingText = {
            if(isError) {
                ErrorTextComponent(state.error)
            }
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Next
        ),
        leadingIcon = {
            Icon(
                painter = painterResource(id = leadingIconRes),
                contentDescription = ""
            )
        }
    )
}

@Composable
fun PasswordTextFieldComponent(
    labelValue: String,
    leadingIconRes: Int,
    state: TextFieldState = TextFieldState(),
    onPasswordChanged: (String) -> Unit){

    var isError = state.error != ""
    var password by rememberSaveable { mutableStateOf(state.text) }

    val passwordVisible = remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        value = password,
        onValueChange = {
                password = it
                state.validate(it)
                onPasswordChanged(it)
            //value -> onPasswordChanged(value)
            },
        singleLine = true,
        shape = MaterialTheme.shapes.small,
        label = { Text(text = labelValue) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = dimensionResource(id = R.dimen.padding_medium)),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.surface,
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            disabledContainerColor = MaterialTheme.colorScheme.surface,
        ),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Next
        ),
        isError = isError,
        supportingText = {
            if(isError) {
                ErrorTextComponent(state.error)
            }
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = leadingIconRes),
                contentDescription = ""
            )
        },
        trailingIcon = {
            val iconRes = if(passwordVisible.value) {
                R.drawable.visibility_off_24px
            } else {
                R.drawable.visibility_24px
            }
            IconButton(
                onClick = { passwordVisible.value = !passwordVisible.value }
            ) {
                Icon(
                    painter = painterResource(id = iconRes),
                    contentDescription = ""
                )
            }
        },
        visualTransformation = if(passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation()
    )
}

@Composable
fun CheckBoxComponent(value: String, onChecked: (checked: Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp)
            .padding(dimensionResource(id = R.dimen.padding_medium)),
        verticalAlignment = Alignment.CenterVertically
    ) {

        val checkedState = remember {
            mutableStateOf(false)
        }
        Checkbox(
            checked = checkedState.value,
            onCheckedChange = {
                checkedState.value = !checkedState.value
                onChecked(checkedState.value)
            }
        )
        SmallTextComponent(value)
    }
}
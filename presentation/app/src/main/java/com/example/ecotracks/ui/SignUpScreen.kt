package com.example.ecotracks.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Alignment
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import com.example.ecotracks.R
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.text.input.ImeAction
import com.example.ecotracks.ui.theme.EcoTracksTheme

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        @OptIn(ExperimentalMaterial3Api::class)
        Text(
            text = stringResource(R.string.full_name),
            modifier = Modifier
                .align(Alignment.Start)
        )
        OutlinedTextField(
            value = "",
            onValueChange = { },
            singleLine = true,
            shape = shapes.small,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = dimensionResource(id = R.dimen.padding_medium)),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = colorScheme.surface,
                unfocusedContainerColor = colorScheme.surface,
                disabledContainerColor = colorScheme.surface
            ),
            //label = Text(text = stringResource(id = R.string.email_address)),
            //placeholder = "naftalihollan01@gmail.com",
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next
            )
        )
        Text(
            text = stringResource(R.string.email_address),
            modifier = Modifier
                .align(Alignment.Start)
        )
        OutlinedTextField(
            value = "",
            onValueChange = { },
            singleLine = true,
            shape = shapes.small,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = dimensionResource(id = R.dimen.padding_medium)),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = colorScheme.surface,
                unfocusedContainerColor = colorScheme.surface,
                disabledContainerColor = colorScheme.surface
            ),
            //label = Text(text = stringResource(id = R.string.email_address)),
            //placeholder = "naftalihollan01@gmail.com",
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next
            )
        )

        Text(
            text = stringResource(R.string.password),
            modifier = Modifier
                .align(Alignment.Start)
        )
        OutlinedTextField(
            value = "",
            onValueChange = { },
            singleLine = true,
            shape = shapes.small,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = dimensionResource(id = R.dimen.padding_medium)),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = colorScheme.surface,
                unfocusedContainerColor = colorScheme.surface,
                disabledContainerColor = colorScheme.surface
            ),
            //label = Text(text = stringResource(id = R.string.email_address)),
            //placeholder = "naftalihollan01@gmail.com",
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next
            )
        )

        Text(
            text = stringResource(R.string.repeat_password),
            modifier = Modifier
                .align(Alignment.Start)
        )
        OutlinedTextField(
            value = "",
            onValueChange = { },
            singleLine = true,
            shape = shapes.small,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = dimensionResource(id = R.dimen.padding_medium)),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = colorScheme.surface,
                unfocusedContainerColor = colorScheme.surface,
                disabledContainerColor = colorScheme.surface
            ),
            //label = Text(text = stringResource(id = R.string.email_address)),
            //placeholder = "naftalihollan01@gmail.com",
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            )
        )

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = dimensionResource(id = R.dimen.padding_medium)),
            shape = shapes.small,
            onClick = { /* TO DO */},

        ) {
            Text(stringResource(id = R.string.create_account))
        }

        Row(modifier = modifier) {
            Text(
                text = stringResource(id = R.string.already_have_an_account)
            )
            Text(
                text = stringResource(id = R.string.sign_up)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    EcoTracksTheme {
        SignUpScreen()
    }
}
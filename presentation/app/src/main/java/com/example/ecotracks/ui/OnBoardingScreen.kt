package com.example.ecotracks.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.foundation.Image
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import com.example.ecotracks.R
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.ImeAction
import com.example.ecotracks.ui.theme.EcoTracksTheme
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.material.icons.Icons
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.ecotracks.ui.UserInfo
import com.example.ecotracks.ui.components.PrimaryButtonComponent
import com.example.ecotracks.ui.components.ClickText
import com.example.ecotracks.ui.components.NormalTextComponent
import com.example.ecotracks.ui.components.HeadingTextComponent

@Composable
fun OnBoardingScreen(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {

    val onClick: () -> Unit = {
        navController.navigate("sign_up")
    }
    Column(
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.padding_medium))
            .verticalScroll(rememberScrollState())
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(R.drawable.save_earth),
            contentDescription = ""
        )
        HeadingTextComponent(stringResource(id = R.string.save_the_earth))
        NormalTextComponent(stringResource(id = R.string.calculate_and_reduce_your_carbon_footprint))
        PrimaryButtonComponent(stringResource(id = R.string.create_account), onClick = onClick)
        Row(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))) {
            NormalTextComponent(stringResource(id = R.string.already_have_an_account))
            ClickText(stringResource(id = R.string.sign_in))
        }
    }
        /*Text(
            text = stringResource(id = R.string.save_the_earth),
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))
        )
        Text(
            text = stringResource(id = R.string.calculate_and_reduce_your_carbon_footprint),
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))
        )

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_medium)),
            shape = shapes.small,
            onClick = { /* TO DO */},

            ) {
            Text(
                stringResource(id = R.string.create_account),
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))
            )
        }

        Row(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))) {
            Text(
                text = stringResource(id = R.string.already_have_an_account)
            )
            Text(
                text = stringResource(id = R.string.sign_in)
            )
        }
    }*/
}

@Preview(showBackground = true)
@Composable
fun OnBoardingScreenPreview() {
    OnBoardingScreen()
}
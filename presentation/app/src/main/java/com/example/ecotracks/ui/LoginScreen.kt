package com.example.ecotracks.ui


import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.res.stringResource
import com.example.ecotracks.R
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Arrangement
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.navigation.NavHostController
import com.example.ecotracks.ui.components.NormalTextComponent
import com.example.ecotracks.ui.components.HeadingTextComponent
import com.example.ecotracks.ui.components.MyTextField
import com.example.ecotracks.ui.components.PasswordTextFieldComponent
import com.example.ecotracks.ui.components.PrimaryButtonComponent
import com.example.ecotracks.ui.components.ClickText


@Composable
fun LoginScreen(navController: NavHostController = rememberNavController()) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding_large))
    ){
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_large))
        ) {
            NormalTextComponent(stringResource(id = R.string.hello, "there"))
            HeadingTextComponent(stringResource(id = R.string.welcome_back))
            MyTextField(
                labelValue = stringResource(id = R.string.email_address),
                leadingIconRes = R.drawable.baseline_email_24
            ) {}
           /* PasswordTextFieldComponent(
                labelValue = stringResource(id = R.string.password),
                leadingIconRes = R.drawable.baseline_lock_outline_24
            )*/
            ClickText(stringResource(id = R.string.forgot_password))
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacer_height_large)))
            PrimaryButtonComponent(stringResource(id = R.string.sign_in))
        }

    }
}

@Preview(showBackground = true)
@Composable
fun LogInScreeenPreview() {
    LoginScreen()
}

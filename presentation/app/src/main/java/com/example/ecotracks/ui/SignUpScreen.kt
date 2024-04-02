package com.example.ecotracks.ui


import android.widget.Toast
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.ecotracks.model.EmailState
import com.example.ecotracks.ui.components.NormalTextComponent
import com.example.ecotracks.ui.components.HeadingTextComponent
import com.example.ecotracks.ui.components.MyTextField
import com.example.ecotracks.ui.components.PasswordTextFieldComponent
import com.example.ecotracks.ui.components.CheckBoxComponent
import com.example.ecotracks.ui.components.PrimaryButtonComponent
import com.example.ecotracks.model.NameState
import com.example.ecotracks.model.PasswordState
import com.example.ecotracks.model.RepeatPasswordState
import com.example.ecotracks.ui.SignUpViewModel


@Composable
fun SignUpScreen(navController: NavHostController = rememberNavController(), signUpViewModel: SignUpViewModel = viewModel()) {

    var passwordState = remember { PasswordState() }
    var emailState = remember { EmailState() }
    var repeatPasswordState = remember { RepeatPasswordState() }

    val signUpUiState by signUpViewModel.uiState.collectAsState()

    val onClick: () -> Unit = {
        var password = passwordState.text
        var repeatPassword = repeatPasswordState.text
        if(repeatPassword != password) {
            repeatPasswordState.error = "Passwords don't match"
        }
        var email = emailState.text
        var isValid: Boolean = emailState.error == ""
        if (!signUpUiState.acceptedTerms) {
            println("Not selected")
        } else {
            println(" Selected ")
        }
        signUpViewModel.setPassword(passwordState.text, passwordState.error == "")
        signUpViewModel.setEmail(emailState.text, emailState.error == "")

        //navController.navigate("home")
    }
    val onChecked: (checked: Boolean) -> Unit = {checked ->
        signUpViewModel.setPrivacy(checked)
    }

   // signUpViewModel.setPassword(passwordState.text)
    //var a = passwordState.text
    //println(a)

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding_large))
            .verticalScroll(rememberScrollState())
    ){
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_large))
        ) {
            NormalTextComponent(stringResource(id = R.string.hello, "there"))
            HeadingTextComponent(stringResource(id = R.string.create_account))
            MyTextField(
                labelValue = stringResource(id = R.string.full_name),
                leadingIconRes = R.drawable.person_24px,
                state = NameState()
                ){

            }
            MyTextField(
                labelValue = stringResource(id = R.string.email_address),
                leadingIconRes = R.drawable.baseline_email_24,
                state = emailState
            ) {
                emailState.text = it
            }
            PasswordTextFieldComponent(
                labelValue = stringResource(id = R.string.password),
                leadingIconRes = R.drawable.baseline_lock_outline_24,
                state = passwordState,
            ) {
                passwordState.text = it
            }
            PasswordTextFieldComponent(
                labelValue = stringResource(id = R.string.repeat_password),
                leadingIconRes = R.drawable.baseline_lock_outline_24,
                state = repeatPasswordState,
            ) {
                repeatPasswordState.text = it
            }
            CheckBoxComponent(stringResource(id = R.string.terms_and_conditions), onChecked = onChecked)
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacer_height_large)))
            PrimaryButtonComponent(stringResource(id = R.string.sign_up), onClick = onClick)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    SignUpScreen()
}

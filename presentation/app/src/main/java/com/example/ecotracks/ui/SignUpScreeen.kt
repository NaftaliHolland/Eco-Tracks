package com.example.ecotracks.ui


import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.IconButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import com.example.ecotracks.R
import androidx.compose.material3.FabPosition
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.MaterialTheme
import com.example.ecotracks.ui.HomeScreen
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.navigation.NavHostController
import com.example.ecotracks.model.LearnCategory
import com.example.ecotracks.ui.components.LearnFilterChip
import com.example.ecotracks.data.DataSource
import com.example.ecotracks.ui.components.NormalTextComponent
import com.example.ecotracks.ui.components.HeadingTextComponent
import com.example.ecotracks.ui.components.MyTextField
import com.example.ecotracks.ui.components.PasswordTextFieldComponent
import com.example.ecotracks.ui.components.CheckBoxComponent
import com.example.ecotracks.ui.components.PrimaryButtonComponent


@Composable
fun SignUpScreeen() {
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
            HeadingTextComponent(stringResource(id = R.string.create_account))
            MyTextField(
                labelValue = stringResource(id = R.string.full_name),
                leadingIconRes = R.drawable.person_24px
                )
            MyTextField(
                labelValue = stringResource(id = R.string.email_address),
                leadingIconRes = R.drawable.baseline_email_24
            )
            PasswordTextFieldComponent(
                labelValue = stringResource(id = R.string.password),
                leadingIconRes = R.drawable.baseline_lock_outline_24
            )
            PasswordTextFieldComponent(
                labelValue = stringResource(id = R.string.repeat_password),
                leadingIconRes = R.drawable.baseline_lock_outline_24
            )
            CheckBoxComponent(stringResource(id = R.string.terms_and_conditions))
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacer_height_large)))
            PrimaryButtonComponent(stringResource(id = R.string.sign_up))
        }

    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreeenPreview() {
    SignUpScreeen()
}

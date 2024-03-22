package com.example.ecotracks.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Icon
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Alignment
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.padding
import com.example.ecotracks.R
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.ImeAction
import com.example.ecotracks.ui.theme.EcoTracksTheme
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.material.icons.Icons
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.example.ecotracks.model.UserActivity
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.VerticalDivider
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.ui.graphics.Color
import com.example.ecotracks.data.DataSource
import com.example.ecotracks.ui.OnBoardingScreen


@Composable
fun HomeScreen() {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        UserInfo("Holland")
        Stats(53.23)
        Filters()
        avg_stats(25.5, 22.5)
        UserActivityHistory(userActivityList = DataSource().loadUserActivities())
    }
}

@Composable
fun UserInfo(name: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.padding_small)),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Column(

        ) {
            Text(
                text = stringResource(id = R.string.hello, name),
                style = MaterialTheme.typography.displayLarge
            )
            Text(
                text = stringResource(id = R.string.what_to_do)
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.person_24px),
            contentDescription = "",
        )
    }
}

@Composable
fun Stats(co2_amount: Double) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.co_2),
                style = MaterialTheme.typography.titleLarge,
                color = Color.Green
            )
            Text(
                text = stringResource(id = R.string.carbon_quantity, co2_amount),
                style = MaterialTheme.typography.displayLarge
            )
            Text(
                text = stringResource(id = R.string.average_for_a_month),
                style = MaterialTheme.typography.bodyLarge
            )
        }
        Spacer(
            modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium))
        )
        Text(
            text = stringResource(id = R.string.emission_info, co2_amount),
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun Filters(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .height(IntrinsicSize.Min)
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.padding_medium)),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        /* TODO MAKE THESE CLICKABLE */
        Text(
            text = stringResource(id = R.string.today),
            modifier = Modifier.clickable{}
        )
        VerticalDivider(modifier = Modifier.fillMaxHeight())
        Text(
            text = stringResource(id = R.string.last_month)
        )
        VerticalDivider()
        Text(
            text = stringResource(id = R.string.last_year)
        )
    }
}

@Composable
fun avg_stats(co2_saved: Double, co2_emitted: Double, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_small))
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.cloud_upload_24px),
                contentDescription = "",
                modifier = Modifier.padding(end = dimensionResource(id = R.dimen.padding_medium)),
                tint = Color.Green
            )
            Text(
                text = stringResource(id = R.string.carbon_saved, co2_saved),
                style = MaterialTheme.typography.titleMedium
            )
        }

        Row(
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_small))
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.cloud_download_24px),
                contentDescription = "",
                modifier = Modifier.padding(end = dimensionResource(id = R.dimen.padding_medium)),
                tint = Color.Red
            )
            Text(
                text = stringResource(id = R.string.carbon_emitted, co2_emitted),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Composable
fun UserActivityHistory(
    userActivityList: List<UserActivity>,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(id = R.string.activity_history)
    )
    LazyColumn(
        modifier = modifier
    ) {
        items(userActivityList) { userActivity ->
            UserActivity(userActivity = userActivity)
        }
    }
}

@Composable
fun UserActivity(userActivity: UserActivity) {
    Row(
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.padding_small))
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
    ) {
        Icon(
            painter = painterResource(id = userActivity.imageResourceId),
            contentDescription = "",
            modifier = Modifier.padding(end = dimensionResource(id = R.dimen.padding_medium))
        )
        Text(
            text = stringResource(id = userActivity.name),
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(
            modifier = Modifier.weight(1f)
        )
        Text(
            text = (integerResource(id = userActivity.points)).toString(),
            style = MaterialTheme.typography.titleMedium,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun UserActivityPreview() {
        HomeScreen()
    }
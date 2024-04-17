package com.example.ecotracks.ui

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Icon
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Card
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.VerticalDivider
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import com.example.ecotracks.data.DataSource
import com.example.ecotracks.ui.OnBoardingScreen
import com.example.ecotracks.ui.components.BottomBar
import com.example.ecotracks.ui.components.FloatingButton
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavHostController
import com.example.ecotracks.ui.components.EmissionBottomSheet
import com.example.ecotracks.ui.components.HomeActivityCard
import com.example.ecotracks.ui.components.HomeCard


@Composable
fun HomeScreen(navController: NavHostController = rememberNavController()) {
    var showSheet by remember { mutableStateOf(false) }

    val onTransportClick: () -> Unit = {
        navController.navigate("add_transport_activity")
    }

    Scaffold(
        topBar = { },
        bottomBar = { BottomBar(navController = navController) },
        floatingActionButton =  { FloatingButton(){ showSheet = true} },
        floatingActionButtonPosition = FabPosition.Center,
        //containerColor = Color(0xffecf7ff),
        containerColor = Color(0xffe8f6f8),
        //containerColor = colorScheme.surfaceVariant,
    ) { innerPadding ->
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(80.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_medium))
                .consumeWindowInsets(innerPadding)
        ) {

            item {
                UserInfo("Holland")
            }
            item {
                HomeCard()
            }
            item {
                HomeActivityCards()
            }
        }
    }
    if (showSheet) {
        EmissionBottomSheet(onTransportClick) { showSheet = false }
    }
}

@Composable
fun UserInfo(name: String, profile_photo_id: Int = R.drawable.profile) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.padding_small)),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(

        ) {
            Text(
                text = stringResource(id = R.string.hello, name),
                style = MaterialTheme.typography.displayMedium
            )
            Text(
                text = stringResource(id = R.string.what_to_do)
            )
        }
        Spacer(
            modifier = Modifier.weight(1f)
        )
        Image(
            painter = painterResource(id = profile_photo_id),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
        )
    }
}



@Composable
fun UserActivityHistory(
    userActivityList: List<UserActivity>,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(id = R.string.activity_history),
        modifier = Modifier.padding(bottom = 0.dp)
    )
    LazyColumn(
        modifier = Modifier.padding(top = 0.dp)
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

@Composable
fun HomeActivityCards() {
    val homeActivitiesList = DataSource().loadHomeActivities()

    LazyRow(
        modifier = Modifier
            .fillMaxWidth(),

        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium))
    ) {
        items(homeActivitiesList) { homeActivity ->
            HomeActivityCard(
                image = homeActivity.image,
                name = stringResource(id = homeActivity.name),
                amountEmitted = homeActivity.amountEmitted!!
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

@Preview(showBackground = true)
@Composable
fun HomeActivityCardsPreview() {
    HomeActivityCards()
}
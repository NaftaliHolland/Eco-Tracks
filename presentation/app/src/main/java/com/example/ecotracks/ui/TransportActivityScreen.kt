package com.example.ecotracks.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.ecotracks.R
import com.example.ecotracks.ui.components.ArticleContentComponent
import com.example.ecotracks.ui.components.ArticleTitleComponent
import com.example.ecotracks.ui.components.BottomBar
import com.example.ecotracks.ui.components.EmissionBottomSheet
import com.example.ecotracks.ui.components.FloatingButton
import com.example.ecotracks.ui.components.HomeCard
import com.example.ecotracks.ui.components.TransportActivity

@Composable
fun TransportActivityScreen(
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        topBar = { },
        bottomBar = { },
        //containerColor = Color(0xffecf7ff),
        containerColor = Color(0xff266f75),
        //containerColor = colorScheme.surfaceVariant,
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .consumeWindowInsets(innerPadding),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_large))
        ) {
            Column() {
                ArticleTitleComponent(stringResource(id = R.string.journey_time))
                ArticleContentComponent(stringResource(id = R.string.how_did_you_travel))
            }

            TransportActivity()

        }
    }
}

@Preview
@Composable
fun TransportActivityScreenPreview() {
    TransportActivityScreen()
}
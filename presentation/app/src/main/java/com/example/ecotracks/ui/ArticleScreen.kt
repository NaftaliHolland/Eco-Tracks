package com.example.ecotracks.ui

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.VerticalDivider
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.ui.graphics.Color
import com.example.ecotracks.data.DataSource
import com.example.ecotracks.ui.OnBoardingScreen
import com.example.ecotracks.ui.components.BottomBar
import com.example.ecotracks.ui.components.FloatingButton
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavHostController
import com.example.ecotracks.ui.components.ArticleTitleComponent
import com.example.ecotracks.ui.components.ArticleContentComponent
import androidx.compose.foundation.Image
import androidx.compose.ui.layout.ContentScale

@Composable
fun ArticleScreen(title: String?, content: String?, image: Int?, navController: NavHostController = rememberNavController()) {
    Scaffold(
        topBar = { },
        bottomBar = { BottomBar(navController = navController) },
        floatingActionButton =  { },
        floatingActionButtonPosition = FabPosition.Center,
        //containerColor = MaterialTheme.colorScheme.surfaceVariant,
    ) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium)),
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_medium))
                .consumeWindowInsets(innerPadding)
                .verticalScroll(rememberScrollState()),
        ) {
            ArticleTitleComponent(title!!)
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = image!!),
                contentDescription = "",
                contentScale = ContentScale.FillWidth
            )
            ArticleContentComponent(content!!)
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacer_height_large)))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArticleScreenPreview() {
    ArticleScreen(
        title = stringResource(R.string.article_title),
        content = stringResource(R.string.article_content),
        image = R.drawable.vitor_monthay_ekedharupts_unsplash
    )
}

package com.example.ecotracks.ui

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.integerResource
import com.example.ecotracks.R
import androidx.compose.material3.FabPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.navigation.NavHostController
import com.example.ecotracks.model.ArticleCategory
import com.example.ecotracks.ui.components.ArticleFilterChip
import com.example.ecotracks.data.DataSource
import com.example.ecotracks.ui.components.BottomBar
import com.example.ecotracks.ui.components.FloatingButton
import com.example.ecotracks.model.Article
import androidx.compose.material3.Surface
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.example.ecotracks.ui.components.ArticleCard


var filterCategories = DataSource().loadLearnCategories()
var articles = DataSource().loadArticles()
@Composable
fun LearnScreen(navController: NavHostController = rememberNavController()) {
    Scaffold(
        topBar = { },
        bottomBar = { BottomBar(navController = navController) },
        floatingActionButton =  { },
        floatingActionButtonPosition = FabPosition.Center,
        //containerColor = MaterialTheme.colorScheme.surfaceVariant,
    ) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_medium))
                .consumeWindowInsets(innerPadding)
        ) {
            ArticleFilters(filterCategories)
            ArticleCards(navController = navController, articleList = articles)
        }
    }
}
@Composable
fun ArticleFilters(
    ArticleCategoryList: List<ArticleCategory>,
    //modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(id = R.string.read_latest_news),
            modifier = Modifier.padding(bottom = 0.dp),
            style = MaterialTheme.typography.titleLarge
        )
        LazyRow() {
            items(ArticleCategoryList) { ArticleCategory ->
                ArticleFilterChip(ArticleCategory.articleCategory)
                Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.spacer_height_medium)))
            }
        }
    }

}

@Composable
fun ArticleCards(
    articleList: List<Article>,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium)),
    ) {
        items(articleList) { article ->
            ArticleCard(
                title = stringResource(id = article.title),
                content = stringResource(id = article.content),
                timeToRead = integerResource(article.timeToRead),
                navController = navController,
                image = article.image
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun LearnScreenPreview(){
    //var filterCategories = DataSource().loadLearnCategories()
    //LearnFilters(filterCategories)
    LearnScreen()
}
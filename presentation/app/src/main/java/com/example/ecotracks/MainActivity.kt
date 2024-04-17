package com.example.ecotracks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import com.example.ecotracks.data.UserDatabase
import com.example.ecotracks.ui.theme.EcoTracksTheme
import com.example.ecotracks.ui.SignUpScreen
import com.example.ecotracks.ui.LoginScreen
import com.example.ecotracks.ui.OnBoardingScreen
import com.example.ecotracks.ui.HomeScreen
import com.example.ecotracks.ui.LearnScreen
import com.example.ecotracks.ui.Navigation
import com.example.ecotracks.ui.ArticleScreen
import com.example.ecotracks.ui.PostsScreen
import com.example.ecotracks.ui.PostsList
import com.example.ecotracks.ui.components.TransportDuration
import com.example.ecotracks.ui.components.TransportActivity
import com.example.ecotracks.ui.TransportActivityScreen
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EcoTracksTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //TransportActivityScreen()
                    //TransportActivity()
                    //TransportDuration()
                    //PostsScreen()
                    //PostsList()
                    //LoginScreen()
                    SignUpScreen()
                    //Navigation()
                    //HomeScreen()
                    //LearnScreen()
                    /*ArticleScreen(
                        title = stringResource(id = R.string.article_title),
                        content = stringResource(id = R.string.article_content)
                    )*/
                }
            }
        }
    }
}
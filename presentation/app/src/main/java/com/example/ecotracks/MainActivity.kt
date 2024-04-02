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
import androidx.compose.ui.tooling.preview.Preview
import com.example.ecotracks.ui.theme.EcoTracksTheme
import com.example.ecotracks.ui.SignUpScreen
import com.example.ecotracks.ui.LoginScreen
import com.example.ecotracks.ui.OnBoardingScreen
import com.example.ecotracks.ui.Stats
import com.example.ecotracks.ui.HomeScreen
import com.example.ecotracks.ui.LearnScreen
import com.example.ecotracks.ui.Navigation

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
                    //LoginScreeen()
                    //SignUpScreen()
                    //Navigation()
                    //HomeScreen()
                    LearnScreen()
                }
            }
        }
    }
}
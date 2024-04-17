package com.example.ecotracks.ui

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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Arrangement
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
import androidx.navigation.NavType
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.ecotracks.ui.LearnScreen
import com.example.ecotracks.ui.components.EmissionBottomSheet


@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "sign_up"
    ) {
        composable(route = "onboarding") {
            OnBoardingScreen(navController = navController)
        }
        composable(route = "home") {
            HomeScreen(navController = navController)
        }
        composable(route = "learn") {
            LearnScreen(navController = navController)
        }
        composable(route = "sign_up") {
            SignUpScreen(navController = navController)
        }
        composable(route = "add_transport_activity") {
            TransportActivityScreen(navController = navController)
        }

        composable(route = "login") {
            LoginScreen(navController = navController)
        }

        composable(
            route = "article/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { NavType.StringType},
                navArgument("content") { type = NavType.StringType},
                navArgument("image") { type = NavType.IntType})
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title")
            val content = backStackEntry.arguments?.getString("content")
            val image = backStackEntry.arguments?.getInt("image")
            ArticleScreen(navController = navController,title = title, content = content, image = image)
        }
    }
}
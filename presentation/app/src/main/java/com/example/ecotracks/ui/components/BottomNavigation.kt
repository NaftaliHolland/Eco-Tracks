package com.example.ecotracks.ui.components

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.ecotracks.ui.Screen
import com.example.ecotracks.ui.Navigation
import androidx.navigation.compose.rememberNavController

@Composable
fun BottomBar(navController: NavHostController = rememberNavController()) {
    BottomNavigation(
        elevation = 12.dp,
        backgroundColor = MaterialTheme.colorScheme.primaryContainer,
        modifier = Modifier.clip(shape = RoundedCornerShape(topStart = 18.dp, topEnd = 18.dp))

    ) {
        BottomNavigationItem(
            icon = { Icon(
                painter = painterResource(id = R.drawable.home_24px),
                contentDescription = "",
                tint = MaterialTheme.colorScheme.tertiaryContainer
            ) },
            selected = false,
            label = { Text(stringResource(id = R.string.home)) },
            onClick = { navController.navigate("home") }
        )
        BottomNavigationItem(
            icon = { Icon(
                painter = painterResource(id = R.drawable.learn),
                contentDescription = "",
                tint = MaterialTheme.colorScheme.tertiaryContainer
            ) },
            selected = false,
            label = { Text(stringResource(id = R.string.learn)) },
            onClick = { navController.navigate("learn")}
        )
        BottomNavigationItem(
            icon = { Icon(
                painter = painterResource(id = R.drawable.home_24px),
                contentDescription = "",
                tint = MaterialTheme.colorScheme.tertiaryContainer
            ) },
            selected = false,
            label = { Text(stringResource(id = R.string.learn)) },
            onClick = { }
        )
        BottomNavigationItem(
            icon = { Icon(
                painter = painterResource(id = R.drawable.home_24px),
                contentDescription = "",
                tint = MaterialTheme.colorScheme.tertiaryContainer
            ) },
            selected = false,
            label = { Text(stringResource(id = R.string.learn)) },
            onClick = { }
        )
    }
}

@Composable
fun FloatingButton(onClick: () -> Unit = {}) {
    FloatingActionButton(
        onClick = { onClick() },
        shape = CircleShape,
        containerColor = MaterialTheme.colorScheme.primary
    ) {
        Row(
            modifier = Modifier
                .size(width = 450.dp, height = 60.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.add_circle_24px),
                contentDescription = "FloatingActionButton",
            )
            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_medium)))
            Text(
                text = stringResource(id = R.string.record_emission)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BottomBarPreview() {
    BottomBar()
}

@Preview
@Composable
fun floatingActionButtonPreview() {
    FloatingButton()
}
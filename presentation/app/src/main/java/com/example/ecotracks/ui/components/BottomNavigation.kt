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
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
/**
@Composable
fun BottomAppBar() {
    BottomAppBar(
        actions = {
            IconButton(onClick = { /* do something */ }) {
                Icon(painter = painterResource(id = R.drawable.visibility_24px), contentDescription = "Localized description")
            }
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.home_24px),
                    contentDescription = "Localized description"
                )
            }
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.home_24px),
                    contentDescription = "Localized description"
                )
            }
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.home_24px),
                    contentDescription = "Localized description"
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* TO DO */ },
                containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
            ) {
                Icon(painter = painterResource(id = R.drawable.add_circle_24px), "Localized description")
            }
        }
    )
}
**/

/**
@Composable
fun BottomBarSample() {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "icon")
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        bottomBar = {
            BottomAppBar(

            ) {

            }
        }

    ){}
} **/

@Composable
fun BottomBar(modifier: Modifier = Modifier) {

    var navNum by remember {
        mutableStateOf(0)
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            //.background(CardColor)
            .padding(vertical = 15.dp, horizontal = 15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (navNum == 0) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.home_24px),
                        contentDescription = "home",
                        //tint = SecondaryColor,
                        modifier = Modifier
                            .size(25.dp)
                    )
                }

            } else {
                IconButton(onClick = { navNum = 0 }) {
                    Icon(
                        painter = painterResource(id = R.drawable.school_24px),
                        contentDescription = "home",
                        //tint = ThinTextColor,
                        modifier = Modifier
                            .size(25.dp)
                    )
                }
            }


            Spacer(modifier = Modifier.width(8.dp))
            if (navNum == 1) {

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.settings_24px),
                        contentDescription = "home",
                        //tint = SecondaryColor,
                        modifier = Modifier.size(25.dp)
                    )
                }
            } else {
                IconButton(onClick = { navNum = 1 }) {
                    Icon(
                        painter = painterResource(id = R.drawable.add_circle_24px),
                        contentDescription = "home",
                        //tint = ThinTextColor,
                        modifier = Modifier.size(25.dp)
                    )
                }
            }
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (navNum == 2) {

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.home_24px),
                        contentDescription = "home",
                        //tint = SecondaryColor,
                        modifier = Modifier.size(25.dp)
                    )
                }
            } else {
                IconButton(onClick = { navNum = 2 }) {
                    Icon(
                        painter = painterResource(id = R.drawable.settings_24px),
                        contentDescription = "home",
                        //tint = ThinTextColor,
                        modifier = Modifier.size(25.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            if (navNum == 3) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.home_24px),
                        contentDescription = "home",
                        //tint = SecondaryColor,
                        modifier = Modifier.size(25.dp)
                    )
                }
            } else {
                IconButton(onClick = { navNum = 3 }) {
                    Icon(
                        painter = painterResource(id = R.drawable.home_24px),
                        contentDescription = "home",
                        //tint = ThinTextColor,
                        modifier = Modifier.size(25.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomAppBarPreview() {
    /**Scaffold(
        bottomBar = { BottomAppBar() },
        floatingActionButtonPosition = FabPosition.Center
    ){}
    **/
    BottomBar()
}
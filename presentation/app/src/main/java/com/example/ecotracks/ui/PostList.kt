package com.example.ecotracks.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.example.ecotracks.ui.MainViewModel
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun PostsScreen(mainViewModel: MainViewModel = MainViewModel()) {

    val postState by mainViewModel.postState.collectAsState()

//fun PostsList(viewModel: MainViewModel = MainViewModel())

    Column() {

        Button(
            onClick = {
                MainViewModel().getPosts()
                println(postState.posts)
            }
        ) {
            Text(text = "Get stuff")
        }
        PostsList()

    }
}

@Composable
fun PostsList(mainViewModel: MainViewModel = viewModel()) {
    val posts by MainViewModel().posts.collectAsState()
    LazyColumn {
        items(posts) { post ->
            Text(text = post.title)
            println(post.title)
        }
        item {
            Text("Hello")
        }
    }
}

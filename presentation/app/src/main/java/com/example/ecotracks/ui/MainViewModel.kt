package com.example.ecotracks.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecotracks.model.MainState
import com.example.ecotracks.network.EcoTracksApi
import com.example.ecotracks.model.Post
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val _postState = MutableStateFlow(MainState())
    val postState: StateFlow<MainState> = _postState.asStateFlow()

    private val apiService = EcoTracksApi.retrofitService
    private val _posts : MutableStateFlow<List<Post>> = MutableStateFlow(listOf())
    //val posts: MutableState < List < Post >> = mutableStateOf(emptyList())
    val posts : StateFlow<List<Post>> = _posts

    fun getPosts() {
        viewModelScope.launch {
            try {
                val response = apiService.getPosts()

                _postState.update { currentState ->
                    currentState.copy(
                        posts = response
                    )
                }

                println(_postState.value)
                if (response.isNotEmpty()) {
                    _posts.value = response
                }
            } catch (e: Exception) {
                println(e)
                /* TODO HANDLE ERRORS */
            }
        }
    }
}
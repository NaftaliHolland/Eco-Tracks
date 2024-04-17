package com.example.ecotracks.network

//import com.example.ecotracks.model.User
import com.example.ecotracks.model.Post
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import retrofit2.Retrofit
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://jsonplaceholder.typicode.com"

private val retrofit = Retrofit.Builder()
    //.addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface EcoTracksApiService {
    @GET("posts")
    suspend fun getPosts(): List<Post>
}

object EcoTracksApi {
    val retrofitService: EcoTracksApiService by lazy {
        retrofit.create(EcoTracksApiService::class.java)
    }
}
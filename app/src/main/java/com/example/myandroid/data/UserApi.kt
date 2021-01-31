package com.example.myandroid.data

import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {

    @GET("users/{id}")
    suspend fun getUser(@Path("id") id: String): UserResponse
}
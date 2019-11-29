package com.example.kotlin_retrofit


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Multipart
import java.util.*
import javax.security.auth.callback.Callback


interface ApiService {
    @GET("/films")
    fun fetchAllUsers(): Call<List<User>>

}
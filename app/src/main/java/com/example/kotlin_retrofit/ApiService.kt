package com.example.kotlin_retrofit


import android.telecom.Call
import retrofit2.http.GET
import retrofit2.http.Multipart
import javax.security.auth.callback.Callback


interface ApiService {
@GET("/users")
fun fetchAllUsers(): Call<List<User>>

}
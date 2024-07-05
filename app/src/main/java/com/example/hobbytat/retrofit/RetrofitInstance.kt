package com.example.hobbytat.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val retrofit = Retrofit.Builder()
        .baseUrl("13.209.167.23:8080")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
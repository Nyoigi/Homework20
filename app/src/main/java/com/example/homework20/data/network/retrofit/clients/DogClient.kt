package com.example.homework20.data.network.retrofit.clients

import com.example.homework20.data.network.retrofit.services.DogService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object DogClient {

    val dogService: DogService = Retrofit.Builder()
        .baseUrl("https://api.thedogapi.com/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()
        .create(DogService::class.java)
}
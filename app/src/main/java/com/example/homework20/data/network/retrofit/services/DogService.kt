package com.example.homework20.data.network.retrofit.services

import com.example.homework20.data.network.retrofit.models.Dog
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface DogService {

    @GET("images/search")
    fun getDog(): Single<List<Dog>>
}
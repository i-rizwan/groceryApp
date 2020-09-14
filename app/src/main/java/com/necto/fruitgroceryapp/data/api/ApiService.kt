package com.necto.fruitgroceryapp.data.api

import com.necto.fruitgroceryapp.data.model.User
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("/users")
    fun getUsers(): Single<List<User>>

}
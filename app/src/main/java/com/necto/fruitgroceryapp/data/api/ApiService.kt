package com.necto.fruitgroceryapp.data.api

import com.necto.fruitgroceryapp.data.model.User
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers(): List<User>

}
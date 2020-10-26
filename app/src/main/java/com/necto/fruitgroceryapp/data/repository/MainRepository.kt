package com.necto.fruitgroceryapp.data.repository

import com.necto.fruitgroceryapp.data.api.ApiHelper


class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getUsers() = apiHelper.getUsers()

}
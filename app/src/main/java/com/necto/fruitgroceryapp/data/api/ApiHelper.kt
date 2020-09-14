package com.necto.fruitgroceryapp.data.api

class ApiHelper(private val apiService: ApiService) {
    fun getUsers() = apiService.getUsers()

}
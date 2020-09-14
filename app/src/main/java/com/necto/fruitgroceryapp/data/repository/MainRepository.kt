package com.necto.fruitgroceryapp.data.repository

import com.necto.fruitgroceryapp.data.api.ApiHelper
import com.necto.fruitgroceryapp.data.model.User
import io.reactivex.Single

class MainRepository(private val apiHelper: ApiHelper) {

    fun getUsers(): Single<List<User>> {
        return apiHelper.getUsers()
    }

}
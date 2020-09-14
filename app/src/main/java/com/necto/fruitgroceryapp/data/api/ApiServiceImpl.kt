package com.necto.fruitgroceryapp.data.api

import com.necto.fruitgroceryapp.data.model.User
import com.necto.fruitgroceryapp.utils.Constants
import io.reactivex.Single

class ApiServiceImpl : ApiService {
    private val api = NetworkConfig.useService(Constants.BASE_URL)

    override fun getUsers(): Single<List<User>> {
        return api.getUsers();

    }
}
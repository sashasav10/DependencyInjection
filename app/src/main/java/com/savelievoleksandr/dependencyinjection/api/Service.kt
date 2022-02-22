package com.savelievoleksandr.dependencyinjection.api

import com.savelievoleksandr.dependencyinjection.model.Item
import retrofit2.http.GET

interface Service {
    @GET("photos")
    suspend fun getItems(): List<Item>
}
package com.tirupati.network

import com.tirupati.data.DriverDataItem
import retrofit2.Response
import retrofit2.http.GET

interface DriversApi {

    @GET("/data")
    suspend fun getDriversDataFromApi(): Response<DriverDataItem>
}
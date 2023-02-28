package com.tirupati.repo


interface DriversRepository {
    suspend fun getDriversData(): DriversApiResult
}
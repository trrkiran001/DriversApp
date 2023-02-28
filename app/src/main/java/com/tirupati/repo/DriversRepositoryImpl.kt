package com.tirupati.repo

import android.util.Log
import com.tirupati.network.DriversApi
import javax.inject.Inject

class DriversRepositoryImpl @Inject constructor(private val api: DriversApi): DriversRepository {

    override suspend fun getDriversData(): DriversApiResult {
        //TODO("Not yet implemented")
        return try {
            val response = api.getDriversDataFromApi()
            if (response.isSuccessful) {
                DriversApiResult.DriversResult(response.body())
            } else {
                //unsuccessful api request
                Log.i("Kiran ", "printing from Repo Impl -> API result error ")
                DriversApiResult.Error
            }
        } catch (e: Exception) {
            //exception while running api call
            Log.i("Kiran ", "printing from Repo Impl -> API result catch exception ")
            e.printStackTrace()
            DriversApiResult.Error
        }
    }
}
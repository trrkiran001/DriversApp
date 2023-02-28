package com.tirupati.repo

import com.tirupati.data.DriverDataItem

sealed class DriversApiResult {
    object Error: DriversApiResult()
    data class DriversResult(val response: DriverDataItem?): DriversApiResult()
}
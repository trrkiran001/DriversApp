package com.tirupati.data

import com.google.gson.annotations.SerializedName



data class DriverDataItem(
    @SerializedName("drivers") val drivers: List<Driver>,
    @SerializedName("routes") val routes: List<Route>
)

data class Driver(
    @SerializedName("id") val driverId: Int,
    @SerializedName("name") val driverName: String
)

data class Route(
    @SerializedName("id") val routeId: Int,
    @SerializedName("name") val routeName: String,
    @SerializedName("type") val routeType: RouteType
)

enum class RouteType {
    R,
    C,
    I
}
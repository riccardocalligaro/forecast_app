package com.riccardocalligaro.forecastapp.data.network.response


import com.riccardocalligaro.forecastapp.data.db.entity.CurrentWeatherEntry
import com.riccardocalligaro.forecastapp.data.db.entity.Location
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CurrentWeatherResponse(
    @Json(name = "current")
    val currentWeatherEntry: CurrentWeatherEntry,
    @Json(name = "location")
    val location: Location,
    @Json(name = "request")
    val request: Request
)
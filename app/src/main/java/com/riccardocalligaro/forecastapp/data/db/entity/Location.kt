package com.riccardocalligaro.forecastapp.data.db.entity


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Location(
    val country: String,
    val lat: String,
    val localtime: String,
    val localtimeEpoch: Int,
    val lon: String,
    val name: String,
    val region: String,
    @Json(name = "timezone_id")
    val timezoneId: String,
    @Json(name = "utc_offset")
    val utcOffset: String
)
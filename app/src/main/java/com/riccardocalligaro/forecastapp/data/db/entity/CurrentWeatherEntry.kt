package com.riccardocalligaro.forecastapp.data.db.entity


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CurrentWeatherEntry(
    val cloudcover: Int,

    val feelslike: Int,

    val humidity: Int,

    @Json(name = "is_day")
    val isDay: String,

    @Json(name = "observation_time")
    val observationTime: String,

    val precip: Double,

    val pressure: Double,

    val temperature: Double,

    @Json(name = "uv_index")
    val uvIndex: Double,

    val visibility: Double,

    @Json(name = "weather_code")
    val weatherCode: Int,

    @Json(name = "weather_descriptions")
    val weatherDescriptions: List<String>,

    @Json(name = "weather_icons")
    val weatherIcons: List<String>,

    @Json(name = "wind_degree")
    val windDegree: Double,

    @Json(name = "wind_dir")
    val windDir: String,
    
    @Json(name = "wind_speed")
    val windSpeed: Double
)
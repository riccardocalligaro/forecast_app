package com.riccardocalligaro.forecastapp.data.network.sources

import androidx.lifecycle.LiveData
import com.riccardocalligaro.forecastapp.data.network.response.CurrentWeatherResponse

interface WeatherNetworkDataSource  {

    val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>

    suspend fun fetchCurrentWeather(
        location:  String
    )
}
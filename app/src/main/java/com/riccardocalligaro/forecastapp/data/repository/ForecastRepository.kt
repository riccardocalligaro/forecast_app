package com.riccardocalligaro.forecastapp.data.repository

import androidx.lifecycle.LiveData
import com.riccardocalligaro.forecastapp.data.db.entity.CurrentWeatherEntry

interface ForecastRepository {
    suspend fun getCurrentWeather() : LiveData<CurrentWeatherEntry>
}
package com.riccardocalligaro.forecastapp

import android.app.Application
import com.riccardocalligaro.forecastapp.data.db.dao.CurrentWeatherDao
import com.riccardocalligaro.forecastapp.data.db.database.ForecastDatabase
import com.riccardocalligaro.forecastapp.data.network.WeatherStackApiService
import com.riccardocalligaro.forecastapp.data.network.interceptors.ConnectivityInterceptor
import com.riccardocalligaro.forecastapp.data.network.interceptors.ConnectivityInterceptorImpl
import com.riccardocalligaro.forecastapp.data.network.sources.WeatherNetworkDataSource
import com.riccardocalligaro.forecastapp.data.network.sources.WeatherNetworkDataSourceImpl
import com.riccardocalligaro.forecastapp.data.repository.ForecastRepository
import com.riccardocalligaro.forecastapp.data.repository.ForecastRepositoryImpl
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class ForecastApplication : Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@ForecastApplication))

        // forecast databaase
        bind() from singleton { ForecastDatabase(instance()) }

        // daos
        bind() from singleton { instance<ForecastDatabase>().currentWeatherDao() }

        // api service
        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }
        bind() from singleton { WeatherStackApiService(instance()) }
        bind<WeatherNetworkDataSource>() with singleton { WeatherNetworkDataSourceImpl(instance()) }

        // repositories
        bind<ForecastRepository>() with singleton { ForecastRepositoryImpl(instance(), instance()) }


    }
}
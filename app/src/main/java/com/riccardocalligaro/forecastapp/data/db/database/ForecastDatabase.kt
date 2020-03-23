package com.riccardocalligaro.forecastapp.data.db.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.riccardocalligaro.forecastapp.data.db.dao.CurrentWeatherDao
import com.riccardocalligaro.forecastapp.data.db.entity.CurrentWeatherEntry

@Database(
    entities = [
        CurrentWeatherEntry::class
    ],
    version = 1
)

abstract class ForecastDatabase : RoomDatabase() {
    abstract fun currentWeatherDao(): CurrentWeatherDao

    companion object {
        @Volatile
        private var instance: ForecastDatabase? = null

        // sample object to prevent 2 instances
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ForecastDatabase::class.java,
                "forecast.db"
            ).build()
    }
}
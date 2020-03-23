package com.riccardocalligaro.forecastapp.data.network

import android.util.Log
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.riccardocalligaro.forecastapp.data.network.response.CurrentWeatherResponse
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "dc719a2229a0c80ce23134fbced0a82d"
const val BASE_URL = "http://api.weatherstack.com/"

// http://api.weatherstack.com/current?access_key=dc719a2229a0c80ce23134fbced0a82d&query=New%20York
interface WeatherStackApiService {

    @GET("current")
    fun getCurrentWeatherAsync(
        @Query("query") location: String,
        @Query("unit") unit: String = "m"
    ) : Deferred<CurrentWeatherResponse>
    
    companion object {
        operator fun invoke() : WeatherStackApiService {
            val requestInterceptor = Interceptor { chain ->
                val url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("access_key",
                        API_KEY
                    )
                    .build()


                Log.i("Request url", url.url().toString())
                val request = chain.request().newBuilder().url(url).build()

                return@Interceptor chain.proceed(request)
            }



            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(WeatherStackApiService::class.java)
        }
    }
}
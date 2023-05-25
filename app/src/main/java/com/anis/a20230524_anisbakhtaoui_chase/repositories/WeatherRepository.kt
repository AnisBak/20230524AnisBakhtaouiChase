package com.anis.a20230524_anisbakhtaoui_chase.repositories

import com.anis.a20230524_anisbakhtaoui_chase.api.ApiInterceptor
import com.anis.a20230524_anisbakhtaoui_chase.api.WeatherApi
import com.anis.a20230524_anisbakhtaoui_chase.api.ApiResponse
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create



class WeatherRepository {
    private val weatherApi: WeatherApi

    init {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(ApiInterceptor())
            .build()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .build()
        weatherApi = retrofit.create()
    }



    suspend fun searchCity(city: String, lon:String, lat:String): ApiResponse =
        weatherApi.searchCity(city, lon, lat)
}
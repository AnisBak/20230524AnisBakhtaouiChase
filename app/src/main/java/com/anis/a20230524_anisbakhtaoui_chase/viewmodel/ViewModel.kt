package com.anis.a20230524_anisbakhtaoui_chase.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anis.a20230524_anisbakhtaoui_chase.api.ApiResponse
import com.anis.a20230524_anisbakhtaoui_chase.model.Main
import com.anis.a20230524_anisbakhtaoui_chase.model.Weather
import com.anis.a20230524_anisbakhtaoui_chase.model.Wind
import com.anis.a20230524_anisbakhtaoui_chase.repositories.WeatherRepository
import com.anis.a20230524_anisbakhtaoui_chase.ui.UiState
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel(){

    private val weatherRepository = WeatherRepository()
    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()
    private var fetchJob: Job? = null




    fun fetchWeather(city: String="", lon:String="", lat:String="") {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                val weatherApiResponse = _fetchWeather(city,lon,lat)
                _uiState.update {
                    it.copy(weather = weatherApiResponse.weather[0], main = weatherApiResponse.main,wind = weatherApiResponse.wind, message = null)
                }
            } catch (ex: Exception) {
                _uiState.update {
                    it.copy(weather = Weather(),wind = Wind(), main= Main(), message = ex.message )
                }
            }
        }
    }
    private suspend fun _fetchWeather(city: String, lon:String, lat:String): ApiResponse {
        return weatherRepository.searchCity(city,lon,lat)
    }

}
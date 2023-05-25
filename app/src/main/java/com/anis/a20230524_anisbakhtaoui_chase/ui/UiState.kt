package com.anis.a20230524_anisbakhtaoui_chase.ui

import com.anis.a20230524_anisbakhtaoui_chase.model.Main
import com.anis.a20230524_anisbakhtaoui_chase.model.Weather
import com.anis.a20230524_anisbakhtaoui_chase.model.Wind

data class UiState(
    val weather: Weather = Weather(),
    val message: String?=null,
    val wind: Wind = Wind(),
    val main: Main = Main(),
    var location: Boolean = false
)

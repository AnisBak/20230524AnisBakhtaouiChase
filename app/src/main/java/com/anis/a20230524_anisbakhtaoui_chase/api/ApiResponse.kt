package com.anis.a20230524_anisbakhtaoui_chase.api

import com.anis.a20230524_anisbakhtaoui_chase.model.Main
import com.anis.a20230524_anisbakhtaoui_chase.model.Weather
import com.anis.a20230524_anisbakhtaoui_chase.model.Wind
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiResponse(
    val weather: List<Weather>,
    val wind: Wind,
    val main: Main
)

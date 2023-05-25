package com.anis.a20230524_anisbakhtaoui_chase.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Main(
    val temp: String? = null,
    val temp_min: String? = null,
    val temp_max: String? = null
)

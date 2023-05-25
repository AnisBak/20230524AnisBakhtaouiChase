package com.anis.a20230524_anisbakhtaoui_chase.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Wind(
    val speed: String? = null,
    val deg: String? =null
)

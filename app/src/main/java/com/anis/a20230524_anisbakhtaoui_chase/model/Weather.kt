package com.anis.a20230524_anisbakhtaoui_chase.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Weather(
    val id: String? =null,
    val main:String?=null,
    val description:String?=null,
    val icon: String?=null,
)

package com.example.workaroundproject.cat_retrofit.data.entities

import com.squareup.moshi.Json

data class CatFactDto(
    @field:Json(name = "fact") val fact: String,
    @field:Json(name = "length") val length: Int
)
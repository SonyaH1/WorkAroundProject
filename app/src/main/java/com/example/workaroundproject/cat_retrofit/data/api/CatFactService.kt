package com.example.workaroundproject.cat_retrofit.data.api

import com.example.workaroundproject.cat_retrofit.data.entities.CatFactDto
import retrofit2.http.GET

interface CatFactService {
    @GET("fact")
    suspend fun getCatFact(): CatFactDto
}
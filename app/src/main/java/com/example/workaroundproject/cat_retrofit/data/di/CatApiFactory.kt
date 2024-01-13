package com.example.workaroundproject.cat_retrofit.data.di

import com.example.workaroundproject.cat_retrofit.data.api.CatFactService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://catfact.ninja/"

internal object CatApiFactory {
    fun create(): CatFactService {

        val client = OkHttpClient.Builder()
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(CatFactService::class.java)
    }
}
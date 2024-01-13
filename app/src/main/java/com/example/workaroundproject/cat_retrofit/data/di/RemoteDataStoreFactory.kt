package com.example.workaroundproject.cat_retrofit.data.di

import com.example.workaroundproject.cat_retrofit.domain.datastore.RemoteRepository
import com.example.workaroundproject.cat_retrofit.data.datastore.CatFactRepository


object RemoteDataStoreFactory {

    fun create(): RemoteRepository {
        val api = CatApiFactory.create()
        return CatFactRepository(api = api)
    }
}
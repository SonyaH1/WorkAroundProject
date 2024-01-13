package com.example.workaroundproject.cat_retrofit.domain.datastore

import com.example.workaroundproject.cat_retrofit.domain.model.CatFact

interface RemoteRepository {

    suspend fun getCatFact(): CatFact
}
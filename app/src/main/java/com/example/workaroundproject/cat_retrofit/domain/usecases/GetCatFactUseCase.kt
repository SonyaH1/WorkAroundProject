package com.example.workaroundproject.cat_retrofit.domain.usecases

import com.example.workaroundproject.cat_retrofit.domain.model.CatFact

interface GetCatFactUseCase {

    suspend fun getCatFact(): CatFact
}
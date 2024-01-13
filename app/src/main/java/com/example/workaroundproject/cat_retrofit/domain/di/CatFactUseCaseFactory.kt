package com.example.workaroundproject.cat_retrofit.domain.di

import com.example.workaroundproject.cat_retrofit.domain.datastore.RemoteRepository
import com.example.workaroundproject.cat_retrofit.domain.usecases.GetCatFactUseCaseImpl
import com.example.workaroundproject.cat_retrofit.domain.usecases.GetCatFactUseCase

object CatFactUseCaseFactory {
    fun create(remoteRepository: RemoteRepository): GetCatFactUseCase {
        return GetCatFactUseCaseImpl(remoteRepository)
    }
}
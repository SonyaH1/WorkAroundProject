package com.example.workaroundproject.cat_retrofit.domain.usecases

import com.example.workaroundproject.cat_retrofit.domain.datastore.RemoteRepository
import com.example.workaroundproject.cat_retrofit.domain.model.CatFact

internal class GetCatFactUseCaseImpl(
    private val remoteRepository: RemoteRepository
) : GetCatFactUseCase {
    override suspend fun getCatFact(): CatFact {
        return remoteRepository.getCatFact()
    }

}
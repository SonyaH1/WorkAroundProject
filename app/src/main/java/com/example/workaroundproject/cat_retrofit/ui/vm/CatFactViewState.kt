package com.example.workaroundproject.cat_retrofit.ui.vm

import com.example.workaroundproject.cat_retrofit.domain.model.CatFact

sealed class CatFactViewState {

    object Loading : CatFactViewState()

    data class Success(
        val data: CatFact
    ) : CatFactViewState()

    data class Failure(
        val errorMessage: String
    ) : CatFactViewState()
}
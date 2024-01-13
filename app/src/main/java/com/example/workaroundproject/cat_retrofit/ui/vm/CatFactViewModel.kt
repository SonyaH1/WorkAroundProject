package com.example.workaroundproject.cat_retrofit.ui.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.workaroundproject.cat_retrofit.data.di.RemoteDataStoreFactory
import com.example.workaroundproject.cat_retrofit.domain.di.CatFactUseCaseFactory
import com.example.workaroundproject.cat_retrofit.domain.usecases.GetCatFactUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CatFactViewModel : ViewModel() {

    private val getCatFactUseCase: GetCatFactUseCase = CatFactUseCaseFactory.create(
        RemoteDataStoreFactory.create()
    )

    private val _catFactViewStateFlow: MutableStateFlow<CatFactViewState> =
        MutableStateFlow(CatFactViewState.Loading)
    val catFactViewStateFlow: StateFlow<CatFactViewState> = _catFactViewStateFlow.asStateFlow()

    /*
    by using init block we can initialize logic
    right after viewModel creation
     */
    init {
        getCatFact()
    }

    fun getCatFact() {
        viewModelScope.launch {

            _catFactViewStateFlow.value = CatFactViewState.Loading

            kotlin.runCatching {
                getCatFactUseCase.getCatFact()
            }.fold(
                onSuccess = { catFact ->
                    _catFactViewStateFlow.value = CatFactViewState.Success(catFact)
                },
                onFailure = { error ->
                    _catFactViewStateFlow.value = CatFactViewState.Failure(
                        errorMessage = error.localizedMessage ?: "Something went wrong"
                    )
                }
            )
        }
    }
}
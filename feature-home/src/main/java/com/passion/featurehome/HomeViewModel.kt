package com.passion.featurehome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.passion.models.Country
import com.passion.services.CountriesService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class HomeViewModel(
    private val countryService: CountriesService
) : ViewModel() {

    init {
        viewModelScope.launch {
            try {
                getCountry()
            } catch (e: Exception) {
                _state.emit(UiState.Error(e))
            }
        }
    }

    private val _state by lazy {
        MutableStateFlow<UiState<List<Country>>>(UiState.Loading())
    }
    val state by lazy { _state.asStateFlow() }

    private suspend fun getCountry() {
        val country = countryService.retrieveCountryByName()
        _state.emit(
            UiState.Success(country)
        )
    }
}


data class ScreenState<T>(
    val result: T?,
    val error: Throwable?,
    val isLoading: Boolean = false
)

sealed class UiState<T> {
    class Loading<T> : UiState<T>()
    data class Success<T>(val value: T) : UiState<T>()
    data class Error<T>(val cause: Throwable) : UiState<T>()
}




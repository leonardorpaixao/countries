package com.passion.featurehome

import androidx.lifecycle.ViewModel
import cafe.adriel.dalek.Dalek
import cafe.adriel.dalek.DalekEvent
import com.passion.models.Country
import com.passion.services.CountriesService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

@ExperimentalCoroutinesApi
class HomeViewModel(
    private val countryService: CountriesService
): ViewModel() {

    fun getCountry(): Flow<DalekEvent<Country>> =
        Dalek(Dispatchers.IO){
            countryService.retrieveCountryByName()
        }
}
package com.passion.services

import com.passion.models.Country

interface CountriesService {

    suspend fun retrieveCountryByName(): Country
}
package com.passion.serviceopen

import com.passion.helpers.KTorBuilder
import com.passion.models.Country
import com.passion.models.CountryResponse
import com.passion.services.CountriesService

class CountryInfrastructure(
    private val api: KTorBuilder,
) : CountriesService {

    override suspend fun retrieveCountryByName(): Country =
        api.get<CountryResponse>("/name/brazil")
            .let(CountryMapper::countryResponseToDomain)
}

object CountryMapper {
    fun countryResponseToDomain(response: CountryResponse): Country =
        response.run {
            Country(
                name = name,
                capital = capital,
                altSpellings = altSpellings,
                region = region,
                subregion = subregion,
                population = population,
                borders = borders,
                nativeName = nativeName,
                currencies = currencies,
                languages = languages,
            )
        }
}
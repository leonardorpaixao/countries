package com.passion.di

import com.passion.helpers.KTorBuilder
import com.passion.serviceopen.CountryInfrastructure
import com.passion.services.CountriesService
import kotlinx.coroutines.Dispatchers
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider

val networkModule = DI.Module(name = "network-module") {

    bind<KTorBuilder>() with provider {
        KTorBuilder(dispatcher = Dispatchers.IO)
    }

    bind<CountriesService>() with provider {
        CountryInfrastructure(
            api = instance()
        )
    }
}
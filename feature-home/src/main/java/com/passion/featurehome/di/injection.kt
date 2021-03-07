package com.passion.featurehome.di

import com.passion.featurehome.HomeViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider

@ExperimentalCoroutinesApi
val homeModule = DI.Module(name = "home-module") {

    bind<HomeViewModel>() with provider {
        HomeViewModel(
            countryService = instance()
        )
    }

}
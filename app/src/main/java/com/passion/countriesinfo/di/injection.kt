package com.passion.countriesinfo.di

import android.app.Application
import com.passion.featurehome.di.homeModule
import networkModule
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.bind
import org.kodein.di.conf.ConfigurableDI
import org.kodein.di.provider

class CoreApp : Application(), DIAware {
    private val appModule = DI.Module(name = "application") {
        bind() from provider {
            this@CoreApp
        }
    }

    override val di: DI
        get() = ConfigurableDI(mutable = true).apply {
            addImport(networkModule)
            addImport(homeModule)
        }
}
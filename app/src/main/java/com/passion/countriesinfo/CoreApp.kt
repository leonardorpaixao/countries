package com.passion.countriesinfo

import android.app.Application
import android.content.Intent
import com.passion.featurehome.di.homeModule
import com.passion.di.networkModule
import com.passion.featurehome.HomeActivity
import kotlinx.coroutines.ExperimentalCoroutinesApi
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

    @ExperimentalCoroutinesApi
    override val di: DI = ConfigurableDI(mutable = true).apply {
            addImport(networkModule)
            addImport(homeModule)
        }

}
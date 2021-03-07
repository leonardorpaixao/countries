package com.passion.featurehome

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import com.passion.models.Country
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.closestDI
import org.kodein.di.instance

class MainActivity : AppCompatActivity(), DIAware {

    override val di by closestDI()
    //private val viewModel by instance<HomeViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //getCountry()
    }

    /*private fun getCountry() {
        viewModel.getCountry()
            .collectIn(lifecycleScope) {
                when (it) {
                    is Start -> toast("loading")
                    is Success -> handleSuccess(it.value)
                    is Failure -> toast("error")
                }

            }
    }*/

    private fun handleSuccess(country: Country) {

    }


    fun Context.toast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}

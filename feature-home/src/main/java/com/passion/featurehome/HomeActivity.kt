package com.passion.featurehome

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import cafe.adriel.dalek.Failure
import cafe.adriel.dalek.Start
import cafe.adriel.dalek.Success
import cafe.adriel.dalek.collectIn
import com.passion.models.Country
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.kodein.di.DIAware
import org.kodein.di.android.closestDI
import org.kodein.di.instance

@ExperimentalCoroutinesApi
class HomeActivity : AppCompatActivity(), DIAware {

    override val di by closestDI()
    //private val viewModel by instance<HomeViewModel>()

    private val viewModel by instance<HomeViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        listenButton()
    }

    private fun listenButton() {
        button.setOnClickListener { getCountry() }
    }

    private fun getCountry() {
        viewModel.getCountry()
            .collectIn(lifecycleScope) {
                when (it) {
                    is Start -> toast("Loading")
                    is Success -> handleSuccess(it.value.first())
                    is Failure -> Log.e("error --> $it", it.toString())
                }
            }
    }

    private fun handleSuccess(country: Country) {
        toast("Success")
        textView.text = country.toString()
    }
}

fun Context.toast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}
package com.passion.featurehome

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.passion.featurehome.ui.theme.CountriesInfoTheme
import com.passion.models.Country
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.kodein.di.DIAware
import org.kodein.di.android.closestDI
import org.kodein.di.instance

@ExperimentalCoroutinesApi
class HomeActivity : AppCompatActivity(), DIAware {

    override val di by closestDI()
    private val viewModel by instance<HomeViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountriesInfoTheme {
                Surface(color = MaterialTheme.colors.primary) {
                    DefaultPreview()
                }
            }
        }
    }

    @Composable
    private fun getCountry() {
        val uiState by lazy {
            viewModel.state
        }

        uiState.collectAsState().value.let {
            when (it) {
                is UiState.Error -> Log.e("Error -----> ${it.cause}", it.cause.message.orEmpty())
                is UiState.Loading -> Log.d("Status -----> LOADING", "LOADING")
                is UiState.Success -> handleSuccess(country = it.value)
            }
        }

    }


    @Composable
    private fun handleSuccess(country: List<Country>?) {
        if (!country.isNullOrEmpty())
            LazyColumn(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(Color(R.color.flag_green))
                    .padding(24.dp)
            ) {
                items(country) { country ->
                    Row() {
                        Text(text = country.name)
                        Text(text = country.capital, Modifier.padding(start = 12.dp))
                    }

                }
            }
        else
            Text(text = "VAZIO")
    }


    @Composable
    fun greeting(name: String) {
        Text(
            text = "Hello $name!",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        CountriesInfoTheme {
            getCountry()
        }
    }

    @Composable
    fun NewsStory() {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxHeight()

        ) {
            Image(
                painter = painterResource(R.drawable.ic_brazil_svgrepo_com),
                contentDescription = "",
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Column(
                Modifier
                    .clip(shape = RoundedCornerShape(8.dp))
                    .background(Color(R.color.flag_green))
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                greeting(name = "There is a list here!")
                LazyColumn(
                    Modifier.padding(top = 24.dp)
                ) {
                    items(retrieveList()) { item ->
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = item,
                                modifier = Modifier
                                    .wrapContentWidth(Alignment.Start)
                                    .padding(top = 8.dp, bottom = 8.dp)
                            )
                            Image(
                                painter = painterResource(R.drawable.ic_lock_black_24dp),
                                contentDescription = "",
                                modifier = Modifier
                                    .wrapContentWidth(Alignment.End)
                                    .align(Alignment.CenterVertically)
                            )
                        }
                    }
                }
                TextField(
                    value = TextFieldValue(""),
                    label = { Text("Entre com um texto legal") },
                    onValueChange = { textChanged: TextFieldValue ->
                        toast(textChanged.text)
                    },
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }
    }
}


private fun retrieveList() = listOf(
    "Leo",
    "Caique",
    "Douglas",
    "Mario"
)

fun Context.toast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}


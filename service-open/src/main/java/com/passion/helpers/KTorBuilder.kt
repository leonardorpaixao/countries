package com.passion.helpers

import com.passion.constants.URL
import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.CoroutineDispatcher
import okhttp3.logging.HttpLoggingInterceptor

class KTorBuilder(val dispatcher: CoroutineDispatcher) {
   val client by lazy {
        HttpClient(OkHttp) {
            engine {
                addInterceptor(HttpLoggingInterceptor())
                config { followRedirects(true) }
            }
            install(HttpTimeout) {}
            install(JsonFeature) { serializer = GsonSerializer() }
            defaultRequest {
                contentType(ContentType.Application.Json)
                headers {
                    append(
                        "x-rapidapi-key", "af48d75ffamsh57da1ec638d3ab8p1d91c3jsn0cf0d0ac3142"
                    )
                }

            }
        }
    }

    suspend inline fun <reified T> get(urlComplement: String): T =
        request(dispatcher) {
            client.get(){
                url { url("https://restcountries-v1.p.rapidapi.com/name/brazil") }
            }
        }

    suspend inline fun <reified T> post(urlComplement: String): T =
        request(dispatcher) {
            client.post(URL.BASE + urlComplement)
        }
}

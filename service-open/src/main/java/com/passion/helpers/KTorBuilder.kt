package com.passion.helpers

import com.passion.constants.ConnectionParams
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
                HttpLoggingInterceptor()
                    .apply { level = HttpLoggingInterceptor.Level.BODY }
                    .let(::addInterceptor)
                config { followRedirects(true) }
            }
            install(HttpTimeout) {}
            install(JsonFeature) { serializer = GsonSerializer() }
            defaultRequest {
                contentType(ContentType.Application.Json)

            }
            HttpResponseValidator {
                validateResponse { response ->
                        //TODO VALIDATE RESPONSE
                }
            }
        }
    }

    suspend inline fun <reified T> get(urlComplement: String): T =
        request(dispatcher) {
            client.get() {
                url { url(ConnectionParams.BASE_URL + urlComplement) }
            }
        }


    suspend inline fun <reified T> post(
        urlComplement: String,
        headers: Map<String, String>?,
        requestBody: Any?
    ): T =
        request(dispatcher) {
            client.post {
                url { url(ConnectionParams.BASE_URL + urlComplement) }
                requestBody?.let { body = it }

            }
        }
}

package com.passion.helpers

import android.util.Log
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.supervisorScope
import kotlinx.coroutines.withContext

suspend fun <T> request(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    action: suspend () -> T
): T =
    supervisorScope {
        withContext(dispatcher) {
            runCatching { action() }
                .getOrElse { error ->
                    Log.e("Error -> $error", error.toString())
                    throw error
                }
        }
    }
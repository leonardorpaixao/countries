package com.passion.helpers

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
                    throw error
                }
        }
    }
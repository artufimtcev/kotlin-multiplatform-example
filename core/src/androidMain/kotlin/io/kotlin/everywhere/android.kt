package io.kotlin.everywhere

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

actual fun createDispatcher(): CoroutineDispatcher {
    return Dispatchers.Main
}
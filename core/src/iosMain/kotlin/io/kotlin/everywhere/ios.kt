package io.kotlin.everywhere

import kotlinx.coroutines.CoroutineDispatcher

actual fun createDispatcher(): CoroutineDispatcher {
    return NativeCoroutineDispatcher()
}
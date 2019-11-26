package io.kotlin.everywhere.presentation

import io.kotlin.everywhere.createDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class CoroutineViewModel: CoroutineScope {

    // Coroutines scope implementation
    private val dispatcher = createDispatcher()
    private val job = Job()
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        this.handleError(throwable)
    }

    override val coroutineContext: CoroutineContext
        get() = this.dispatcher + this.job + this.exceptionHandler


    abstract fun handleError(throwable: Throwable)


    /**
     * Call this method when the presenting view is about to be destroyed to cancel all running jobs.
     */
    fun terminate() {
        this.job.cancel()
    }
}
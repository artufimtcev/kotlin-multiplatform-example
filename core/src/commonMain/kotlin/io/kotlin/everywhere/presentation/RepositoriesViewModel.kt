package io.kotlin.everywhere.presentation

import io.kotlin.everywhere.api.GitHub
import io.kotlin.everywhere.model.GitHubRepo
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class RepositoriesViewModel : CoroutineViewModel() {

    // Endpoint
    val endpoint = GitHub()

    /**
     * Query string for repositories search. Changing this property will trigger the search API
     * request.
     */
    var query: String = ""
    set(value) {
        field = value

        if (value.isEmpty()) {
            this.clear()
        } else {
            this.fetchData(value)
        }
    }

    /**
     * List of GitHub repositories that were fetched last time the query was updated.
     */
    var lastDownloadedRepos: List<GitHubRepo> = emptyList()
    set(value) {
        field = value
        onDataUpdated(value)
    }

    /**
     * Current state of the ViewModel object.
     */
    var state: ViewModelState = ViewModelState.READY
    set(value) {
        field = value
        this.onStateUpdated(value)
    }

    // Observers
    var onDataUpdated: (List<GitHubRepo>) -> Unit = {}
    var onStateUpdated: (ViewModelState) -> Unit = {}
    var onError: (Throwable) -> Unit = {}


    override fun handleError(throwable: Throwable) {
        this.onError(throwable)
        this.state = ViewModelState.ERROR
    }


    private fun fetchData(query: String) {

        // Change state to progress
        this.state = ViewModelState.PROGRESS

        // Spawn a coroutine
        launch {

            // Wait for 300ms
//            delay(300)

            // Fetch if the query is still the same
            if (this@RepositoriesViewModel.query == query) {
                val results = endpoint.search(query)
                state = ViewModelState.READY

                if (this@RepositoriesViewModel.query == query) {
                    lastDownloadedRepos = results.items
                }
            }
        }
    }


    private fun clear() {
        this.lastDownloadedRepos = emptyList()
    }
}
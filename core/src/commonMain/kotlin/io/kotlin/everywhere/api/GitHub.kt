package io.kotlin.everywhere.api

import io.kotlin.everywhere.model.GithubResponse
import io.ktor.client.HttpClient
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.KotlinxSerializer

import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.URLProtocol

private val HOST = "https://api.github.com/search/repositories?q=tetris"

class GitHub {

    val httpClient = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json.nonstrict).apply {

            }
        }
    }


    suspend fun search(query: String): GithubResponse = this.httpClient.get {
        url {
            protocol = URLProtocol.HTTPS
            host = "api.github.com"
            encodedPath = "/search/repositories"
            parameter("q", query)
        }
    }
}
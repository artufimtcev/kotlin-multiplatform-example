package io.kotlin.everywhere.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GithubResponse(

    @SerialName("total_count")
    val totalCount: Int,
    val items: List<GitHubRepo>
)
package io.kotlin.everywhere.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


// Definition from GitHub Docs

//{
//    "id": 3081286,
//    "node_id": "MDEwOlJlcG9zaXRvcnkzMDgxMjg2",
//    "name": "Tetris",
//    "full_name": "dtrupenn/Tetris",
//    "owner": see GithubUser.kt class,
//    "private": false,
//    "html_url": "https://github.com/dtrupenn/Tetris",
//    "description": "A C implementation of Tetris using Pennsim through LC4",
//    "fork": false,
//    "url": "https://api.github.com/repos/dtrupenn/Tetris",
//    "created_at": "2012-01-01T00:31:50Z",
//    "updated_at": "2013-01-05T17:58:47Z",
//    "pushed_at": "2012-01-01T00:37:02Z",
//    "homepage": "",
//    "size": 524,
//    "stargazers_count": 1,
//    "watchers_count": 1,
//    "language": "Assembly",
//    "forks_count": 0,
//    "open_issues_count": 0,
//    "master_branch": "master",
//    "default_branch": "master",
//    "score": 10.309712
//}


@Serializable
data class GitHubRepo(
    val id: Int,
    val name: String,
    val owner: GithubUser,
    @SerialName("description")
    val userDescription: String?,
    val url: String
)
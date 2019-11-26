package io.kotlin.everywhere.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

//    {
//        "login": "dtrupenn",
//        "id": 872147,
//        "node_id": "MDQ6VXNlcjg3MjE0Nw==",
//        "avatar_url": "https://secure.gravatar.com/avatar/e7956084e75f239de85d3a31bc172ace?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-user-420.png",
//        "gravatar_id": "",
//        "url": "https://api.github.com/users/dtrupenn",
//        "received_events_url": "https://api.github.com/users/dtrupenn/received_events",
//        "type": "User"
//    }

@Serializable
data class GithubUser(

    val id: Int,

    @SerialName("login")
    val name: String,

    @SerialName("avatar_url")
    val avatarUrl: String
)
package com.plcoding.githubrepoapp.data.remote.dto

import com.plcoding.githubrepoapp.domain.model.Owner
import com.plcoding.githubrepoapp.domain.model.RepoDetail

data class OwnerDto(
    val avatar_url: String,
    val events_url: String,
    val followers_url: String,
    val following_url: String,
    val gists_url: String,
    val gravatar_id: String,
    val html_url: String,
    val id: Int,
    val login: String,
    val node_id: String,
    val organizations_url: String,
    val received_events_url: String,
    val repos_url: String,
    val site_admin: Boolean,
    val starred_url: String,
    val subscriptions_url: String,
    val type: String,
    val url: String
)

fun OwnerDto.toOwner(): Owner {
    return Owner(
       avatar_url = avatar_url,
        type = type
    )
}
package com.plcoding.githubrepoapp.domain.model

import com.plcoding.githubrepoapp.data.remote.dto.OwnerDto

data class Repo(
    val id: Int,
    val name: String,
    val forks: Int,
    val language: String?,
    val stargazers_count: Int,
    val owner: Owner
    )
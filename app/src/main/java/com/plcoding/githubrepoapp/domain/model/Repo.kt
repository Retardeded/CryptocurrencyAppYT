package com.plcoding.githubrepoapp.domain.model

data class Repo(
    val id: Int,
    val full_name: String,
    val forks: Int,
    val language: String?,
    val stargazers_count: Int
    )
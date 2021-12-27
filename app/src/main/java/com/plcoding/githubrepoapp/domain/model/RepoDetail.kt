package com.plcoding.githubrepoapp.domain.model

import com.plcoding.githubrepoapp.data.remote.dto.License
import com.plcoding.githubrepoapp.data.remote.dto.OwnerDto

data class RepoDetail(
    val id: Int,
    val name: String,
    val forks: Int,
    val language: String?,
    val stargazers_count: Int,

    val description:String?,
    val license: License?,
    val topics: List<String>,

    val created_at: String,
    val updated_at: String,
    val open_issues_count: Int
)
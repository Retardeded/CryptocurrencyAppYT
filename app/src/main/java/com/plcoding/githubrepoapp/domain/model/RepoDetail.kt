package com.plcoding.githubrepoapp.domain.model

import com.plcoding.githubrepoapp.data.remote.dto.License
import com.plcoding.githubrepoapp.data.remote.dto.Organization
import com.plcoding.githubrepoapp.data.remote.dto.Owner

data class RepoDetail(
    val id: Int,
    val full_name: String,
    val forks: Int,
    val language: String?,
    val stargazers_count: Int,

    val description:String?,
    val license: License?,
    val owner: Owner,
    val topics: List<String>
)
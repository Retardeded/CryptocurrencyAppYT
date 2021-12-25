package com.plcoding.cryptocurrencyappyt.domain.model

import com.plcoding.cryptocurrencyappyt.data.remote.dto.License
import com.plcoding.cryptocurrencyappyt.data.remote.dto.Organization
import com.plcoding.cryptocurrencyappyt.data.remote.dto.Owner

data class RepoDetail(
    val id: Int,
    val full_name: String,
    val forks: Int,
    val language: String,
    val stargazers_count: Int,

    val license: License,
    val owner: Owner,
    val organization: Organization
)
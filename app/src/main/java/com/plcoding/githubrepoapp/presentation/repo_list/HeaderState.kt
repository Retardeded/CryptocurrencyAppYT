package com.plcoding.githubrepoapp.presentation.repo_list

import com.plcoding.githubrepoapp.domain.model.Owner
import com.plcoding.githubrepoapp.domain.model.Repo

data class HeaderState(
    val isLoading: Boolean = false,
    val owner: Owner = Owner("", ""),
    val error: String = ""
)
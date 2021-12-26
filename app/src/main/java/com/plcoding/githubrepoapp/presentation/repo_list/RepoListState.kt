package com.plcoding.githubrepoapp.presentation.repo_list

import com.plcoding.githubrepoapp.domain.model.Repo

data class RepoListState(
    val isLoading: Boolean = false,
    val repos: List<Repo> = emptyList(),
    val error: String = ""
)
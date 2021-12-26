package com.plcoding.githubrepoapp.presentation.repo_detail

import com.plcoding.githubrepoapp.domain.model.Repo
import com.plcoding.githubrepoapp.domain.model.RepoDetail

data class RepoDetailState(
    val isLoading: Boolean = false,
    val repo: RepoDetail? = null,
    val error: String = ""
)
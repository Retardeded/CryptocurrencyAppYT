package com.plcoding.githubrepoapp.domain.repository

import com.plcoding.githubrepoapp.data.remote.dto.RepoDetailDto
import com.plcoding.githubrepoapp.data.remote.dto.RepoDto

interface RepoRepository {
    suspend fun getRepos(): List<RepoDto>

    suspend fun getRepoById(repoId:Int): RepoDetailDto
}
package com.plcoding.githubrepoapp.data.repository

import com.plcoding.githubrepoapp.data.remote.GithubApi
import com.plcoding.githubrepoapp.data.remote.dto.RepoDetailDto
import com.plcoding.githubrepoapp.data.remote.dto.RepoDto
import com.plcoding.githubrepoapp.domain.repository.RepoRepository
import javax.inject.Inject

class RepoRepositoryImpl @Inject constructor(
    private val api:GithubApi
):RepoRepository{
    override suspend fun getRepos(): List<RepoDto> {
        return api.getRepos()
    }

    override suspend fun getRepoById(repoId: Int): RepoDetailDto {
        return api.getRepoById(repoId)
    }
}
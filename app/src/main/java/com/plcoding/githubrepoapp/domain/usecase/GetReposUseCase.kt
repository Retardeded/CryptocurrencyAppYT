package com.plcoding.githubrepoapp.domain.usecase

import com.plcoding.githubrepoapp.common.Resource
import com.plcoding.githubrepoapp.data.remote.dto.toRepo
import com.plcoding.githubrepoapp.domain.model.Repo
import com.plcoding.githubrepoapp.domain.model.RepoDetail
import com.plcoding.githubrepoapp.domain.repository.RepoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetReposUseCase @Inject constructor(
    private val repository: RepoRepository
) {
    operator fun invoke(): Flow<Resource<List<Repo>>> = flow {
        try {
            emit(Resource.Loading<List<Repo>>())
            val repos = repository.getRepos().map { it.toRepo() }
            emit(Resource.Success<List<Repo>>(repos))
        } catch(e: HttpException) {
            emit(Resource.Error<List<Repo>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<List<Repo>>("Couldn't reach server. Check your internet connection."))
        }
    }
}
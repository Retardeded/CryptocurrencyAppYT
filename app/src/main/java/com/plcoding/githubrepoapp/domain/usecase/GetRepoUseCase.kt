package com.plcoding.githubrepoapp.domain.usecase

import com.plcoding.githubrepoapp.common.Resource
import com.plcoding.githubrepoapp.data.remote.dto.toRepoDetail
import com.plcoding.githubrepoapp.domain.model.RepoDetail
import com.plcoding.githubrepoapp.domain.repository.RepoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetRepoUseCase @Inject constructor(
    private val repository: RepoRepository
) {
    operator fun invoke(repoId:Int): Flow<Resource<RepoDetail>> = flow {
        try {
            emit(Resource.Loading<RepoDetail>())
            val repo = repository.getRepoById(repoId).toRepoDetail()
            emit(Resource.Success<RepoDetail>(repo))
        } catch(e: HttpException) {
            emit(Resource.Error<RepoDetail>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<RepoDetail>("Couldn't reach server. Check your internet connection."))
        }
    }
}
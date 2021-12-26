package com.plcoding.githubrepoapp.presentation.repo_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.githubrepoapp.common.Constants
import com.plcoding.githubrepoapp.common.Resource
import com.plcoding.githubrepoapp.domain.usecase.GetRepoUseCase
import com.plcoding.githubrepoapp.domain.usecase.GetReposUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RepoDetailViewModel @Inject constructor(
    private val getRepoUseCase: GetRepoUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(RepoDetailState())
    val state: State<RepoDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_REPO_ID)?.let { repoId ->
            getRepo(repoId.toInt())
        }
    }

    private fun getRepo(repoId:Int) {
        getRepoUseCase(repoId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = RepoDetailState(repo = result.data)
                }
                is Resource.Error -> {
                    _state.value = RepoDetailState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = RepoDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
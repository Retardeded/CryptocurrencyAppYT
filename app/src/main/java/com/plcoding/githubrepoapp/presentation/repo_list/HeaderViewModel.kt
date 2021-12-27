package com.plcoding.githubrepoapp.presentation.repo_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.githubrepoapp.common.Resource
import com.plcoding.githubrepoapp.domain.usecase.GetReposUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HeaderViewModel @Inject constructor(
    private val getReposUseCase: GetReposUseCase
) : ViewModel() {

    private val _state = mutableStateOf(HeaderState())
    val state: State<HeaderState> = _state

    init {
        getHeader()
    }

    private fun getHeader() {
        getReposUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = HeaderState(owner = result.data!![0].owner)
                }
                is Resource.Error -> {
                    _state.value = HeaderState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = HeaderState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
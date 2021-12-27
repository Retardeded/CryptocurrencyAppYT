package com.plcoding.githubrepoapp.presentation.repo_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.plcoding.githubrepoapp.presentation.Screen
import com.plcoding.githubrepoapp.presentation.repo_list.components.RepoListHeader
import com.plcoding.githubrepoapp.presentation.repo_list.components.RepoListItem

@Composable
fun RepoListScreen(
    navController: NavController,
    viewModel: RepoListViewModel = hiltViewModel(),
    viewModelHead: HeaderViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val stateHead = viewModelHead.state.value
    Box(modifier = Modifier.fillMaxSize()) {

        RepoListHeader(stateHead.owner, state.repos.size)


        LazyColumn(modifier = Modifier
            .fillMaxHeight(1f)
            .padding(top = 120.dp)) {
            items(state.repos) { repo ->
                RepoListItem(
                    repo = repo,
                    onItemClick = {
                        navController.navigate(Screen.RepoDetailScreen.route + "/${repo.id}")
                    }
                )
            }
        }
        if(state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if(state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}
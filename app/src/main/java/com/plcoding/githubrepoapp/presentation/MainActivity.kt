package com.plcoding.githubrepoapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.plcoding.githubrepoapp.presentation.repo_detail.RepoDetailScreen
import com.plcoding.githubrepoapp.presentation.repo_list.RepoListScreen
import com.plcoding.githubrepoapp.ui.theme.CryptocurrencyAppYTTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptocurrencyAppYTTheme() {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.RepoListScreen.route
                    ) {
                        composable(
                            route = Screen.RepoListScreen.route
                        ) {
                            RepoListScreen(navController)
                        }
                        composable(
                            route = Screen.RepoDetailScreen.route + "/{repoId}"
                        ) {
                            RepoDetailScreen()
                        }
                    }
                }
            }
        }
    }
}
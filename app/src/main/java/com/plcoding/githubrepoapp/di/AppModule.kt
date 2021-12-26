package com.plcoding.githubrepoapp.di

import com.plcoding.githubrepoapp.common.Constants
import com.plcoding.githubrepoapp.data.remote.GithubApi
import com.plcoding.githubrepoapp.data.repository.RepoRepositoryImpl
import com.plcoding.githubrepoapp.domain.repository.RepoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGithubApi(): GithubApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepoRepository(api: GithubApi): RepoRepository {
        return RepoRepositoryImpl(api)
    }
}
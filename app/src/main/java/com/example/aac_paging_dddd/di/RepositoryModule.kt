package com.example.aac_paging_dddd.di

import com.example.aac_paging_dddd.data.remote.paging.GithubPagingRepository
import com.example.aac_paging_dddd.data.remote.paging.GithubPagingRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindRepository(githubPagingRepositoryImpl: GithubPagingRepositoryImpl): GithubPagingRepository
}
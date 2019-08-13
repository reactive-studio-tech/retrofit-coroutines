package com.reactivestudio.retrofitcoroutines.data.repository

import com.reactivestudio.retrofitcoroutines.data.model.GithubOrganization
import com.reactivestudio.retrofitcoroutines.data.model.GithubRepo
import com.reactivestudio.retrofitcoroutines.data.source.remote.RemoteDataSource
import com.reactivestudio.retrofitcoroutines.util.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GithubRepositoryImpl(private val remoteDataSource: RemoteDataSource, private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO): GithubRepository {

    override suspend fun getOrganization(): Result<GithubOrganization> {
        return withContext(ioDispatcher) {
            remoteDataSource.getOrganization()
        }
    }

    override suspend fun getOrganizationRepos(): Result<List<GithubRepo>> {
        return withContext(ioDispatcher) {
            remoteDataSource.getOrganizationRepos()
        }
    }
}
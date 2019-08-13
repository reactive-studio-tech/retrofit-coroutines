package com.reactivestudio.retrofitcoroutines.data.repository

import com.reactivestudio.retrofitcoroutines.data.model.GithubOrganization
import com.reactivestudio.retrofitcoroutines.data.source.remote.RemoteDataSource
import com.reactivestudio.retrofitcoroutines.util.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SampleRepositoryImpl(private val remoteDataSource: RemoteDataSource, private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO): SampleRepository {

    override suspend fun getOrganization(): Result<GithubOrganization> {
        return withContext(ioDispatcher) {
            remoteDataSource.getOrganization()
        }
    }
}
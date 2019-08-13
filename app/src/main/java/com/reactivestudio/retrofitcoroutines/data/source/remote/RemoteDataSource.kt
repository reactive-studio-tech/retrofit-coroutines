package com.reactivestudio.retrofitcoroutines.data.source.remote

import com.reactivestudio.retrofitcoroutines.data.api.SampleApi
import com.reactivestudio.retrofitcoroutines.data.model.GithubOrganization
import com.reactivestudio.retrofitcoroutines.data.source.DataSource
import com.reactivestudio.retrofitcoroutines.util.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RemoteDataSource constructor(private val api: SampleApi, private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO): DataSource {

    override suspend fun getOrganization(): Result<GithubOrganization> = withContext(ioDispatcher) {
        return@withContext try {
            Result.Success(api.getOrganization())
        } catch(e: Exception) {
            Result.Error(e)
        }
    }
}
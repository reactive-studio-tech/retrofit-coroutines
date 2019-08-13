package com.reactivestudio.retrofitcoroutines.data.repository

import com.reactivestudio.retrofitcoroutines.data.model.GithubOrganization
import com.reactivestudio.retrofitcoroutines.util.Result

interface SampleRepository {

    suspend fun getOrganization(): Result<GithubOrganization>
}
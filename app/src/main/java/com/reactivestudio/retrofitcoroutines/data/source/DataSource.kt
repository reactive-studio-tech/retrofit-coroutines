package com.reactivestudio.retrofitcoroutines.data.source

import com.reactivestudio.retrofitcoroutines.data.model.GithubOrganization
import com.reactivestudio.retrofitcoroutines.util.Result

interface DataSource {

    suspend fun getOrganization(): Result<GithubOrganization>
}
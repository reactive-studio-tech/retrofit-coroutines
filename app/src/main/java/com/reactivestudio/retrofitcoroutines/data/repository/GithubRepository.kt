package com.reactivestudio.retrofitcoroutines.data.repository

import com.reactivestudio.retrofitcoroutines.data.model.GithubOrganization
import com.reactivestudio.retrofitcoroutines.data.model.GithubRepo
import com.reactivestudio.retrofitcoroutines.util.Result

interface GithubRepository {

    suspend fun getOrganization(): Result<GithubOrganization>

    suspend fun getOrganizationRepos(): Result<List<GithubRepo>>
}
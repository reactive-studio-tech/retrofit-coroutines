package com.reactivestudio.retrofitcoroutines.data.api

import com.reactivestudio.retrofitcoroutines.data.model.GithubOrganization
import com.reactivestudio.retrofitcoroutines.data.model.GithubRepo
import retrofit2.http.GET
import retrofit2.http.Headers

/**
 * Retrofit API service.
 */
interface GithubApi {

    @Headers("Accept: application/vnd.github.v3+json")
    @GET("/orgs/reactive-studio-tech")
    suspend fun getOrganization(): GithubOrganization

    @Headers("Accept: application/vnd.github.v3+json")
    @GET("/orgs/reactive-studio-tech/repos")
    suspend fun getOrganizationRepos(): List<GithubRepo>
}
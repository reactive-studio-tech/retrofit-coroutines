package com.reactivestudio.retrofitcoroutines.data.model

data class GithubOrganization(val id: Int,
                              val login: String,
                              val members_url: String,
                              val avatar_url: String,
                              val description: String,
                              val repos_url: String,
                              val url: String)
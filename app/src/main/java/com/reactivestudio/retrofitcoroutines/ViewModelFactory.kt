package com.reactivestudio.retrofitcoroutines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.reactivestudio.retrofitcoroutines.data.repository.GithubRepository
import com.reactivestudio.retrofitcoroutines.ui.organization.GithubOrganizationViewModel
import com.reactivestudio.retrofitcoroutines.ui.repositories.GithubRepositoresViewModel

class ViewModelFactory(private val repository: GithubRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>) =
        with(modelClass) {
            when {
                isAssignableFrom(GithubOrganizationViewModel::class.java) ->
                    GithubOrganizationViewModel(repository)
                isAssignableFrom(GithubRepositoresViewModel::class.java) ->
                    GithubRepositoresViewModel(repository)
                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
}
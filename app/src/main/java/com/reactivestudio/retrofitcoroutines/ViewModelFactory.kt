package com.reactivestudio.retrofitcoroutines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.reactivestudio.retrofitcoroutines.data.repository.SampleRepository
import com.reactivestudio.retrofitcoroutines.ui.organization.GithubOrganizationViewModel

class ViewModelFactory(private val repository: SampleRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>) =
        with(modelClass) {
            when {
                isAssignableFrom(GithubOrganizationViewModel::class.java) ->
                    GithubOrganizationViewModel(repository)
                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
}
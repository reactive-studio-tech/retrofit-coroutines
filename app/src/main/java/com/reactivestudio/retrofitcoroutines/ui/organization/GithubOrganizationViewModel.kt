package com.reactivestudio.retrofitcoroutines.ui.organization

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reactivestudio.retrofitcoroutines.data.model.GithubOrganization
import com.reactivestudio.retrofitcoroutines.data.repository.SampleRepository
import com.reactivestudio.retrofitcoroutines.util.Result
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber

class GithubOrganizationViewModel(private val repository: SampleRepository): ViewModel() {

    private val _loading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _loading

    private val _githubOrganization = MutableLiveData<GithubOrganization>()
    val githubOrganization: LiveData<GithubOrganization> = _githubOrganization

    fun loadOrganization() {
        viewModelScope.launch {
            _loading.value = true

            val organizationResult = repository.getOrganization()
            delay(1000)

            _loading.value = false

            if (organizationResult is Result.Success) {
                Timber.e(organizationResult.data.toString())
                _githubOrganization.value = organizationResult.data
            }
            else {
                _githubOrganization.value = null
            }

        }
    }
}
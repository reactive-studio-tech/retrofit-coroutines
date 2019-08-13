package com.reactivestudio.retrofitcoroutines.ui.organization

import androidx.lifecycle.*
import com.reactivestudio.retrofitcoroutines.data.model.GithubOrganization
import com.reactivestudio.retrofitcoroutines.data.repository.GithubRepository
import com.reactivestudio.retrofitcoroutines.util.Event
import com.reactivestudio.retrofitcoroutines.util.Result
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber

class GithubOrganizationViewModel(private val repository: GithubRepository): ViewModel() {

    private val _loading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _loading

    private val _githubOrganization = MutableLiveData<GithubOrganization>()
    val githubOrganization: MediatorLiveData<GithubOrganization> = MediatorLiveData()

    private val _openReposCommand = MutableLiveData<Event<Unit>>()
    val openReposCommand: LiveData<Event<Unit>> = _openReposCommand

    init {
        githubOrganization.value = null
        githubOrganization.addSource(_githubOrganization, githubOrganization::setValue)
        loadOrganization()
    }

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

    fun openRepos() {
        _openReposCommand.value = Event(Unit)
    }

}
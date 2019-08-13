package com.reactivestudio.retrofitcoroutines.ui.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reactivestudio.retrofitcoroutines.data.model.GithubRepo
import com.reactivestudio.retrofitcoroutines.data.repository.GithubRepository
import com.reactivestudio.retrofitcoroutines.util.Result
import kotlinx.coroutines.launch
import timber.log.Timber

class GithubRepositoresViewModel(private val repository: GithubRepository): ViewModel() {

    private val _loading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _loading

    private val _repos = MutableLiveData<List<GithubRepo>>().apply { value = emptyList() }
    val repos: LiveData<List<GithubRepo>> = _repos

    fun loadRepos() {
        viewModelScope.launch {
            _loading.value = true
            val repoResult = repository.getOrganizationRepos()
            _loading.value = false

            if (repoResult is Result.Success) {
                Timber.e(repoResult.data.toString())
                _repos.value = repoResult.data
            }
            else {
                _repos.value = emptyList()
            }
        }
    }
}
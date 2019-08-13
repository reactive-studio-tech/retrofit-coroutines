package com.reactivestudio.retrofitcoroutines.util

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.reactivestudio.retrofitcoroutines.App
import com.reactivestudio.retrofitcoroutines.ViewModelFactory

fun <T : ViewModel> Fragment.obtainViewModel(viewModelClass: Class<T>): T {
    val repository = (requireContext().applicationContext as App).repository
    return ViewModelProvider(this, ViewModelFactory(repository)).get(viewModelClass)
}
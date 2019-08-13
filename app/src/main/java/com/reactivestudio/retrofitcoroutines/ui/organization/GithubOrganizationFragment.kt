package com.reactivestudio.retrofitcoroutines.ui.organization

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.reactivestudio.retrofitcoroutines.R
import com.reactivestudio.retrofitcoroutines.databinding.FragmentGithubOrganizationBinding
import com.reactivestudio.retrofitcoroutines.databinding.FragmentGithubOrganizationBindingImpl
import com.reactivestudio.retrofitcoroutines.util.EventObserver
import com.reactivestudio.retrofitcoroutines.util.obtainViewModel

class GithubOrganizationFragment: Fragment() {

    private lateinit var viewDataBinding: FragmentGithubOrganizationBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = FragmentGithubOrganizationBinding.inflate(inflater, container, false)
        context ?: return viewDataBinding.root

        viewDataBinding.lifecycleOwner = viewLifecycleOwner
        viewDataBinding.viewmodel = obtainViewModel(GithubOrganizationViewModel::class.java)
        return viewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewDataBinding.viewmodel?.openReposCommand?.observe(this, EventObserver {
            val action = GithubOrganizationFragmentDirections.actionGithubOrganizationFragmentToGithubRepositoriesFragment()
            findNavController().navigate(action)
        })
    }
}
package com.reactivestudio.retrofitcoroutines.ui.organization

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.reactivestudio.retrofitcoroutines.R
import com.reactivestudio.retrofitcoroutines.databinding.FragmentGithubOrganizationBinding
import com.reactivestudio.retrofitcoroutines.databinding.FragmentGithubOrganizationBindingImpl
import com.reactivestudio.retrofitcoroutines.util.obtainViewModel

class GithubOrganizationFragment: Fragment() {

    private lateinit var viewDataBinding: FragmentGithubOrganizationBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_github_organization, container, false)
        viewDataBinding = FragmentGithubOrganizationBindingImpl.bind(view).apply {
            viewmodel = obtainViewModel(GithubOrganizationViewModel::class.java)
        }

        return viewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner
        viewDataBinding.viewmodel?.loadOrganization()
    }
}
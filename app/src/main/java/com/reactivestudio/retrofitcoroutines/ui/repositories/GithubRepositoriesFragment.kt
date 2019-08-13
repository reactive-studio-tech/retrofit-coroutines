package com.reactivestudio.retrofitcoroutines.ui.repositories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.reactivestudio.retrofitcoroutines.databinding.FragmentGithubReposBinding
import com.reactivestudio.retrofitcoroutines.util.obtainViewModel

class GithubRepositoriesFragment: Fragment() {

    private lateinit var viewDataBinding: FragmentGithubReposBinding
    private val adapter = GithubRepositoriesAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = FragmentGithubReposBinding.inflate(inflater, container, false)
        context ?: return viewDataBinding.root

        viewDataBinding.viewmodel = obtainViewModel(GithubRepositoresViewModel::class.java)
        viewDataBinding.lifecycleOwner = viewLifecycleOwner
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.repositoriesRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewDataBinding.repositoriesRecyclerView.adapter = adapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewDataBinding.viewmodel?.loadRepos()
    }

}
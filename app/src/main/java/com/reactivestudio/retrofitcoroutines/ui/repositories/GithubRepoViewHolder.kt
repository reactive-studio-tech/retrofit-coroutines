package com.reactivestudio.retrofitcoroutines.ui.repositories

import androidx.recyclerview.widget.RecyclerView
import com.reactivestudio.retrofitcoroutines.data.model.GithubRepo
import com.reactivestudio.retrofitcoroutines.databinding.ViewHolderGithubRepoBinding

class GithubRepoViewHolder(private val binding: ViewHolderGithubRepoBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(repo: GithubRepo) {
        binding.repo = repo
        binding.executePendingBindings()
    }
}
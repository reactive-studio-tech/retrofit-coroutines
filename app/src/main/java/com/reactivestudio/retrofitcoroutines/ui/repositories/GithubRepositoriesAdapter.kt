package com.reactivestudio.retrofitcoroutines.ui.repositories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.reactivestudio.retrofitcoroutines.data.model.GithubRepo
import com.reactivestudio.retrofitcoroutines.databinding.ViewHolderGithubRepoBinding
import com.reactivestudio.retrofitcoroutines.util.BindableAdapter

class GithubRepositoriesAdapter: RecyclerView.Adapter<GithubRepoViewHolder>(), BindableAdapter<List<GithubRepo>> {

    /**
     * Data source list.
     */
    private val dataSource = mutableListOf<GithubRepo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubRepoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ViewHolderGithubRepoBinding.inflate(inflater, parent, false)
        return GithubRepoViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataSource.size
    }

    override fun onBindViewHolder(holder: GithubRepoViewHolder, position: Int) {
        holder.bind(dataSource[position])
    }

    override fun setData(data: List<GithubRepo>) {
        dataSource.clear()
        dataSource.addAll(data)
        notifyDataSetChanged()
    }
}
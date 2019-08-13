package com.reactivestudio.retrofitcoroutines

import android.app.Application
import com.reactivestudio.retrofitcoroutines.data.api.GithubApi
import com.reactivestudio.retrofitcoroutines.data.repository.GithubRepository
import com.reactivestudio.retrofitcoroutines.data.repository.GithubRepositoryImpl
import com.reactivestudio.retrofitcoroutines.data.source.remote.RemoteDataSource
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber.DebugTree
import timber.log.Timber

class App: Application() {

    private val apiUrl = "https://api.github.com"

    lateinit var repository: GithubRepository

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }

        // Prepare everything for our repository. Note: we should do this with DI.
        val okHttp = OkHttpClient().newBuilder().build()
        val retrofit = Retrofit.Builder()
            .baseUrl(apiUrl)
            .client(okHttp)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create(GithubApi::class.java)
        val remoteDataSource = RemoteDataSource(api)

        repository = GithubRepositoryImpl(remoteDataSource)
    }


}
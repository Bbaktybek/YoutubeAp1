package com.example.youtubeap1.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtubeap1.BuildConfig.API_KEY
import com.example.youtubeap1.model.PlaylistItem
import com.example.youtubeap1.model.Playlists
import com.example.youtubeap1.remote.ApiService
import com.example.youtubeap1.remote.RetrofitClient
import com.example.youtubeap1.results.Resource
import com.example.youtubeap1.utils.channelId
import com.example.youtubeap1.utils.part
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    private val apiService: ApiService = RetrofitClient.create()

    fun playlists(): LiveData<Resource<Playlists>> {
        val data = MutableLiveData<Resource<Playlists>>()

        data.value = Resource.loading()

        apiService.getPlaylists(
            API_KEY,
            channelId,
            part,
            50
        )
            .enqueue(object : Callback<Playlists> {
                override fun onResponse(call: Call<Playlists>, response: Response<Playlists>) {
                    if (response.isSuccessful) {
                        data.value = Resource.success(response.body())
                    }
                }

                override fun onFailure(call: Call<Playlists>, t: Throwable) {
                    data.value = Resource.error(t.message, null, null)

                }
            })

        return data

    }


    fun playlistItems(id: String): LiveData<Resource<PlaylistItem>> {
        val data = MutableLiveData<Resource<PlaylistItem>>()

        data.value = Resource.loading()

        apiService.playlistItems(
            API_KEY,
            playlistId = id,
            part,
            50
        ).enqueue(object : Callback<PlaylistItem> {
            override fun onResponse(call: Call<PlaylistItem>, response: Response<PlaylistItem>) {
                if (response.isSuccessful) {
                    data.value = Resource.success(response.body())
                }

            }

            override fun onFailure(call: Call<PlaylistItem>, t: Throwable) {
                data.value = Resource.error(t.message, null, null)

            }
        })
        return data

    }
}






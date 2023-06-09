package com.example.youtubeap1.ui

import androidx.lifecycle.LiveData
import com.example.youtubeap1.base.BaseViewModel
import com.example.youtubeap1.model.Playlists
import com.example.youtubeap1.repository.Repository
import com.example.youtubeap1.results.Resource

class MainViewModel : BaseViewModel() {
    private val repository = Repository()

    fun playlists(): LiveData<Resource<Playlists>> {
        return repository.playlists()
    }
}
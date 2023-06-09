package com.example.youtubeap1

import android.app.Application
import com.example.youtubeap1.repository.Repository

class App: Application() {
    companion object{
        val repository = Repository()
    }
}
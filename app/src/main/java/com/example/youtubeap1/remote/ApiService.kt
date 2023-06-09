package com.example.youtubeap1.remote

import com.example.youtubeap1.model.PlaylistItem
import com.example.youtubeap1.model.Playlists
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("playlists")
    fun getPlaylists(
        @Query("key") apiKey: String,
        @Query("channelId") channelId: String,
        @Query("part") part: String,
        @Query("maxResults") maxResult: Int
    ): Call<Playlists>

    @GET("playlistItems")
    fun playlistItems(
        @Query("key") apiKey: String,
        @Query("playlistId") playlistId: String,
        @Query("part") part: String,
        @Query("maxResults") maxResult: Int
    ): Call<PlaylistItem>

}
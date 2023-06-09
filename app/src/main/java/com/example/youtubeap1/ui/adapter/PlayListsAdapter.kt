package com.example.youtubeap1.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeap1.databinding.ItemPlaylist1Binding
import com.example.youtubeap1.databinding.ItemPlaylistBinding
import com.example.youtubeap1.model.PlaylistItem
import com.example.youtubeap1.model.Playlists
import com.example.youtubeap1.utils.loadImage

class PlayListsAdapter() :
    RecyclerView.Adapter<PlayListsAdapter.PlayListsViewHolder>() {

    private var list = ArrayList<PlaylistItem.Item>()

    @SuppressLint("NotifyDataSetChanged")
    fun addList(list: List<PlaylistItem.Item?>?) {
        this.list = list as ArrayList<PlaylistItem.Item>
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayListsViewHolder {
        return PlayListsViewHolder(ItemPlaylist1Binding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: PlayListsViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }


    inner class PlayListsViewHolder(private val binding: ItemPlaylist1Binding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(item: PlaylistItem.Item) {
            with(binding) {
                tvPlaylistName.text = item.snippet?.title
                ivPlaylist.loadImage(item.snippet?.thumbnails?.default?.url!!)
            }

        }
    }
}

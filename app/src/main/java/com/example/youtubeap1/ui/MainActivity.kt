package com.example.youtubeap1.ui

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeap1.base.BaseActivity
import com.example.youtubeap1.databinding.ActivityMainBinding
import com.example.youtubeap1.model.Playlists
import com.example.youtubeap1.results.Status
import com.example.youtubeap1.ui.adapter.PlayListAdapter
import com.example.youtubeap1.utils.ConnectionLiveData

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    private lateinit var adapter: PlayListAdapter

    override val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun setUI() {
        super.setUI()
        adapter = PlayListAdapter(this::onClick)
        binding.recyclerView.adapter = adapter
    }

    override fun setupLiveData() {
        super.setupLiveData()
        viewModel.loading.observe(this) {
            binding.progressBar.isVisible = it
        }
        viewModel.playlists().observe(this) {
            when (it.status) {
                Status.SUCCESS -> {
                    binding.recyclerView.adapter = adapter
                    it.data?.let { it1 -> adapter.addList(it1.items as List<Playlists.Item>) }
                    binding.progressBar.isVisible = false
                }
                Status.ERROR -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                    binding.progressBar.isVisible = false
                }
                Status.LOADING -> {
                    binding.progressBar.isVisible = true
                }
            }
        }
    }

    override fun checkInternet() {
        super.checkInternet()
        ConnectionLiveData(application).observe(this) {
            if (it) {
                binding.internetConnection.visibility = View.VISIBLE
                binding.noConnection.visibility = View.GONE
            } else {
                binding.internetConnection.visibility = View.GONE
                binding.noConnection.visibility = View.VISIBLE
                setupLiveData()
            }
        }
    }

    override fun inflateViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }


    private fun onClick(item: Playlists.Item) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(KEY_FOR_ID, item.id)
        startActivity(intent)
    }


    companion object {
        const val ID = "ID"
        const val KEY_FOR_ID = "KEY_FOR_ID"
    }
}
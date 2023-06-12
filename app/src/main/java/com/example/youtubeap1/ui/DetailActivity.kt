package com.example.youtubeap1.ui

import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeap1.base.BaseActivity
import com.example.youtubeap1.databinding.ActivityDetailBinding
import com.example.youtubeap1.databinding.ActivityMainBinding
import com.example.youtubeap1.results.Status
import com.example.youtubeap1.ui.MainActivity.Companion.KEY_FOR_ID
import com.example.youtubeap1.ui.adapter.PlayListsAdapter
import com.example.youtubeap1.utils.ConnectionLiveData

class DetailActivity : BaseActivity<ActivityDetailBinding, DetailViewModel>() {

    private lateinit var adapter: PlayListsAdapter

    override val viewModel: DetailViewModel by lazy {
        ViewModelProvider(this)[DetailViewModel::class.java]
    }

    override fun setUI() {
        super.setUI()
        adapter = PlayListsAdapter()
        binding.recyclerView.adapter = adapter
    }

    override fun setupLiveData() {
        super.setupLiveData()
        var getIntent = intent.getStringExtra(KEY_FOR_ID)
            viewModel.loading.observe(this) {
                binding.progressBar.isVisible = it
        }
            viewModel.playlistsItems(getIntent!!).observe(this) {
                when (it.status) {
                    Status.SUCCESS -> {
                        binding.recyclerView.adapter = adapter
                        it.data?.let { it1 -> adapter.addList(it1.items) }
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
//                binding.noInternetConnectionInclude1.visibility = View.VISIBLE
                binding.noConnection.visibility = View.GONE
            } else {
//                binding.noInternetConnectionInclude1.visibility = View.GONE
                binding.noConnection.visibility = View.VISIBLE
                setupLiveData()
            }
        }
    }

    override fun inflateViewBinding(): ActivityDetailBinding {
        return ActivityDetailBinding.inflate(layoutInflater)
    }
}
package com.fireland.watchblogger.home

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.fireland.watchblogger.R
import com.fireland.watchblogger.databinding.ActivityMainBinding
import com.fireland.watchblogger.helpers.Status
import com.fireland.watchblogger.home.adapter.HomeListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val homeViewModel: ViewModel by viewModels()

    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        ).apply {
            lifecycleOwner = this@MainActivity
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val adapter = HomeListAdapter()
        binding.adapter = adapter
        homeViewModel.getLatestWatchNews().observe(this, { resource ->
            when (resource.status) {
                Status.LOADING -> Unit // TODO show loading
                Status.SUCCESS -> resource.data?.articles.let(adapter::submitList)
                Status.ERROR -> Unit  // TODO show error state
            }
        })
    }
}
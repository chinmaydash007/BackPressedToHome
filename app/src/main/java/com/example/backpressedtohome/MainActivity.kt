package com.example.backpressedtohome

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.backpressedtohome.adapters.MainAdapter
import com.example.backpressedtohome.databinding.MainActivityBinding

class MainActivity : AppCompatActivity(), OnBackPressedFeed
    , OnBackPressedMain
{
    lateinit var binding: MainActivityBinding
    lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        adapter = MainAdapter(this)
        binding.viewPager.adapter = adapter
        binding.viewPager.isUserInputEnabled = true
        binding.viewPager.setCurrentItem(1,false)


    }

    override fun onBackPressedEvent() {
        var currentSelectedPage = binding.viewPager.currentItem
        if (currentSelectedPage == 0) {
            binding.viewPager.setCurrentItem(1, true)
        }
    }

    override fun onBackPressedEventTwo() {
        var currentSelectedPage = binding.viewPager.currentItem
        if (currentSelectedPage == 1) {
            finish()
        }else{
            binding.viewPager.setCurrentItem(1, true)
        }
    }
}

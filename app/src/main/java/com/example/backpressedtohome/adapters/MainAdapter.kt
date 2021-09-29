package com.example.backpressedtohome.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.backpressedtohome.fragment.FeedFragment
import com.example.backpressedtohome.fragment.SecondFragment

class MainAdapter(var activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> {
                return FeedFragment()
            }
            1 -> {
                return SecondFragment()
            }

        }
        return SecondFragment()
    }


}
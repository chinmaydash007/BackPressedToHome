package com.example.backpressedtohome.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.backpressedtohome.fragment.FragmentA
import com.example.backpressedtohome.fragment.FragmentB
import com.example.backpressedtohome.fragment.FragmentC
import com.example.backpressedtohome.fragment.FragmentD

class SecondAdapter(var activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> {
                return FragmentA()
            }
            1 -> {
                return FragmentB()
            }
            2 -> {
                return FragmentC()
            }
            3 -> {
                return FragmentD()
            }
        }
        return FragmentA()
    }


}
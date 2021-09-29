package com.example.backpressedtohome.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.example.backpressedtohome.OnBackPressedMain
import com.example.backpressedtohome.R
import com.example.backpressedtohome.adapters.SecondAdapter
import com.example.backpressedtohome.databinding.SecondFragmentBinding
import android.content.res.ColorStateList
import android.graphics.Color


class SecondFragment : Fragment() {
    private val MENU_ITEM_ID_ONE: Int = 1
    private val MENU_ITEM_ID_TWO: Int = 2
    private val MENU_ITEM_ID_THREE: Int = 3
    private val MENU_ITEM_ID_FOUR: Int = 4
    var TAG = "mytag"

    lateinit var binding: SecondFragmentBinding
    lateinit var secondAdapter: SecondAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SecondFragmentBinding.inflate(inflater, container, false)
        secondAdapter = SecondAdapter(requireActivity())
        binding.viewPager.isUserInputEnabled = false
        binding.viewPager.adapter = secondAdapter

        val iconColorStates = ColorStateList(
            arrayOf(
                intArrayOf(-android.R.attr.state_checked),
                intArrayOf(android.R.attr.state_checked)
            ), intArrayOf(
                Color.parseColor("#A5A6BB"),
                Color.parseColor("#714FFF")
            )
        )

        binding.bottomNavigationView.setItemIconTintList(iconColorStates)
        binding.bottomNavigationView.setItemTextColor(iconColorStates)



        var menu = binding.bottomNavigationView.menu
        menu.add(Menu.NONE, MENU_ITEM_ID_ONE, Menu.NONE, "Home")
            .setIcon(R.drawable.ic_baseline_home_24)
        menu.add(Menu.NONE, MENU_ITEM_ID_TWO, Menu.NONE, "Favorite")
            .setIcon(R.drawable.ic_baseline_favorite_24)
        menu.add(Menu.NONE, MENU_ITEM_ID_THREE, Menu.NONE, "Settings")
            .setIcon(R.drawable.ic_baseline_settings_24)
        menu.add(Menu.NONE, MENU_ITEM_ID_FOUR, Menu.NONE, "Account")
            .setIcon(R.drawable.ic_baseline_account_circle_24)


        Log.d("mytag", "${binding.viewPager.childCount}")
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                1 -> {
                    binding.viewPager.setCurrentItem(0, true)
                }
                2 -> {
                    binding.viewPager.setCurrentItem(1, true)
                }
                3 -> {
                    binding.viewPager.setCurrentItem(2, true)
                }
                4 -> {
                    binding.viewPager.setCurrentItem(3, true)
                }
            }
            return@setOnItemSelectedListener true
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, backPressedCallback)
    }


    var backPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            val currentSelectedItem = binding.viewPager.currentItem
            if (currentSelectedItem == 0) {
                isEnabled = false
                (activity as OnBackPressedMain).onBackPressedEventTwo()
            } else {
                binding.viewPager.setCurrentItem(0, true)
                binding.bottomNavigationView.selectedItemId = 1
            }
        }
    }
}
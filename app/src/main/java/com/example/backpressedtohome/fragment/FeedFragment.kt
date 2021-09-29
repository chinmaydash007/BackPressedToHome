package com.example.backpressedtohome.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import com.example.backpressedtohome.OnBackPressedFeed
import com.example.backpressedtohome.R


class FeedFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_feed, container, false)
    }


    override fun onResume() {
        super.onResume()
        activity?.onBackPressedDispatcher?.addCallback(
            viewLifecycleOwner,
            backPressedCallback
        )
    }




    var backPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            (activity as OnBackPressedFeed).onBackPressedEvent()
        }
    }


}
package com.example.socially

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

class NotificationsFragment : Fragment(R.layout.fragment_notifications) {

    private lateinit var tabFollowing: TextView
    private lateinit var tabYou: TextView
    private lateinit var tabIndicator: View
    private lateinit var followingContent: LinearLayout
    private lateinit var youContent: LinearLayout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)
        setupTabClickListeners()
    }

    private fun initViews(view: View) {
        tabFollowing = view.findViewById(R.id.tab_following)
        tabYou = view.findViewById(R.id.tab_you)
        tabIndicator = view.findViewById(R.id.tab_indicator)
        followingContent = view.findViewById(R.id.following_content)
        youContent = view.findViewById(R.id.you_content)
    }

    private fun setupTabClickListeners() {
        tabFollowing.setOnClickListener {
            selectTab(true)
        }

        tabYou.setOnClickListener {
            selectTab(false)
        }
    }

    private fun selectTab(isFollowing: Boolean) {
        if (isFollowing) {
            // Following tab selected
            tabFollowing.setTextColor(ContextCompat.getColor(requireContext(), android.R.color.black))
            tabYou.setTextColor(ContextCompat.getColor(requireContext(), android.R.color.darker_gray))

            tabFollowing.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.white))
            tabYou.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.light_gray))

            followingContent.visibility = View.VISIBLE
            youContent.visibility = View.GONE

            // Move indicator to left
            val params = tabIndicator.layoutParams as LinearLayout.LayoutParams
            params.marginStart = 0
            params.marginEnd = resources.displayMetrics.widthPixels / 2
            tabIndicator.layoutParams = params

        } else {
            // You tab selected
            tabFollowing.setTextColor(ContextCompat.getColor(requireContext(), android.R.color.darker_gray))
            tabYou.setTextColor(ContextCompat.getColor(requireContext(), android.R.color.black))

            tabFollowing.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.light_gray))
            tabYou.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.white))

            followingContent.visibility = View.GONE
            youContent.visibility = View.VISIBLE

            // Move indicator to right
            val params = tabIndicator.layoutParams as LinearLayout.LayoutParams
            params.marginStart = resources.displayMetrics.widthPixels / 2
            params.marginEnd = 0
            tabIndicator.layoutParams = params
        }
    }
}

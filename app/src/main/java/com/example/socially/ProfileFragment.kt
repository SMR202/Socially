package com.example.socially

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

class ProfileFragment: Fragment(R.layout.fragment_profile) {

    private lateinit var tabPosts : ImageView
    private lateinit var tabTag : ImageView
    private lateinit var postsContent : LinearLayout
    private lateinit var tagContent : LinearLayout

    private lateinit var profileStory : ImageView
    private lateinit var profileHighlight : ImageView

    private lateinit var editProfile: TextView


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)
        setupTabClickListeners()
        setUpClickListeners()
    }

    private fun initViews(view: View) {
        tabPosts = view.findViewById(R.id.tab_posts)
        tabTag = view.findViewById(R.id.tab_tag)
        postsContent = view.findViewById(R.id.posts_grid)
        tagContent = view.findViewById(R.id.tagged_grid)

        profileStory = view.findViewById(R.id.profile_image)
        profileHighlight = view.findViewById(R.id.highlight1)

        editProfile = view.findViewById(R.id.edit_profile_button)
    }

    private fun setUpClickListeners() {
        profileStory.setOnClickListener {
            val intent = Intent(requireContext(), ViewStory::class.java)
            startActivity(intent)
        }

        profileHighlight.setOnClickListener {
            val intent = Intent(requireContext(), ViewHighlight::class.java)
            startActivity(intent)
        }
        editProfile.setOnClickListener {
            val intent = Intent(requireContext(), EditProfileScreen::class.java)
            startActivity(intent)
        }
    }

    private fun setupTabClickListeners() {
        tabPosts.setOnClickListener {
            selectTab(true)
        }

        tabTag.setOnClickListener {
            selectTab(false)
        }
    }

    private fun selectTab(isPosts: Boolean) {
        if (isPosts) {
            // Posts tab selected
            tabPosts.setColorFilter(ContextCompat.getColor(requireContext(), android.R.color.black))
            tabTag.setColorFilter(ContextCompat.getColor(requireContext(), android.R.color.darker_gray))

            postsContent.visibility = View.VISIBLE
            tagContent.visibility = View.GONE

        } else {
            // Tag tab selected
            tabTag.setColorFilter(ContextCompat.getColor(requireContext(), android.R.color.black))
            tabPosts.setColorFilter(ContextCompat.getColor(requireContext(), android.R.color.darker_gray))

            postsContent.visibility = View.GONE
            tagContent.visibility = View.VISIBLE
        }
    }
}

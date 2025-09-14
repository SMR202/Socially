package com.example.socially

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var myStory: ImageView
    private lateinit var userTwo: ImageView
    private lateinit var cameraButton: ImageView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        setupClickListeners()
    }

    private fun initViews(view: View) {
        myStory = view.findViewById(R.id.mystory)
        userTwo = view.findViewById(R.id.user2)
        cameraButton = view.findViewById(R.id.camerabtn)
    }

    private fun setupClickListeners() {
        myStory.setOnClickListener {
            val intent = Intent(requireContext(), ViewStory::class.java)
            startActivity(intent)
        }
        myStory.setOnLongClickListener {
            val intent = Intent(requireContext(), CreateStory::class.java)
            startActivity(intent)
            true
        }
        userTwo.setOnClickListener {
            val intent = Intent(requireContext(), ViewStoryOther::class.java)
            startActivity(intent)
        }
        cameraButton.setOnClickListener {
            //val intent = Intent(requireContext(), CameraActivity::class.java)
            //startActivity(intent)
        }
    }

}

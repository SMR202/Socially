package com.example.socially

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var myStory: ImageView
    private lateinit var userTwo: ImageView
    private lateinit var cameraButton: ImageView
    private lateinit var igDirectButton: ImageView
    private lateinit var likeButton: ImageView
    private lateinit var likeButton2: ImageView

    companion object {
        private const val REQUEST_IMAGE_CAPTURE = 1
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        setupClickListeners()
    }

    private fun initViews(view: View) {
        myStory = view.findViewById(R.id.mystory)
        userTwo = view.findViewById(R.id.user2)
        cameraButton = view.findViewById(R.id.camerabtn)
        igDirectButton = view.findViewById(R.id.igdirectbtn)
        likeButton = view.findViewById(R.id.like_button)
        likeButton2 = view.findViewById(R.id.like_button2)
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
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (cameraIntent.resolveActivity(requireActivity().packageManager) != null) {
                startActivityForResult(cameraIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
        igDirectButton.setOnClickListener {
            val intent = Intent(requireContext(), IGDirect::class.java)
            startActivity(intent)
        }
        likeButton.setOnClickListener {
            likeButton.isSelected = !likeButton.isSelected
        }
        likeButton2.setOnClickListener {
            likeButton2.isSelected = !likeButton2.isSelected
        }
    }

}

package com.example.socially

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EditProfileScreen : AppCompatActivity() {
    private lateinit var cancelButton: TextView
    private lateinit var doneButton: TextView
    private lateinit var changeProfilePic: TextView
    private lateinit var profilePicture: ImageView

    private val galleryLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val selectedImageUri: Uri? = result.data?.data
            selectedImageUri?.let { uri ->
                profilePicture.setImageURI(uri)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edit_profile_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initViews()
        setOnClickListeners()
    }

    private fun initViews() {
        cancelButton = findViewById(R.id.cancelButton)
        doneButton = findViewById(R.id.doneButton)
        changeProfilePic = findViewById(R.id.changePhotoText)
        profilePicture = findViewById(R.id.profilePicture)
    }

    private fun setOnClickListeners() {
        cancelButton.setOnClickListener {
            finish()
        }

        doneButton.setOnClickListener {
            finish()
        }

        changeProfilePic.setOnClickListener {
            openGallery()
        }
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.type = "image/*"
        galleryLauncher.launch(intent)
    }
}
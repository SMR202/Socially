package com.example.socially

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DMScreen : AppCompatActivity() {

    private lateinit var backButton: ImageView
    private lateinit var callButton: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dmscreen)

        initViews()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initViews(){
        backButton = findViewById(R.id.backbutton)
        callButton = findViewById(R.id.callButton)
        backButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
        callButton.setOnClickListener {
            val intent = android.content.Intent(this, CallScreen::class.java)
            startActivity(intent)
        }
    }
}
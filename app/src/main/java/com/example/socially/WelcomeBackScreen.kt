package com.example.socially

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WelcomeBackScreen : AppCompatActivity() {

    private lateinit var signupButton: TextView
    private lateinit var loginButton: TextView
    private lateinit var switchAccount: TextView

    override fun onStart() {
        super.onStart()
        initViews()
        setOnClickListeners()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome_back_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

     private fun initViews() {
        signupButton = findViewById(R.id.signup)
        loginButton = findViewById(R.id.loginbtn)
        switchAccount = findViewById(R.id.switchAccounts)
    }

    private fun setOnClickListeners() {
        signupButton.setOnClickListener {
            val intent = Intent(this, SignUpScreen::class.java)
            startActivity(intent)
            finish()
        }
        loginButton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
        switchAccount.setOnClickListener {
            val intent = Intent(this, LoginScreen::class.java)
            startActivity(intent)
            finish()
        }
    }
}
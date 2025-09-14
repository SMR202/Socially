package com.example.socially

import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class CreateFragment : Fragment(R.layout.fragment_create) {

    private lateinit var cancelButton: TextView

    private fun initViews(view: android.view.View) {
        cancelButton = view.findViewById(R.id.cancelbtn)

    }

    override fun onViewCreated(view: android.view.View, savedInstanceState: android.os.Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)

        cancelButton.setOnClickListener {
            (requireActivity() as HomeActivity).replaceFragment(HomeFragment())

            val bottomNav = requireActivity().findViewById<com.google.android.material.bottomnavigation.BottomNavigationView>(R.id.bottom_navigation)
            bottomNav.visibility = android.view.View.VISIBLE
            bottomNav.selectedItemId = R.id.home
        }
    }


}

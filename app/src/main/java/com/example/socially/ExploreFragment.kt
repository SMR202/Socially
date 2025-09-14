package com.example.socially

import android.content.Intent
import android.view.View
import android.widget.LinearLayout
import androidx.fragment.app.Fragment

class ExploreFragment: Fragment(R.layout.fragment_explore) {

    private lateinit var searchBar: LinearLayout

    private fun initViews(view: View) {
        searchBar = view.findViewById(R.id.search_bar)
    }

    override fun onStart() {
        super.onStart()
        searchBar = requireView().findViewById(R.id.search_bar)
        searchBar.setOnClickListener {
            val intent = Intent(requireContext(), SearchScreen::class.java)
            startActivity(intent)
        }
    }

}

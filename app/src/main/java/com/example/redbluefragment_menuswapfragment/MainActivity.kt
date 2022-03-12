package com.example.redbluefragment_menuswapfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var containerView: View
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        containerView = findViewById(R.id.fragment_container)
        bottomNavigationView = findViewById(R.id.bottomNavigationView)

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.show_red -> {
                    showFragment("RED")
                    true
                }
                R.id.show_blue -> {
                    showFragment("BLUE")
                    true
                }
                else -> {
                    false
                }
            }
        }

    }

    private fun showFragment(tag: String) {

        // is the fragment with this tag on the screen or not? Display when it is not
        if (supportFragmentManager.findFragmentByTag(tag) == null) {
            when (tag) {
                "RED" -> {
                    // display red
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, RedFragment.newInstance(), "RED").commit()
                }
                "BLUE" -> {
                    // display blue
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, BlueFragment.newInstance(), "BLUE").commit()
                }
            }
        }

    }
}
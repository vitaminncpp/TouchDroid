package com.akshayaap.touchdroid.ui.activities

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.akshayaap.touchdroid.R
import com.akshayaap.touchdroid.ui.fragments.Debug
import com.akshayaap.touchdroid.ui.fragments.Keyboard
import com.akshayaap.touchdroid.ui.fragments.Network
import com.akshayaap.touchdroid.ui.fragments.Settings
import com.akshayaap.touchdroid.ui.fragments.Touchpad
import com.google.android.material.bottomnavigation.BottomNavigationView

class MasterActivity : AppCompatActivity() {

    private lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_master)

        findViewById<View>(R.id.main)?.let { mainView ->
            ViewCompat.setOnApplyWindowInsetsListener(mainView) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }

        bottomNavigation = findViewById(R.id.bottomNavigation)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Network())
                .commit()
        }

        bottomNavigation.setOnItemSelectedListener { menuItem ->
            val fragment: Fragment = when (menuItem.itemId) {
                R.id.nav_network -> Network()
                R.id.nav_touchpad -> Touchpad()
                R.id.nav_keyboard -> Keyboard()
                R.id.nav_settings -> Settings()
                R.id.nav_debug -> Debug()
                else -> return@setOnItemSelectedListener false
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
            true
        }
    }
}

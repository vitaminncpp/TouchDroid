package com.akshayaap.touchdroid.ui.activities;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.akshayaap.touchdroid.R;
import com.akshayaap.touchdroid.ui.fragments.Debug;
import com.akshayaap.touchdroid.ui.fragments.Keyboard;
import com.akshayaap.touchdroid.ui.fragments.Network;
import com.akshayaap.touchdroid.ui.fragments.Settings;
import com.akshayaap.touchdroid.ui.fragments.Touchpad;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MasterActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigation;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_master);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        this.bottomNavigation = findViewById(R.id.bottomNavigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Network()).commit();
        this.bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                int itemId = menuItem.getItemId();
                switch (itemId) {
                    case R.id.nav_network:
                        fragmentTransaction.replace(R.id.fragment_container, new Network());
                        break;
                    case R.id.nav_touchpad:
                        fragmentTransaction.replace(R.id.fragment_container, new Touchpad());
                        break;
                    case R.id.nav_keyboard:
                        fragmentTransaction.replace(R.id.fragment_container, new Keyboard());
                        break;
                    case R.id.nav_settings:
                        fragmentTransaction.replace(R.id.fragment_container, new Settings());
                        break;
                    case R.id.nav_debug:
                        fragmentTransaction.replace(R.id.fragment_container, new Debug());
                        break;
                    default:
                        break;
                }
                fragmentTransaction.commit();
                return true;
            }
        });
    }
}
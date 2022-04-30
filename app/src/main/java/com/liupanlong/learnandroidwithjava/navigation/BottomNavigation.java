package com.liupanlong.learnandroidwithjava.navigation;

import static androidx.navigation.Navigation.findNavController;
import static androidx.navigation.ui.NavigationUI.setupActionBarWithNavController;
import static androidx.navigation.ui.NavigationUI.setupWithNavController;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.ui.AppBarConfiguration;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.liupanlong.learnandroidwithjava.R;

public class BottomNavigation extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
    }

    @Override
    protected void onStart() {
        super.onStart();
        /*AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.firstFragment, R.id.secondFragment, R.id.thirdFragment)
                .build();*/
        NavController navController = findNavController(this, R.id.nav_grap);
        // setupActionBarWithNavController(this, navController, appBarConfiguration);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        setupWithNavController(bottomNavigationView, navController);
    }
}
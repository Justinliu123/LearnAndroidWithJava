package com.liupanlong.learnandroidwithjava.navigation;


import static androidx.navigation.Navigation.findNavController;
import static androidx.navigation.ui.NavigationUI.setupActionBarWithNavController;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.widget.Button;

import com.liupanlong.learnandroidwithjava.R;

public class MainActivity extends AppCompatActivity {
    private NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

/*        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment_container);
        navController = navHostFragment.getNavController();

        setupActionBarWithNavController(navController);

        Button btnNavigat = findViewById(R.id.btnNavigat);
        btnNavigat.setOnClickListener(view -> {
            navController.popBackStack(R.id.firstFragment, true);
            navController.navigate(R.id.secondFragment);
        });*/
    }

    @Override
    protected void onStart() {
        super.onStart();
        navController = findNavController(findViewById(R.id.nav_host_fragment_container));

        setupActionBarWithNavController(this, navController);

        Button btnNavigat = findViewById(R.id.btnNavigat);
        btnNavigat.setOnClickListener(view -> {
            navController.popBackStack(R.id.secondFragment, true);
            navController.navigate(R.id.secondFragment);
        });

    }

    // 设置回退图标的功能
    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp();
    }
}
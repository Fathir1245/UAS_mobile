package com.example.utsmobile;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(this);

        // Check if a user is logged in
        if (!isUserLoggedIn()) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment;
            if (item.getItemId() == R.id.nav_recommendation) {
                selectedFragment = new RecommendationFragment();
            } else if (item.getItemId() == R.id.nav_story) {
                selectedFragment = new StoryFragment();
            } else if (item.getItemId() == R.id.nav_education) {
                selectedFragment = new EducationFragment();
            } else {
                selectedFragment = new RecommendationFragment();
            }
            replaceFragment(selectedFragment);
            return true;
        });

        replaceFragment(new RecommendationFragment()); // Default fragment
    }

    private boolean isUserLoggedIn() {
        // Check if user data exists in SQLite database
        return dbHelper.isUserLoggedIn();
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }
}

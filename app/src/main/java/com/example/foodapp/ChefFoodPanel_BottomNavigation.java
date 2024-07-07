package com.example.foodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.example.foodapp.chefFoodPanel.ChefHomeFragment;
import com.example.foodapp.chefFoodPanel.ChefOrderFragment;
import com.example.foodapp.chefFoodPanel.ChefPendingOrderFragment;
import com.example.foodapp.chefFoodPanel.ChefProfileFragment;

import java.util.HashMap;
import java.util.Map;

public class ChefFoodPanel_BottomNavigation extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private final Map<Integer, Fragment> fragmentMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_food_panel_bottom_navigation);

        BottomNavigationView navigationView = findViewById(R.id.chef_bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(this);

        fragmentMap.put(R.id.chefHome, new ChefHomeFragment());
        fragmentMap.put(R.id.PendingOrders, new ChefPendingOrderFragment());
        fragmentMap.put(R.id.Orders, new ChefOrderFragment());
        fragmentMap.put(R.id.chefProfile, new ChefProfileFragment());

        // Load the default fragment
        loadFragment(new ChefHomeFragment());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = fragmentMap.get(item.getItemId());
        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragment).commit();
            return true;
        }
        return false;
    }
}

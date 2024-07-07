package com.example.foodapp;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.example.foodapp.chefFoodPanel.ChefHomeFragment;
import com.example.foodapp.chefFoodPanel.ChefOrderFragment;
import com.example.foodapp.chefFoodPanel.ChefPendingOrderFragment;
import com.example.foodapp.chefFoodPanel.ChefProfileFragment;
import com.example.foodapp.customerFoodPanel.CustomerCartFragment;
import com.example.foodapp.customerFoodPanel.CustomerHomeFragment;
import com.example.foodapp.customerFoodPanel.CustomerOrdersFragment;
import com.example.foodapp.customerFoodPanel.CustomersProfileFragment;

import java.util.HashMap;
import java.util.Map;

public class CustomerFoofPanel_BottomNavigation extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private SparseArray<Fragment> fragmentMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_foof_panel_bottom_navigation);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);

        initializeFragmentMap();

        // Load the home fragment by default
        loadFragment(fragmentMap.get(R.id.cust_Home));
    }

    private void initializeFragmentMap() {
        fragmentMap = new SparseArray<>();
        fragmentMap.put(R.id.cust_Home, new CustomerHomeFragment());
        fragmentMap.put(R.id.cart, new CustomerCartFragment());
        fragmentMap.put(R.id.cust_profile, new CustomersProfileFragment());
        fragmentMap.put(R.id.Cust_order, new CustomerOrdersFragment());
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    private boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = fragmentMap.get(item.getItemId());
        return loadFragment(fragment);
    }
}

package com.northcoders.recordshop.ui.mainactivity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.google.android.material.navigation.NavigationBarView;
import com.northcoders.recordshop.R;
import com.northcoders.recordshop.databinding.ActivityMainBinding;

import com.northcoders.recordshop.ui.fragments.addeditalbum.AddEditAlbumFragment;
import com.northcoders.recordshop.ui.fragments.home.HomeFragment;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener{

    private ActivityMainBinding binding;
    private NavigationBarView bottomNavigation;
    private final HomeFragment homeFragment = new HomeFragment();
    private final AddEditAlbumFragment addEditAlbumFragment = new AddEditAlbumFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // activity_main Binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // Binding the bottom Navigation View
        bottomNavigation = binding.bottomNavigationView;
        bottomNavigation.setOnItemSelectedListener(this);
        bottomNavigation.setSelectedItemId(R.id.home);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.home){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_layout_fragment, homeFragment)
                    .commit();
            return true;
        }

        if (item.getItemId() == R.id.add){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_layout_fragment, addEditAlbumFragment)
                    .commit();
            return  true;
        }

        return false;
    }
}
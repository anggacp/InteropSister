package com.project.interopsister;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //tambah fragment
        HomeFragment homeFragment = new HomeFragment();
        FragmentManager fm = getSupportFragmentManager();

        //fragment ditambahkan ke mainActivity
        fm.beginTransaction().add(R.id.fragment_container,homeFragment).commit();
    }
}
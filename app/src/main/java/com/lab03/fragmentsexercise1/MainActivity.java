package com.lab03.fragmentsexercise1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnItemSelectedListener(navListener);

        // Mostrar el primer fragment cuando se inicie la aplicacion
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
    }

    // Reaccionar a los elementos del BottomNavigationView
    private NavigationBarView.OnItemSelectedListener navListener = new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
             switch (item.getItemId()) {
                 case R.id.nav_home:
                     selectedFragment = new HomeFragment();
                     break;

                 case R.id.nav_favorites:
                     selectedFragment = new FavoritesFragment();
                     break;
             }

             getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

             return true;
        }
    };
}
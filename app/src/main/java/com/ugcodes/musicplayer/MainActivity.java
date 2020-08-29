package com.ugcodes.musicplayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private TextView song_title, song_artist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        song_title = findViewById(R.id.song_title);
        song_artist = findViewById(R.id.song_artist);

        song_title.setSelected(true);
        song_artist.setSelected(true);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout,
                new FragmentHome()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.nav_home:
                    selectedFragment = new FragmentHome();
                    break;
                case R.id.nav_search:
                    selectedFragment = new FragmentSearch();
                    break;
                case R.id.nav_stream:
                    selectedFragment = new FragmentStream();
                    break;
                case R.id.nav_library:
                    selectedFragment = new FragmentLibrary();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout,
                    Objects.requireNonNull(selectedFragment)).commit();

            return true;
        }
    };
}
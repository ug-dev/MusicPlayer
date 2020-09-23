package com.ugcodes.musicplayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ugcodes.musicplayer.model.ViewPlaylist;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView song_title, song_artist;
    private ImageView pauseButton, playButton, likeButton, likedButton;
    private ProgressBar progressBar;
    private RelativeLayout miniPlayerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        song_title = findViewById(R.id.song_title);
        song_artist = findViewById(R.id.song_artist);

        playButton = findViewById(R.id.play_button);
        pauseButton = findViewById(R.id.pause_button);
        likeButton = findViewById(R.id.like_button);
        likedButton = findViewById(R.id.liked_button);
        
        miniPlayerLayout = findViewById(R.id.miniPlayer_layout);

        progressBar = findViewById(R.id.progressBar);
        progressBar.setProgress(30);

        playButton.setOnClickListener(this);
        pauseButton.setOnClickListener(this);
        likedButton.setOnClickListener(this);
        likeButton.setOnClickListener(this);

        song_title.setSelected(true);
        song_artist.setSelected(true);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        
        miniPlayerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PlayerScreen.class));
            }
        });

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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.play_button:
                toggleMiniPlayerButtons(playButton, pauseButton);
                break;
            case R.id.pause_button:
                toggleMiniPlayerButtons(pauseButton, playButton);
                break;
            case R.id.like_button:
                toggleMiniPlayerButtons(likeButton, likedButton);
                break;
            case R.id.liked_button:
                toggleMiniPlayerButtons(likedButton, likeButton);
                break;
        }
    }

    private void toggleMiniPlayerButtons(ImageView button1,
                                         ImageView button2) {
        button1.setVisibility(View.GONE);
        button2.setVisibility(View.VISIBLE);
    }
}
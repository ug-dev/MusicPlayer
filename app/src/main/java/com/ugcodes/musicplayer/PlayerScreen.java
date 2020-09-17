package com.ugcodes.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class PlayerScreen extends AppCompatActivity {
    private ImageView downPlayerScreen, menuPlayerScreen;
    private ImageView pauseButton, playButton, likeIcon, likedIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_screen);
        
        downPlayerScreen = findViewById(R.id.down_player_screen);
        menuPlayerScreen = findViewById(R.id.menu_player_screen);
        playButton = findViewById(R.id.pl_screen_play_button);
        pauseButton = findViewById(R.id.pl_screen_pause_button);
        likeIcon = findViewById(R.id.pl_screen_like_icon);
        likedIcon = findViewById(R.id.pl_screen_liked_icon);
        
        downPlayerScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PlayerScreen.this, "Down", Toast.LENGTH_SHORT).show();
            }
        });

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                togglePlayerButton(pauseButton, playButton);
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                togglePlayerButton(playButton, pauseButton);
            }
        });

        likeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                togglePlayerButton(likedIcon, likeIcon);
            }
        });

        likedIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                togglePlayerButton(likeIcon, likedIcon);
            }
        });
        
        menuPlayerScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PlayerScreen.this, "Menu", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void togglePlayerButton(ImageView image1, ImageView image2) {
        image1.setVisibility(View.VISIBLE);
        image2.setVisibility(View.GONE);
    }
}
package com.ugcodes.musicplayer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.palette.graphics.Palette;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowMetrics;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class PlayerScreen extends AppCompatActivity {
    private TextView songTitle, songArtist;
    private ImageView downPlayerScreen, menuPlayerScreen;
    private ImageView pauseButton, playButton, likeIcon, likedIcon;
    private ImageView songPoster;
    private CardView posterBackground;
    private ConstraintLayout layout;

    private Palette.Swatch darkVibrantSwatch;
    private Palette.Swatch mutedSwatch;

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
        songTitle = findViewById(R.id.pl_screen_song_title);
        songArtist = findViewById(R.id.pl_screen_song_artist);
        posterBackground = findViewById(R.id.pl_screen_song_poster_background);
        layout = findViewById(R.id.pl_screen_layout);
        songPoster = findViewById(R.id.pl_screen_song_poster);

        songTitle.setSelected(true);
        songArtist.setSelected(true);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int w = displayMetrics.widthPixels;

        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams)
                posterBackground.getLayoutParams();
        layoutParams.height = (w * 85) / 100;
        layoutParams.width = (w * 90) / 100;
        posterBackground.setLayoutParams(layoutParams);

        //Setting Gradient Background
        Bitmap bitmap = ((BitmapDrawable) songPoster.getDrawable()).getBitmap();

        Palette.from(bitmap).maximumColorCount(128).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@Nullable Palette palette) {
                if (palette != null) {
                    darkVibrantSwatch = palette.getDarkVibrantSwatch();
                    mutedSwatch = palette.getMutedSwatch();
                }
                generateBackgroundGradient();
            }
        });
        
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

    private void generateBackgroundGradient() {
        GradientDrawable drawable;

        if (mutedSwatch != null) {
            drawable = new GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM,
                    new int[] {mutedSwatch.getRgb(), 0xFF111111});

            layout.setBackground(drawable);
        } else if (darkVibrantSwatch != null) {
            drawable = new GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM,
                    new int[] {darkVibrantSwatch.getRgb(), 0xFF111111});

            layout.setBackground(drawable);
        } else {
            layout.setBackgroundColor(getResources().getColor(R.color.background1));
        }
    }

    private void togglePlayerButton(ImageView image1, ImageView image2) {
        image1.setVisibility(View.VISIBLE);
        image2.setVisibility(View.GONE);
    }
}
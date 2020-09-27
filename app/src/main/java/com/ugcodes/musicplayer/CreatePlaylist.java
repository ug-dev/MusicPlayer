package com.ugcodes.musicplayer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Objects;

public class CreatePlaylist extends AppCompatActivity {
    private int width;
    private CardView imageBackground;
    private ImageView createIcon, createImage;
    private EditText name;
    private Button cancelButton, createButton;

    private static final int PICK_IMAGE_REQUEST = 1;
    private Uri mImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_playlist);

        width = Resources.getSystem().getDisplayMetrics().widthPixels;

        imageBackground = findViewById(R.id.create_playlist_background);
        createIcon = findViewById(R.id.create_playlist_icon);
        createImage = findViewById(R.id.create_playlist_image);
        name = findViewById(R.id.create_playlist_name);
        cancelButton = findViewById(R.id.create_playlist_cancel_button);
        createButton = findViewById(R.id.create_playlist_create_button);

        setImageBackgroundWidth();

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        imageBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard(name);
                openFileChooser();
            }
        });
    }

    private void setImageBackgroundWidth() {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams)
                imageBackground.getLayoutParams();
        layoutParams.height = (width * 60) / 100;
        layoutParams.width = (width * 60) / 100;
        imageBackground.setLayoutParams(layoutParams);
    }

    private void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    private void hideSoftKeyboard(View v) {
        InputMethodManager imm = (InputMethodManager)
                Objects.requireNonNull(getSystemService(Context.INPUT_METHOD_SERVICE));
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null) {
            mImageUri = data.getData();
            createImage.setImageURI(mImageUri);
            createIcon.setVisibility(View.GONE);
            createImage.setVisibility(View.VISIBLE);
        }
    }
}
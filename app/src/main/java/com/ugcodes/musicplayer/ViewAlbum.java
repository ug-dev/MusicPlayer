package com.ugcodes.musicplayer;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.ugcodes.musicplayer.adapter.PlaylistItemAdapter;
import com.ugcodes.musicplayer.model.PlaylistItem;

import java.util.ArrayList;

public class ViewAlbum extends Fragment {
    private LinearLayout topSection;
    private ImageView playlistImage, backButton;
    private TextView playlistTitle;
    private TextView playlistTitleText, playlistSubtitleText;
    private Button playButton, shuffleButton;

    private Palette.Swatch vibrantSwatch;
    private Palette.Swatch lightVibrantSwatch;
    private Palette.Swatch darkVibrantSwatch;
    private Palette.Swatch mutedSwatch;
    private Palette.Swatch lightMutedSwatch;
    private Palette.Swatch darkMutedSwatch;
    int currentNumber;

    private ScrollView parentScroll;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RelativeLayout topBar, topSectionBackground;
    private ImageView topSectionBackgroundImage;
    private ConstraintLayout buttonSection;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_album, container, false);

        final int height = Resources.getSystem().getDisplayMetrics().heightPixels;
        int width = Resources.getSystem().getDisplayMetrics().widthPixels;

        topSection = view.findViewById(R.id.view_album_top_section);
        playlistImage = view.findViewById(R.id.view_album_playlistImage);
        parentScroll = view.findViewById(R.id.view_album_parent_scroll);
        topBar = view.findViewById(R.id.view_album_top_bar);
        topSectionBackground = view.findViewById(R.id.view_album_top_section_background);
        playlistTitle = view.findViewById(R.id.view_album_title);
        playButton = view.findViewById(R.id.view_album_play_button);
        shuffleButton = view.findViewById(R.id.view_album_shuffle_button);
        buttonSection = view.findViewById(R.id.view_album_button_section);
        playlistTitleText = view.findViewById(R.id.view_album_title_text);
        playlistSubtitleText = view.findViewById(R.id.view_album_subtitle_text);
        backButton = view.findViewById(R.id.view_album_back_button);
        recyclerView = view.findViewById(R.id.view_album_child_scroll);

        ArrayList<PlaylistItem> items = new ArrayList<>();
        items.add(new PlaylistItem(R.drawable.ic_playlist_icon, "Dance Monkey",
                "Tones And I", true));
        items.add(new PlaylistItem(R.drawable.ic_playlist_icon, "One Dance",
                "Drake", true));

        recyclerView.setHasFixedSize(true);
        adapter = new PlaylistItemAdapter(items);
        recyclerView.setNestedScrollingEnabled(false);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);

        ScrollView.LayoutParams layoutParams = (ScrollView.LayoutParams)
                topSectionBackground.getLayoutParams();
        layoutParams.height = (height * 50) / 100;
        topSectionBackground.setLayoutParams(layoutParams);

        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams)
                playlistImage.getLayoutParams();
        layoutParams2.height = (width * 50) / 100;
        layoutParams2.width = (width * 50) / 100;
        playlistImage.setLayoutParams(layoutParams2);

        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams)
                recyclerView.getLayoutParams();
        layoutParams3.height = height - generatePixels(212);
        recyclerView.setLayoutParams(layoutParams3);

        //Setting Gradient Background
        Bitmap bitmap = ((BitmapDrawable) playlistImage.getDrawable()).getBitmap();

        Palette.from(bitmap).maximumColorCount(128).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@Nullable Palette palette) {
                if (palette != null) {
                    vibrantSwatch = palette.getVibrantSwatch();
                    lightVibrantSwatch = palette.getLightVibrantSwatch();
                    darkVibrantSwatch = palette.getDarkVibrantSwatch();
                    mutedSwatch = palette.getMutedSwatch();
                    lightMutedSwatch = palette.getLightMutedSwatch();
                    darkMutedSwatch = palette.getDarkMutedSwatch();
                }
                generateBackgroundGradient();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragment_layout,
                                new FragmentHome()).commit();
            }
        });

        return view;
    }

    private int generatePixels(float dip) {
        Resources r = getResources();
        float px = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dip,
                r.getDisplayMetrics()
        );

        return (int) px;
    }

    private void generateBackgroundGradient() {
        GradientDrawable drawable;

        if (mutedSwatch != null) {
            drawable = new GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM,
                    new int[] {mutedSwatch.getRgb(), 0xFF010101});

            topSection.setBackground(drawable);
        } else if (darkVibrantSwatch != null) {
            drawable = new GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM,
                    new int[] {darkVibrantSwatch.getRgb(), 0xFF010101});

            topSection.setBackground(drawable);
        } else {
            topSection.setBackgroundColor(getResources().getColor(R.color.background1));
        }
    }
}
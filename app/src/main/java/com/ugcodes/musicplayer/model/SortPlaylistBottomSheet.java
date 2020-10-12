package com.ugcodes.musicplayer.model;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.ugcodes.musicplayer.R;

public class SortPlaylistBottomSheet extends BottomSheetDialogFragment {
    private RelativeLayout sortTitleLayout, sortRecentLayout,
            sortArtistLayout, sortAlbumLayout;
    private ImageView titleTick, recentTick, artistTick, albumTick;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sort_playlist_bottom_sheet, container, false);

        sortTitleLayout = view.findViewById(R.id.playlist_sort_title);
        sortRecentLayout = view.findViewById(R.id.playlist_sort_recently_added);
        sortArtistLayout = view.findViewById(R.id.playlist_sort_artist);
        sortAlbumLayout = view.findViewById(R.id.playlist_sort_album);
        titleTick = view.findViewById(R.id.playlist_sort_title_tick);
        recentTick = view.findViewById(R.id.playlist_sort_recently_added_tick);
        artistTick = view.findViewById(R.id.playlist_sort_artist_tick);
        albumTick = view.findViewById(R.id.playlist_sort_album_tick);

        sortTitleLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                defaultTick();
                setTick(titleTick);
            }
        });

        sortRecentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                defaultTick();
                setTick(recentTick);
            }
        });

        sortArtistLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                defaultTick();
                setTick(artistTick);
            }
        });

        sortAlbumLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                defaultTick();
                setTick(albumTick);
            }
        });

        return view;
    }

    private void setTick(ImageView tick) {
        tick.setVisibility(View.VISIBLE);
    }

    private void defaultTick() {
        titleTick.setVisibility(View.GONE);
        recentTick.setVisibility(View.GONE);
        artistTick.setVisibility(View.GONE);
        albumTick.setVisibility(View.GONE);
    }
}

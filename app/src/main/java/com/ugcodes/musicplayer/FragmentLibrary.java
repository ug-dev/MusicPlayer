package com.ugcodes.musicplayer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.Objects;

public class FragmentLibrary extends Fragment implements View.OnClickListener {
    private RelativeLayout layout_1, layout_2, layout_3, layout_4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_library, container, false);

        layout_1 = view.findViewById(R.id.playlist_layout);
        layout_2 = view.findViewById(R.id.album_layout);
        layout_3 = view.findViewById(R.id.song_layout);
        layout_4 = view.findViewById(R.id.artist_layout);

        layout_1.setOnClickListener(this);
        layout_2.setOnClickListener(this);
        layout_3.setOnClickListener(this);
        layout_4.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.playlist_layout:
                Objects.requireNonNull(getFragmentManager())
                        .beginTransaction().replace(R.id.fragment_layout,
                        new playlists_layout()).commit();
                break;
            case R.id.album_layout:
                Objects.requireNonNull(getFragmentManager())
                        .beginTransaction().replace(R.id.fragment_layout,
                        new albums_layout()).commit();
                break;
            case R.id.song_layout:
                Objects.requireNonNull(getFragmentManager())
                        .beginTransaction().replace(R.id.fragment_layout,
                        new songs_layout()).commit();
                break;
            case R.id.artist_layout:
                Objects.requireNonNull(getFragmentManager())
                        .beginTransaction().replace(R.id.fragment_layout,
                        new artists_layout()).commit();
                break;
        }
    }
}
package com.ugcodes.musicplayer;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.ugcodes.musicplayer.adapter.ItemsListAdapter_1;
import com.ugcodes.musicplayer.model.ItemsPlaylist;
import com.ugcodes.musicplayer.model.PlaylistBottomSheet;

import java.util.ArrayList;
import java.util.Objects;

public class playlists_layout extends Fragment {
    private RecyclerView mRecyclerView;
    private ItemsListAdapter_1 mAdapter;
    private ImageView BackButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_playlists_layout, container, false);

        ArrayList<ItemsPlaylist> items = new ArrayList<>();
        items.add(new ItemsPlaylist(R.drawable.ic_create_playlist_icon_mini,
                "Create playlist", "0"));
        items.add(new ItemsPlaylist(R.drawable.ic_playlist_icon, "UG's Tracks", "84 Songs"));
        items.add(new ItemsPlaylist(R.drawable.ic_playlist_icon, "UG's Tracks", "84 Songs"));
        items.add(new ItemsPlaylist(R.drawable.ic_playlist_icon, "UG's Tracks", "84 Songs"));
        items.add(new ItemsPlaylist(R.drawable.ic_playlist_icon, "UG's Tracks", "84 Songs"));
        items.add(new ItemsPlaylist(R.drawable.ic_playlist_icon, "UG's Tracks", "84 Songs"));
        items.add(new ItemsPlaylist(R.drawable.ic_playlist_icon, "UG's Tracks", "84 Songs"));
        items.add(new ItemsPlaylist(R.drawable.ic_playlist_icon, "UG's Tracks", "84 Songs"));
        items.add(new ItemsPlaylist(R.drawable.ic_playlist_icon, "UG's Tracks", "84 Songs"));
        items.add(new ItemsPlaylist(R.drawable.ic_playlist_icon, "UG's Tracks", "84 Songs"));

        mRecyclerView = view.findViewById(R.id.items_list_1_recyclerView);
        BackButton = view.findViewById(R.id.playlist_layout_back_button);

        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Objects.requireNonNull(getFragmentManager())
                        .beginTransaction().replace(R.id.fragment_layout,
                        new FragmentLibrary()).commit();
            }
        });

        mRecyclerView.setHasFixedSize(true);
        mAdapter = new ItemsListAdapter_1(items);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnArtistClickListener(new ItemsListAdapter_1.OnArtistClickListener() {
            @Override
            public void onArtistClick(int position) {
                if (position == 0) {
                    startActivity(new Intent(getActivity(), CreatePlaylist.class));
                }
            }
        });

        return view;
    }
}
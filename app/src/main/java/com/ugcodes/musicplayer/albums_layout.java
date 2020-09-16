package com.ugcodes.musicplayer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ugcodes.musicplayer.adapter.ItemsListAdapter_1;
import com.ugcodes.musicplayer.model.ItemsPlaylist;

import java.util.ArrayList;
import java.util.Objects;

public class albums_layout extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private ImageView BackButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_albums_layout, container, false);

        ArrayList<ItemsPlaylist> items = new ArrayList<>();
        items.add(new ItemsPlaylist(R.drawable.ic_playlist_icon, "Aashiqui 2", "Arijit Singh"));
        items.add(new ItemsPlaylist(R.drawable.ic_playlist_icon, "Aashiqui 2", "Arijit Singh"));
        items.add(new ItemsPlaylist(R.drawable.ic_playlist_icon, "Aashiqui 2", "Arijit Singh"));
        items.add(new ItemsPlaylist(R.drawable.ic_playlist_icon, "Aashiqui 2", "Arijit Singh"));
        items.add(new ItemsPlaylist(R.drawable.ic_playlist_icon, "Aashiqui 2", "Arijit Singh"));
        items.add(new ItemsPlaylist(R.drawable.ic_playlist_icon, "Aashiqui 2", "Arijit Singh"));
        items.add(new ItemsPlaylist(R.drawable.ic_playlist_icon, "Aashiqui 2", "Arijit Singh"));
        items.add(new ItemsPlaylist(R.drawable.ic_playlist_icon, "Aashiqui 2", "Arijit Singh"));
        items.add(new ItemsPlaylist(R.drawable.ic_playlist_icon, "Aashiqui 2", "Arijit Singh"));

        mRecyclerView = view.findViewById(R.id.items_list_1_recyclerView_album);
        BackButton = view.findViewById(R.id.album_layout_back_button);

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

        return view;
    }
}
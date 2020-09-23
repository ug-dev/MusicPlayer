package com.ugcodes.musicplayer.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ugcodes.musicplayer.R;
import com.ugcodes.musicplayer.model.PlaylistItem;

import java.util.ArrayList;

public class PlaylistItemAdapter extends RecyclerView.Adapter<PlaylistItemAdapter.PlaylistItemViewHolder> {
    private ArrayList<PlaylistItem> mItems;

    public PlaylistItemAdapter(ArrayList<PlaylistItem> items) {
        mItems = items;
    }

    @NonNull
    @Override
    public PlaylistItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.playlist_items_card, parent,
                false);
        return new PlaylistItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaylistItemViewHolder holder, int position) {
        PlaylistItem currentItem = mItems.get(position);

        holder.imageView.setImageResource(currentItem.getImageResource());
        holder.text1.setText(currentItem.getTitle());
        holder.text2.setText(currentItem.getArtistTitle());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public static class PlaylistItemViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView text1, text2;

        public PlaylistItemViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.playlist_item_song_image);
            text1 = itemView.findViewById(R.id.playlist_item_song_title);
            text2 = itemView.findViewById(R.id.playlist_item_song_artist);

        }
    }
}
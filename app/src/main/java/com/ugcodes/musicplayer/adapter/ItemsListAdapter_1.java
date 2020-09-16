package com.ugcodes.musicplayer.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ugcodes.musicplayer.R;
import com.ugcodes.musicplayer.model.ItemsPlaylist;

import java.util.ArrayList;

public class ItemsListAdapter_1 extends RecyclerView.Adapter<ItemsListAdapter_1
        .ItemsListAdapter_1ViewHolder> {

    ArrayList<ItemsPlaylist> mList;

    public static class ItemsListAdapter_1ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView mTextView1;
        public TextView mTextView2;

        public ItemsListAdapter_1ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.items_list_1_image);
            mTextView1 = itemView.findViewById(R.id.items_list_1_title);
            mTextView2 = itemView.findViewById(R.id.items_list_1_subtitle);
        }
    }

    public ItemsListAdapter_1(ArrayList<ItemsPlaylist> list) {
        mList = list;
    }

    @NonNull
    @Override
    public ItemsListAdapter_1ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_list_1,
                parent, false);

        return new ItemsListAdapter_1ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsListAdapter_1ViewHolder holder, int position) {
        ItemsPlaylist currentList = mList.get(position);

        holder.imageView.setImageResource(currentList.getImageResource());
        holder.mTextView1.setText(currentList.getTitle());
        holder.mTextView2.setText(currentList.getSubtitle());

        if (currentList.getSubtitle().equals("0")) {
            holder.mTextView2.setVisibility(View.GONE);
        } else {
            holder.mTextView2.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}

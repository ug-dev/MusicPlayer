package com.ugcodes.musicplayer.model;

public class ItemsPlaylist {
    private int mImageResource;
    private String title;
    private String subtitle;

    public ItemsPlaylist(int mImageResource, String title, String subtitle) {
        this.mImageResource = mImageResource;
        this.title = title;
        this.subtitle = subtitle;
    }

    public int getImageResource() {
        return mImageResource;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }
}

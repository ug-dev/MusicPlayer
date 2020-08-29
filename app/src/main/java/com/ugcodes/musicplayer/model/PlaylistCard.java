package com.ugcodes.musicplayer.model;

public class PlaylistCard {
    private int ImageResource;
    private String Title;
    private String Subtitle;

    public PlaylistCard(int mImageResource, String mTitle, String mSubtitle) {
        this.ImageResource = mImageResource;
        this.Title = mTitle;
        this.Subtitle = mSubtitle;
    }

    public int getImageResource() {
        return ImageResource;
    }

    public String getTitle() {
        return Title;
    }

    public String getSubtitle() {
        return Subtitle;
    }
}

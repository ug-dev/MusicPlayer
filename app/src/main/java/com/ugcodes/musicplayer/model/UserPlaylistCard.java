package com.ugcodes.musicplayer.model;

public class UserPlaylistCard {
    private int ImageResource;
    private String Title;
    private String Subtitle;

    public UserPlaylistCard(int imageResource, String title, String subtitle) {
        ImageResource = imageResource;
        Title = title;
        Subtitle = subtitle;
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

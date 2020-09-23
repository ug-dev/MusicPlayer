package com.ugcodes.musicplayer.model;

public class PlaylistItem {
    private int ImageResource;
    private String Title;
    private String ArtistTitle;
    private boolean IsLiked;

    public PlaylistItem(int imageResource, String title, String artistTitle, boolean isLiked) {
        ImageResource = imageResource;
        Title = title;
        ArtistTitle = artistTitle;
        IsLiked = isLiked;
    }

    public int getImageResource() {
        return ImageResource;
    }

    public String getTitle() {
        return Title;
    }

    public String getArtistTitle() {
        return ArtistTitle;
    }

    public boolean isLiked() {
        return IsLiked;
    }
}

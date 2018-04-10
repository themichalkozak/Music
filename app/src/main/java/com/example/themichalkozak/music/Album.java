package com.example.themichalkozak.music;

import android.graphics.drawable.Drawable;

/**
 * Created by themichalkozak on 10/04/2018.
 */


public class Album {

    private String mArtistName;
    private String mAlbumName;
    private Drawable mDrawable;

    public Album(String mArtistName, String mAlbumName, Drawable mDrawable) {
        this.mArtistName = mArtistName;
        this.mAlbumName = mAlbumName;
        this.mDrawable = mDrawable;
    }

    public String getmArtistName() {
        return mArtistName;
    }

    public String getmAlbumName() {
        return mAlbumName;
    }

    public Drawable getmDrawable() {
        return mDrawable;
    }
}

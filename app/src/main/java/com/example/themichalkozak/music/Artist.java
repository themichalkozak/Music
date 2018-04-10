package com.example.themichalkozak.music;

import android.graphics.drawable.Drawable;

/**
 * Created by themichalkozak on 10/04/2018.
 */
public class Artist {

    private String mName;
    private Drawable drawable;

    public Artist(String mName, Drawable drawable) {
        this.mName = mName;
        this.drawable = drawable;
    }

    public String getmName() {
        return mName;
    }

    public Drawable getDrawable() {
        return drawable;
    }
}

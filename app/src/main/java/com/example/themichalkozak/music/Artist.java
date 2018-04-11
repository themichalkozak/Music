package com.example.themichalkozak.music;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by themichalkozak on 10/04/2018.
 */
public class Artist implements Parcelable {

    private String mName;
    private Drawable drawable;
    private ArrayList<Album> albums = new ArrayList<Album>();

    public Artist(String mName, Drawable drawable) {
        this.mName = mName;
        this.drawable = drawable;
        this.albums = new ArrayList<Album>();
    }

    public Album addAlbum(String album, Drawable drawable){
       return new Album(mName,album,drawable);
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public String getmName() {
        return mName;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public Artist(Parcel in){
        this.mName = in.readString();
        Bitmap bitmap = (Bitmap)in.readParcelable(getClass().getClassLoader());
        drawable = new BitmapDrawable(bitmap);

        in.readTypedList(this.albums,Album.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        dest.writeParcelable(bitmap,flags);

        dest.writeTypedList(this.albums);
    }

    public static final Parcelable.Creator<Artist> CREATOR =
            new Parcelable.Creator<Artist>(){
                @Override
                public Artist createFromParcel(Parcel source) {
                    return new Artist(source);
                }

                @Override
                public Artist[] newArray(int size) {
                    return new Artist[size];
                }
            };
}

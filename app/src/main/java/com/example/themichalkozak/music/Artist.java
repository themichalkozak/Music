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

    public final boolean addAlbum(String albumName, Drawable drawable) {
        if(findAlbum(albumName) == null){
            this.albums.add(new Album(mName,albumName,drawable,new ArrayList<Track>()));
            return true;
        }
        return false;
    }

    public Album findAlbum(String findItem) {
        for (Album checkedAlbum : this.albums) {
            if (checkedAlbum.getmAlbumName().equals(findItem)) {
                return checkedAlbum;
            }
        }
        return null;
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

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        dest.writeParcelable(bitmap, flags);
        dest.writeString(mName);

        dest.writeTypedList(this.albums);
    }

    public Artist(Parcel in) {
        Bitmap bitmap = (Bitmap) in.readParcelable(getClass().getClassLoader());
        drawable = new BitmapDrawable(bitmap);
        this.mName = in.readString();


        in.readTypedList(this.albums, Album.CREATOR);
    }


    public static final Parcelable.Creator<Artist> CREATOR =
            new Parcelable.Creator<Artist>() {
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

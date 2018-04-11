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


public class Album implements Parcelable{

    private String mArtistName;
    private String mAlbumName;
    private Drawable drawable;
    private ArrayList<Track> tracks;

    public Album(String mArtistName, String mAlbumName, Drawable drawable) {
        this.mArtistName = mArtistName;
        this.mAlbumName = mAlbumName;
        this.drawable = drawable;
        this.tracks = new ArrayList<Track>();
    }

    public String getmArtistName() {
        return mArtistName;
    }

    public String getmAlbumName() {
        return mAlbumName;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    @Override
    public int describeContents() {
        return 0;
    }


    private Album(Parcel in){
        this.mAlbumName = in.readString();
        this.mArtistName = in.readString();
        Bitmap bitmap = in.readParcelable(getClass().getClassLoader());
        this.drawable = new BitmapDrawable(bitmap);

        in.readTypedList(this.tracks,Track.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mAlbumName);
        dest.writeString(mArtistName);
        dest.writeList(tracks);
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();

        dest.writeParcelable(bitmap,flags);
    }

    public static final Parcelable.Creator<Album> CREATOR =
            new Parcelable.Creator<Album>(){
                @Override
                public Album createFromParcel(Parcel source) {

                    return new Album(source);
                }

                @Override
                public Album[] newArray(int size) {
                    return new Album[size];
                }
            };
}

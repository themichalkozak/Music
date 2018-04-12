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
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public Album(String mArtistName, String mAlbumName, Drawable drawable, ArrayList<Track> tracks) {
        this.mArtistName = mArtistName;
        this.mAlbumName = mAlbumName;
        this.drawable = drawable;
        this.tracks = tracks;
    }

    public void addTrack(){
        this.tracks.add(new Track("default","default",drawable));
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

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        dest.writeParcelable(bitmap,flags);
        dest.writeString(mAlbumName);
        dest.writeString(mArtistName);
        dest.writeTypedList(this.tracks);



    }

    private Album(Parcel in){
        Bitmap bitmap = in.readParcelable(getClass().getClassLoader());
        drawable = new BitmapDrawable(bitmap);
        this.mAlbumName = in.readString();
        this.mArtistName = in.readString();

        in.readTypedList(this.tracks,Track.CREATOR);
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

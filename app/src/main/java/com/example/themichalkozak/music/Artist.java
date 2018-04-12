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

    public Artist(String mName, Drawable drawable, ArrayList<Album> albums) {
        this.mName = mName;
        this.drawable = drawable;
        this.albums = albums;
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
        dest.writeParcelable(bitmap,flags);
        dest.writeString(mName);

        dest.writeTypedList(this.albums);
    }
    public Artist(Parcel in){
        Bitmap bitmap = (Bitmap)in.readParcelable(getClass().getClassLoader());
        drawable = new BitmapDrawable(bitmap);
        this.mName = in.readString();


        in.readTypedList(this.albums,Album.CREATOR);
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

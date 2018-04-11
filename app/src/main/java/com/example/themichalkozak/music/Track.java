package com.example.themichalkozak.music;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

public  class Track implements Parcelable{
    
        private String mTrackName;
        private String mArtistName;
        private Drawable drawable;
    
        public Track(String mTrackName, String mArtistName, Drawable drawable) {
            this.mTrackName = mTrackName;
            this.mArtistName = mArtistName;
            this.drawable = drawable;
        }
    
        public String getmTrackName() {
            return mTrackName;
        }
    
        public String getmArtistName() {
            return mArtistName;
        }
    
        public Drawable getDrawable() {
            return drawable;
        }


    @Override
    public int describeContents() {
        return 0;
    }

    private Track(Parcel in){
        this.mTrackName = in.readString();
        this.mArtistName = in.readString();
        Bitmap bitmap = (Bitmap)in.readParcelable(getClass().getClassLoader());
        drawable = new BitmapDrawable(bitmap);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTrackName);
        dest.writeString(mArtistName);
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        dest.writeParcelable(bitmap,flags);
    }

    public static final Parcelable.Creator<Track> CREATOR =
            new Parcelable.Creator<Track>(){
                @Override
                public Track createFromParcel(Parcel source) {
                    return new Track(source);
                }

                @Override
                public Track[] newArray(int size) {
                    return new Track[size];
                }
            };
}

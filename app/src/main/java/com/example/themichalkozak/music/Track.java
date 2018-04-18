package com.example.themichalkozak.music;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

public  class Track implements Parcelable{
    
        private String mTrackName;
        private String mArtistName;
        private String drawable;
    
        public Track(String mTrackName, String mArtistName, String drawable) {
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
    
        public String getDrawable() {
            return drawable;
        }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(drawable);
        dest.writeString(mTrackName);
        dest.writeString(mArtistName);

    }

    @Override
    public int describeContents() {
        return 0;
    }

    private Track(Parcel in){
        this.drawable = in.readString();
        this.mTrackName = in.readString();
        this.mArtistName = in.readString();

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

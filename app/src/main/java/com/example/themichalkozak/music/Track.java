package com.example.themichalkozak.music;

import android.graphics.drawable.Drawable;

public  class Track {
    
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
    }
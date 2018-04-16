package com.example.themichalkozak.music;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class NowPlaying extends AppCompatActivity {

    ImageView albumImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();


        if (bundle != null) {
            TextView trackName = findViewById(R.id.track_name_now_playing);
            trackName.setText(bundle.getString("TRACK_EXTRA"));

            TextView artistName = findViewById(R.id.artist_name_now_playing);
            artistName.setText(bundle.getString("ARTIST_EXTRA"));

            String drawable = bundle.getString("ALBUM_EXTRA");
            Uri uri = Uri.parse(drawable);
            albumImage = findViewById(R.id.image_now_playing);
            albumImage.setImageURI(uri);
        }
    }
}

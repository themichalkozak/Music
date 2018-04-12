package com.example.themichalkozak.music;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class NowPlaying extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null) {
            TextView trackName = findViewById(R.id.track_name_now_playing);
            trackName.setText("");

            TextView artistName = findViewById(R.id.artist_name_now_playing);
            artistName.setText(bundle.getString("ARTIST_EXTRA"));

            Bitmap bitmap = bundle.getParcelable("ALBUM_EXTRA");
            Drawable albumDrawable = new BitmapDrawable(getResources(), bitmap);

            ImageView albumImage = findViewById(R.id.image_now_playing);
            albumImage.setImageDrawable(albumDrawable);

        }
    }
}

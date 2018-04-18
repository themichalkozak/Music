package com.example.themichalkozak.music;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class NowPlaying extends AppCompatActivity {

    ImageView albumImage;
    boolean play = true;

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
        findViewById(R.id.pause_play_track).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Button playPauseButton = findViewById(R.id.pause_play_track);
                if(play){
                    playPauseButton.setBackground(getDrawable(R.drawable.pause));
                    play = false;
                }else{
                    playPauseButton.setBackground(getDrawable(R.drawable.play));
                    play=true;
                }

            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}

package com.example.themichalkozak.music;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class TrackActivity extends AppCompatActivity {

    ArrayList<Track> trackArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null){
            trackArrayList = bundle.getParcelableArrayList("TRACK_EXTRA");
            String activityTitle = bundle.getString("ACTIVITY_EXTRA");
            this.setTitle(activityTitle);
        }


        final TrackAdapter trackAdapter = new TrackAdapter(this,trackArrayList);

        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(trackAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Track track = trackArrayList.get(position);
                Bitmap bitmap = ((BitmapDrawable) track.getDrawable()).getBitmap();


                Intent nowPlayingIntent = new Intent(TrackActivity.this,NowPlaying.class);
                nowPlayingIntent.putExtra("TRACK_EXTRA",track.getmTrackName());
                nowPlayingIntent.putExtra("ARTIST_EXTRA",track.getmArtistName());
                nowPlayingIntent.putExtra("ALBUM_EXTRA",bitmap);
                startActivity(nowPlayingIntent);
            }
        });
    }
}

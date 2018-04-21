package com.example.themichalkozak.music;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class AlbumActivity extends AppCompatActivity {

    ArrayList<Album> albums = new ArrayList<Album>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_grid_view);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null){
            albums = bundle.getParcelableArrayList("ALBUM_EXTRA");
            String activityTitle = bundle.getString("ACTIVITY_EXTRA");
            if(activityTitle == null){
                activityTitle = "Albums";
            }
            this.setTitle(activityTitle);
        }
        GridView gridView = findViewById(R.id.album_grid_view);
        AlbumAdapter albumAdapter = new AlbumAdapter(this, albums);


        gridView.setAdapter(albumAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                Album album = albums.get(position);
                Intent trackIntent = new Intent(AlbumActivity.this,TrackActivity.class);
                trackIntent.putParcelableArrayListExtra("TRACK_EXTRA",album.getTracks());
                trackIntent.putExtra("ACTIVITY_EXTRA",album.getmAlbumName());
                startActivity(trackIntent);

            }
        });

    }

}

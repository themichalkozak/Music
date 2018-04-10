package com.example.themichalkozak.music;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class AlbumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_grid_view);

        final ArrayList<Album> albumArrayList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            albumArrayList.add(new Album("Default Artist", "Default Album", getDrawable(R.drawable.albumdrawable)));

        }

        AlbumAdapter albumAdapter = new AlbumAdapter(this, albumArrayList);

        GridView gridView = findViewById(R.id.album_grid_view);
        gridView.setAdapter(albumAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Album album = albumArrayList.get(position);
                Bitmap bitmap = ((BitmapDrawable) album.getmDrawable()).getBitmap();
                Toast.makeText(AlbumActivity.this,album.getmArtistName(),Toast.LENGTH_SHORT).show();
                Intent nowPlayingIntent = new Intent(AlbumActivity.this,NowPlaying.class);
                nowPlayingIntent.putExtra("ALBUM_EXTRA",bitmap);
                nowPlayingIntent.putExtra("ARTIST_EXTRA",album.getmArtistName());
                startActivity(nowPlayingIntent);

            }
        });

    }
}

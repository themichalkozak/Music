package com.example.themichalkozak.music;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
            final ArrayList<Album> albums = bundle.getParcelableArrayList("ALBUM_EXTRA");
        }else{

            final ArrayList<Album> albums = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                albums.add(new Album("Default Artist", "Default Album", getDrawable(R.drawable.albumdrawable)));

            }
        }




        AlbumAdapter albumAdapter = new AlbumAdapter(this, albums);

        GridView gridView = findViewById(R.id.album_grid_view);
        gridView.setAdapter(albumAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Album album = albums.get(position);
                Bitmap bitmap = ((BitmapDrawable) album.getDrawable()).getBitmap();
                Toast.makeText(AlbumActivity.this,album.getmArtistName(),Toast.LENGTH_SHORT).show();
                Intent nowPlayingIntent = new Intent(AlbumActivity.this,NowPlaying.class);
                nowPlayingIntent.putExtra("ALBUM_EXTRA",bitmap);
                nowPlayingIntent.putExtra("ARTIST_EXTRA",album.getmArtistName());
                startActivity(nowPlayingIntent);

            }
        });

    }
}

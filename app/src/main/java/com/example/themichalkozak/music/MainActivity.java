package com.example.themichalkozak.music;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    public static final ArrayList<Artist> artistArrayList= new ArrayList<Artist>();

    public static final ArrayList<Album> albums = new ArrayList<Album>();

    public static final ArrayList<Track> tracks = new ArrayList<Track>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tracks.add(new Track("Masz to jak w banku","O.S.T.R.",getDrawable(R.drawable.songdrawable)));

        albums.add(new Album("O.S.T.R","Masz to jak w Banku",getDrawable(R.drawable.albumdrawable),tracks));

        artistArrayList.add(new Artist("O.S.T.R.",getDrawable(R.drawable.artistdrawable),albums));


        findViewById(R.id.artist_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent artistIntent = new Intent(MainActivity.this,ArtistActivity.class);
                artistIntent.putParcelableArrayListExtra("ARTIST_ALL",artistArrayList);
                startActivity(artistIntent);
            }
        });

        findViewById(R.id.album_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent albumIntent = new Intent(MainActivity.this,AlbumActivity.class);
                albumIntent.putParcelableArrayListExtra("ALBUM_EXTRA",albums);
                startActivity(albumIntent);
            }
        });

        findViewById(R.id.track_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent trackIntent = new Intent(MainActivity.this,TrackActivity.class);
                trackIntent.putParcelableArrayListExtra("TRACK_EXTRA",tracks);
                startActivity(trackIntent);
            }
        });
        findViewById(R.id.now_playing_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nowPlayingIntent = new Intent(MainActivity.this, NowPlaying.class);
                startActivity(nowPlayingIntent);
            }
        });
    }

//
//    public ArrayList<Artist> addArtist(String name, Drawable drawable){
//        ArrayList<Artist> artists = new ArrayList<>();
//        artists.add(new Artist(name,drawable);
//        return artists;
//    }

}

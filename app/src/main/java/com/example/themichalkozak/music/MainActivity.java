package com.example.themichalkozak.music;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    public static final ArrayList<Artist> artistArrayList= new ArrayList<>();

    public static final ArrayList<Album> albums = new ArrayList<Album>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        artistArrayList.add(new Artist("O.S.T.R.",getDrawable(R.drawable.artistdrawable)));
        artistArrayList.add(new Artist("O.S.T.R.",getDrawable(R.drawable.artistdrawable)));
        artistArrayList.add(new Artist("O.S.T.R.",getDrawable(R.drawable.artistdrawable)));
        artistArrayList.add(new Artist("O.S.T.R.",getDrawable(R.drawable.artistdrawable)));

//       addArtist("O.S.T.R.",getDrawable(R.drawable.artistdrawable));
//       addArtist("Małpa",getDrawable(R.drawable.artistdrawable));

//        albums.add(artistArrayList.get(0).addAlbum("Tabasko",getDrawable(R.drawable.albumdrawable)));
//        albums.add(artistArrayList.get(0).addAlbum("Tabasko",getDrawable(R.drawable.albumdrawable)));
//        albums.add(artistArrayList.get(0).addAlbum("Tabasko",getDrawable(R.drawable.albumdrawable)));
//        albums.add(artistArrayList.get(0).addAlbum("Tabasko",getDrawable(R.drawable.albumdrawable)));

        albums.add(new Album("ostr","elod",getDrawable(R.drawable.songdrawable)));


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

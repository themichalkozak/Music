package com.example.themichalkozak.music;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
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

        Artist artist = new Artist("O.S.T.R",getDrawable(R.drawable.artistdrawable));
        Artist artist1 = new Artist("defalut",getDrawable(R.drawable.artistdrawable));

        addArtist("O.S.T.R.",getDrawable(R.drawable.artistdrawable));
        addArtist("Małpa", getDrawable(R.drawable.artistdrawable));
        addAlbum("O.S.T.R.","Tabasko",getDrawable(R.drawable.albumdrawable));
        addAlbum("O.S.T.R.","JAzz dwa trzy..",getDrawable(R.drawable.albumdrawable));
        addTrack("O.S.T.R.","Jazz dwa trzy..","Abstynent");




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

    public void addArtist(String artistName, Drawable drawable){
        artistArrayList.add(new Artist(artistName,drawable));
    }
    public void addAlbum(String artistName, String album, Drawable drawable){
        if(findArtist(artistName) != null){
            Artist artist = findArtist(artistName);
            artist.addAlbum(album,drawable);
            albums.add(new Album(artistName,album,drawable, new ArrayList<Track>()));
        }
    }

    public void addTrack(String artistName, String albumName, String trackName){
        if(findArtist(artistName) != null){
            Artist artist= findArtist(artistName);
            if(artist.findAlbum(albumName) != null){
                Album album = artist.findAlbum(albumName);
                if(album.addTrack(trackName)){
                    tracks.add(new Track(trackName,artistName,album.getDrawable()));
                }
            }

        }
    }


    @Nullable
    private Artist findArtist(String name){
        for (Artist checkedArtist : artistArrayList){
            if(checkedArtist.equals(name)){
                return checkedArtist;
            }
        }
        return null;
    }


}

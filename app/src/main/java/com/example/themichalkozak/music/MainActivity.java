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


//        addArtist("O.S.T.R.",getDrawable(R.drawable.artisticon));
//        addArtist("Małpa", getDrawable(R.drawable.artisticon));
//        addAlbum("Małpa","Kilka numerów o czymś",getDrawable(R.drawable.albumicon));
//        addTrack("Małpa","Kilka numerów o czymś","Pozwól mi nie mówić nic");
//        addAlbum("O.S.T.R.","Tabasko",getDrawable(R.drawable.albumicon));
//        addAlbum("O.S.T.R.","Tabasko",getDrawable(R.drawable.albumicon));
//        addAlbum("O.S.T.R.","Jazz dwa trzy..",getDrawable(R.drawable.albumicon));
//        addTrack("O.S.T.R.","Jazz dwa trzy..","Abstynent");
//        addTrack("O.S.T.R.","Jazz dwa trzy..","Szpiedzy tacy jak my");

            addArtist("O.S.T.R.",getDrawable(R.drawable.artisticon));
            addArtist("Małpa",getDrawable(R.drawable.artisticon));
            addAlbum("Małpa","Pozwól mi nie mówić nic",getDrawable(R.drawable.albumicon));
            addTrack("Małpa","Pozwól mi nie mówić nic","Winner");


        createAlbumList();
        createTrackList();


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
        }
    }

    public void addTrack(String artistName, String albumName, String trackName){
        if(findArtist(artistName) != null){
            Artist artist= findArtist(artistName);
            if(artist.findAlbum(albumName) != null){
                Album album = artist.findAlbum(albumName);
                if(album.addTrack(trackName)){
                }
            }

        }
    }
    private Artist findArtist(String name){
        for (Artist checkedArtist : artistArrayList){
            if(checkedArtist.getmName().equals(name)){
                return checkedArtist;
            }
        }
        return null;
    }

    public void createAlbumList(){
        for(int i=0;i<artistArrayList.size();i++){
            Artist artist = artistArrayList.get(i);
            albums.addAll(artist.getAlbums());
        }
    }

    public void createTrackList(){
        for(int i=0;i<artistArrayList.size();i++){
            Artist artist = artistArrayList.get(i);
            for(int j=0;j<artist.getAlbums().size();j++) {
                Album album = artist.getAlbums().get(j);
                tracks.addAll(album.getTracks());
            }
        }
    }
}

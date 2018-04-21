package com.example.themichalkozak.music;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    public  final ArrayList<Artist> artists = new ArrayList<Artist>();

    public  final ArrayList<Album> albums = new ArrayList<Album>();

    public  final ArrayList<Track> tracks = new ArrayList<Track>();

    boolean isCreated = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uri uriArtist = Uri.parse("android.resource://com.example.themichalkozak.music/" + R.drawable.artisticon);
        Uri uriAlbum = Uri.parse("android.resource://com.example.themichalkozak.music/" + R.drawable.albumicon);
        String ostrArtistDrawable = uriArtist.toString();
        String albumDrawable = uriAlbum.toString();

        String ostr[] = getResources().getStringArray(R.array.ostr);
        String edSheeran[] = getResources().getStringArray(R.array.ed_sheeran_array);
        String malpa[] = getResources().getStringArray(R.array.malpa);



            addArtist(ostr[0], ostrArtistDrawable);
            addArtist(malpa[0], ostrArtistDrawable);
            addArtist(edSheeran[0], ostrArtistDrawable);

            addAlbum(edSheeran[0], edSheeran[1], albumDrawable);
            addAlbum(malpa[0], malpa[1], albumDrawable);
            addAlbum(ostr[0], ostr[1], albumDrawable);


            for (int i = 2; i < ostr.length; i++) {
                addTrack(edSheeran[0], edSheeran[1], edSheeran[i]);
                addTrack(malpa[0], malpa[1], malpa[i]);
                addTrack(ostr[0], ostr[1], ostr[i]);
            }

            createAlbumList();
            createTrackList();

        findViewById(R.id.artist_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent artistIntent = new Intent(MainActivity.this, ArtistActivity.class);
                artistIntent.putParcelableArrayListExtra("ARTIST_ALL", artists);
                startActivity(artistIntent);
            }
        });

        findViewById(R.id.album_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent albumIntent = new Intent(MainActivity.this, AlbumActivity.class);
                albumIntent.putParcelableArrayListExtra("ALBUM_EXTRA", albums);
                startActivity(albumIntent);
            }
        });

        findViewById(R.id.track_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent trackIntent = new Intent(MainActivity.this, TrackActivity.class);
                trackIntent.putParcelableArrayListExtra("TRACK_EXTRA", tracks);
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

    public void addArtist(String artistName, String drawable) {
                artists.add(new Artist(artistName, drawable));
                Log.i("Artist arrayList size", "" + artists.size());
    }

    public void addAlbum(String artistName, String album, String drawable) {
        if (findArtist(artistName) != null) {
            Artist artist = findArtist(artistName);
            artist.addAlbum(album, drawable);
        }
    }

    public void addTrack(String artistName, String albumName, String trackName) {
        if (findArtist(artistName) != null) {
            Artist artist = findArtist(artistName);
            if (artist.findAlbum(albumName) != null) {
                Album album = artist.findAlbum(albumName);
                if (album.addTrack(trackName)) {
                }
            }

        }
    }

    private Artist findArtist(String name) {
        for (Artist checkedArtist : artists) {
            if (checkedArtist.getmName().equals(name)) {
                return checkedArtist;
            }
        }
        return null;
    }

    public void createAlbumList() {
        if (!isCreated) {

            for (int i = 0; i < artists.size(); i++) {
                Artist artist = artists.get(i);
                albums.addAll(artist.getAlbums());
            }
            isCreated = true;
        }
    }

    public void createTrackList() {
        if (!isCreated) {
            for (int i = 0; i < artists.size(); i++) {
                Artist artist = artists.get(i);
                for (int j = 0; j < artist.getAlbums().size(); j++) {
                    Album album = artist.getAlbums().get(j);
                    tracks.addAll(album.getTracks());
                }
            }
            isCreated = true;
        }
    }

}

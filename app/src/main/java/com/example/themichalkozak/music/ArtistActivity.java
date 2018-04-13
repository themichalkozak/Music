package com.example.themichalkozak.music;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ArtistActivity extends AppCompatActivity {

    public static ArrayList<Artist> artists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null){

            artists = bundle.getParcelableArrayList("ARTIST_ALL");
        }

        ArtistAdapter artistAdapter = new ArtistAdapter(this,artists);

        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(artistAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Artist artist = artists.get(position);

                Intent albumIntent = new Intent(ArtistActivity.this,AlbumActivity.class);
                albumIntent.putParcelableArrayListExtra("ALBUM_EXTRA",artist.getAlbums());
                albumIntent.putExtra("ACTIVITY_EXTRA",artist.getmName());
                startActivity(albumIntent);
            }
        });

    }




}

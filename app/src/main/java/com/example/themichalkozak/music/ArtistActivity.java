package com.example.themichalkozak.music;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ArtistActivity extends AppCompatActivity {

    ArrayList<Artist> artists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        artists = new ArrayList<Artist>();

        for (int i=0;i<10;i++){

            artists.add(new Artist("default Artist",getDrawable(R.drawable.artistdrawable)));
        }


        ArtistAdapter artistAdapter = new ArtistAdapter(this,artists);

        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(artistAdapter);


    }


}

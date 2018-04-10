package com.example.themichalkozak.music;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class TrackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        ArrayList<Track> trackArrayList = new ArrayList<>();

        for (int i=0;i<10;i++){
            trackArrayList.add(new Track("Default Track","Default Artist",getDrawable(R.drawable.songdrawable)));
        }

        TrackAdapter trackAdapter = new TrackAdapter(this,trackArrayList);

        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(trackAdapter);
    }
}

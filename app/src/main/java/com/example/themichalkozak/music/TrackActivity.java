package com.example.themichalkozak.music;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class TrackActivity extends AppCompatActivity {

    ArrayList<Track> trackArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null){
            trackArrayList = bundle.getParcelableArrayList("TRACK_EXTRA");
        }

        TrackAdapter trackAdapter = new TrackAdapter(this,trackArrayList);

        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(trackAdapter);
    }
}

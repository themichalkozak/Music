package com.example.themichalkozak.music;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;

public class AlbumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_grid_view);

        ArrayList<Album> albumArrayList = new ArrayList<>();

        for(int i=0;i<10;i++){
            albumArrayList.add(new Album("Default Artist","Default Album",getDrawable(R.drawable.albumdrawable)));

        }

        AlbumAdapter albumAdapter = new AlbumAdapter(this,albumArrayList);

        GridView gridView = findViewById(R.id.album_grid_view);
        gridView.setAdapter(albumAdapter);
    }
}

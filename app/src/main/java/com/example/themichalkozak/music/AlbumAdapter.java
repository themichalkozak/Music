package com.example.themichalkozak.music;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by themichalkozak on 10/04/2018.
 */

public class AlbumAdapter extends ArrayAdapter<Album>{

    public AlbumAdapter(@NonNull Context context, @NonNull ArrayList<Album> albums) {
        super(context, 0, albums);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null){

            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_album,parent,false);
        }


        Album album = getItem(position);

        ImageView imageView = listItemView.findViewById(R.id.album_image);
        imageView.setImageDrawable(album.getDrawable());

        TextView albumTextView = listItemView.findViewById(R.id.album_name);
        albumTextView.setText(album.getmAlbumName());

        TextView artistTextView = listItemView.findViewById(R.id.artist_album_name);
        artistTextView.setText(album.getmArtistName());


        return listItemView;
    }
}

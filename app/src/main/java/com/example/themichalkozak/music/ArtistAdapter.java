package com.example.themichalkozak.music;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by themichalkozak on 10/04/2018.
 */

public class ArtistAdapter extends ArrayAdapter<Artist> {

    public ArtistAdapter(@NonNull Context context, @NonNull ArrayList<Artist> artists) {
        super(context, 0, artists);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if(convertView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_artist,parent,false);
        }

        Artist currentArtist = getItem(position);

        String drawable = currentArtist.getDrawable();
        Uri uri = Uri.parse(drawable);

        ImageView imageView = listItemView.findViewById(R.id.artist_image);
        imageView.setImageURI(uri);

        TextView nameArtist = listItemView.findViewById(R.id.artist_name);
        nameArtist.setText(currentArtist.getmName());



        return listItemView;
    }
}

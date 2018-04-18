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

public class TrackAdapter extends ArrayAdapter<Track> {

    public TrackAdapter(@NonNull Context context, @NonNull ArrayList<Track> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_tracks,parent,false);
        }

        Track currentTrack = getItem(position);

        String drawable = currentTrack.getDrawable();
        Uri uri = Uri.parse(drawable);

        ImageView imageView = listItemView.findViewById(R.id.track_image);
        imageView.setImageURI(uri);

        TextView artistTextView = listItemView.findViewById(R.id.track_artist_name);
        artistTextView.setText(currentTrack.getmArtistName());

        TextView trackTextView = listItemView.findViewById(R.id.track_name);
        trackTextView.setText(currentTrack.getmTrackName());


        return listItemView;
    }
}

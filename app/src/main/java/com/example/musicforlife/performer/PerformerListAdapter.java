package com.example.musicforlife.performer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.musicforlife.R;

import java.util.ArrayList;
import java.util.List;

public class PerformerListAdapter extends ArrayAdapter<Performer> {

    private Context mContext;
    int mResource;

    public PerformerListAdapter(Context context, int resource, ArrayList<Performer> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String name = getItem(position).getName();
        String song = getItem(position).getSong();
        String featuring = getItem(position).getFeaturing();

        Performer performer = new Performer(name, song, featuring);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView nameTextView = convertView.findViewById(R.id.performerNameTextView);
        TextView songTextView = convertView.findViewById(R.id.performerSongTextView);
        TextView featuringTextView = convertView.findViewById(R.id.featuringTextView);

        nameTextView.setText(name);
        songTextView.setText(song);
        featuringTextView.setText(featuring);

        return convertView;
    }
}

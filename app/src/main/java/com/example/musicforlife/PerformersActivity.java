package com.example.musicforlife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.musicforlife.performer.Performer;
import com.example.musicforlife.performer.PerformerListAdapter;

import java.util.ArrayList;

public class PerformersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_performers);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListView performersListView = findViewById(R.id.performersListView);

        //Create the artists
        Performer example = new Performer("Artist", "Song", "Feat.");
        Performer marcusMumford = new Performer("Marcus Mumford", "Timshel", "Alone");
        Performer takeThat = new Performer("Take That", "Shine,Giants, Rule The World", "Alone");
        Performer robbieWilliams = new Performer("Robbie Williams", "Strong, Angels", "Alone");
        Performer pharrellWilliams1 = new Performer("Pharrell Williams", "Get Lucky", "feat. Marcus Mumford");
        Performer pharrellWilliams2 = new Performer("Pharrell Williams", "Happy", "feat. Miley Cyrus");
        Performer mileyCyrus = new Performer("Miley Cyrus", "Inspired", "Alone");
        Performer niallHoran = new Performer("Niall Horan", "Slow Hands, This Town", "Alone");
        Performer littleMix = new Performer("Little Mix", "Wings", "Alone");
        Performer arianaGrande1 = new Performer("Ariana Grande", "Be Alright, Break Free", "Alone");
        Performer arianaGrande2 = new Performer("Ariana Grande", "Better Days", "feat. Victoria Monet");
        Performer arianaGrande3 = new Performer("Ariana Grande", "The Way, Dang!", "feat. Mac Miller");
        Performer arianaGrande4 = new Performer("Ariana Grande", "Don't Dream It's Over", "feat. Miley Cyrus");
        Performer rihanna = new Performer("Rihanna", "LOYALTY", "feat. Kendrick Lamar");
        Performer rihanna1 = new Performer("Rihanna", "L.E.M.O.N.", "Alone");
        Performer rihanna2 = new Performer("Rihanna", "Wild Thoughts", "Alone");


        //Add artists to an arraylist
        ArrayList<Performer> performerArrayList = new ArrayList<>();

        performerArrayList.add(example);
        performerArrayList.add(marcusMumford);
        performerArrayList.add(takeThat);
        performerArrayList.add(robbieWilliams);
        performerArrayList.add(pharrellWilliams1);
        performerArrayList.add(pharrellWilliams2);
        performerArrayList.add(mileyCyrus);
        performerArrayList.add(niallHoran);
        performerArrayList.add(littleMix);
        performerArrayList.add(arianaGrande1);
        performerArrayList.add(arianaGrande2);
        performerArrayList.add(arianaGrande3);
        performerArrayList.add(arianaGrande4);
        performerArrayList.add(rihanna);
        performerArrayList.add(rihanna1);
        performerArrayList.add(rihanna2);


        PerformerListAdapter adapter = new PerformerListAdapter(this, R.layout.adapter_view_layout, performerArrayList);
        performersListView.setAdapter(adapter);

    }


}
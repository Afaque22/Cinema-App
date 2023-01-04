package com.example.cinemaapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    ArrayList<constructors> arrModel = new ArrayList<>();
    RAdapter rAdapter;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbarx);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("CINEMA APP");

        recyclerView = findViewById(R.id.RecyclerCard);

        arrModel.add(new constructors(R.drawable.movie, "Maula Jatt", "07:30PM", "Friday"));
        arrModel.add(new constructors(R.drawable.movie2, "Top Gun Maverick", "10:30PM", "Friday"));
        arrModel.add(new constructors(R.drawable.movie3, "SpiderMan No Way Home", "01:00PM", "Saturday"));
        arrModel.add(new constructors(R.drawable.movie_6, "1899", "06:30PM", "Saturday"));
        arrModel.add(new constructors(R.drawable.movie_5, "Stranger Things", "07:00PM", "Sunday"));
        arrModel.add(new constructors(R.drawable.movie_7, "Money Heist", "11:00AM", "Sunday"));
        arrModel.add(new constructors(R.drawable.movie_4, "Wakanda Forever", "09:00PM", "Monday"));
        arrModel.add(new constructors(R.drawable.movie1, "Coming Soon", "----", "----"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        rAdapter = new RAdapter(this, arrModel);
        recyclerView.setAdapter(rAdapter);
    }

}
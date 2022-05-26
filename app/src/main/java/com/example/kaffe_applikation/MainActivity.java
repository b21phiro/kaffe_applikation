package com.example.kaffe_applikation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private DrinkRecyclerViewAdapter adapter;
    private final String JSON_FILE = "https://mobprog.webug.se/json-api?login=b21phiro";
    private ArrayList<Drink> drinks;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Gömmer actionbar
        getSupportActionBar().hide();

        JsonTask jsonTask = new JsonTask(this);
        jsonTask.execute(this.JSON_FILE);

        tabLayout = findViewById(R.id.tabs);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        break;
                    case 1:
                        Intent intent = new Intent(MainActivity.this, About.class);
                        startActivity(intent);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public void onPostExecute(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Drink>>(){}.getType();
        this.drinks = gson.fromJson(json, type);

        RecyclerView recyclerView = findViewById(R.id.cupHolder);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new DrinkRecyclerViewAdapter(this, this.drinks);
        recyclerView.setAdapter(adapter);

    }
}
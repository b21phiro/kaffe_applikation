package com.example.kaffe_applikation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private final String JSON_FILE = "https://mobprog.webug.se/json-api?login=b21phiro";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JsonTask jsonTask = new JsonTask(this);
        jsonTask.execute(this.JSON_FILE);

    }

    @Override
    public void onPostExecute(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Drink>>(){}.getType();
        ArrayList<Drink> drinks;
        drinks = gson.fromJson(json, type);
    }
}
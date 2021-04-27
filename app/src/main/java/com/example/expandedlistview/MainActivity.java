package com.example.expandedlistview;

import android.os.Bundle;
import android.widget.ExpandableListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    List<String>names;
    Map<String,List<String>>movies;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableListView = findViewById(R.id.expView);

        getData();
        myAdapter = new MyAdapter(this,names,movies);
        expandableListView.setAdapter(myAdapter);


    }

    private void getData()
    {
        names = new ArrayList<>();
        names.add("Amithabh Bachan");
        names.add("Mohanlal");
        names.add("Manju Warrier");
        names.add("Mammutty");



        movies = new HashMap<>();
        List<String>Amitha = new ArrayList<>();
        Amitha.add("Anand");
        Amitha.add("Chupki Chipki");
        Amitha.add("Sholay");
        Amitha.add("Black");

        List<String>Mohan = new ArrayList<>();
        Mohan.add("Lucifer");
        Mohan.add("jilla");
        Mohan.add("Natturajaavu");
        Mohan.add("Drishyam");

        List<String>Manju = new ArrayList<>();
        Manju.add("Lucifer");
        Manju.add("Preest");
        Manju.add("How old Are You");
        Manju.add("Jo And The Boy");

        List<String>Mammukka = new ArrayList<>();
        Mammukka.add("preest");
        Mammukka.add("The King");
        Mammukka.add("Big Be");
        Mammukka.add("Greate Father");

        movies.put(names.get(0), Amitha);
        movies.put(names.get(1),Mohan);
        movies.put(names.get(2),Manju);
        movies.put(names.get(3),Mammukka);

    }
}
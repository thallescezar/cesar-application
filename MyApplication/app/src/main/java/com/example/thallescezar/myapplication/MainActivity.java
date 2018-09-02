package com.example.thallescezar.myapplication;

import android.app.SearchManager;
import android.content.Context;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    MyAdapter adapter;

    List<String> itemList = Arrays.asList("Black", "Black-Blue", "Blue", "Blue-White", "White",
            "White-Red", "Red", "Red-Green", "Green", "Green-Black");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.hasFixedSize();

        adapter = new MyAdapter(this.itemList, this);

        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);

        // Get the SearchView and set the searchable configuration
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        // Assumes current activity is the searchable activity
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {


                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                List<String> tempList = new ArrayList<>();

                if(s.isEmpty()) {
                    tempList = itemList;
                } else {

                    for (String word: Utils.possibleWords) {
                        if(Utils.checkTypos(word.toLowerCase(), s.toLowerCase())
                                ^ Utils.checkJumbledLetters(word.toLowerCase().toCharArray(),
                                s.toLowerCase().toCharArray())) {

                            for (String item: itemList) {
                                if(item.contains(word)) {
                                    tempList.add(item);
                                }
                            }
                        }
                    }
                }

                adapter.updateItemList(tempList);
                return false;
            }
        });

        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}

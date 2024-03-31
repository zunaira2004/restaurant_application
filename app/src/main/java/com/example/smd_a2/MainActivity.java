package com.example.smd_a2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    Button btnAdd,btnSearch;
    RecyclerView rvItems;
    ItemAdapter adapter;
    TextInputEditText etFilter;
    public static ArrayList<Item> item;
    private static final String SHARED_PREFS_KEY = "shared_prefs_key";
    private static final String ITEM_LIST_KEY = "item_list_key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rvItems=findViewById(R.id.rvItems);
        rvItems.setLayoutManager(new LinearLayoutManager(this));


        init();

        loadItemsFromSharedPreferences(); // Load saved items

        adapter = new ItemAdapter(item, new ItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Item i) {
                detailsRestaurantDetails(i);
            }
        });
        rvItems.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(MainActivity.this, FormActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchText = etFilter.getText().toString().trim().toLowerCase();
                if (searchText.equals("rating")) {
                    sortItemsByRating();
                }
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            String name = data.getStringExtra("Res_name");
            String subname = data.getStringExtra("Res_subname");
            String location = data.getStringExtra("Res_location");
            String phone = data.getStringExtra("Res_phone");
            String description = data.getStringExtra("Res_description");
            String rating = String.valueOf(data.getIntExtra("Res_rating",0));

            int rat=Integer.parseInt(rating);
//            Item newItem = new Item(name, location, phone, description, subname, 5);
//            item.add(newItem);
            item.add(new Item(name, location, phone, description, subname,rat));
            adapter.notifyDataSetChanged();
            saveItemsToSharedPreferences();
        }
    }

    void init()
    {
        btnAdd=findViewById(R.id.btnAdd);
        etFilter=findViewById(R.id.etFilter);
        btnSearch=findViewById(R.id.btnSearch);

        item=new ArrayList<>();
        item.add(new Item("food1","location1","03024593139","description1","subitem1",5));
        item.add(new Item("food2","location2","03024593139","description2","subitem2",2));
        item.add(new Item("food3","location3","03024593139","description3","subitem3",2));
        item.add(new Item("food4","location4","03024593139","description4","subitem4",1));
        item.add(new Item("food5","location4","03024593139","description5","subitem5",3));
        item.add(new Item("food6","location5r","03024593139","description6","subitem6",4));

        rvItems.setHasFixedSize(true);
    }


    public void detailsRestaurantDetails(Item d) {
        Intent intent=new Intent(MainActivity.this,Details_Activity.class);
        intent.putExtra("Res_name",d.getRestaurant_name());
        intent.putExtra("Res_subname",d.getSubItem());
        intent.putExtra("Res_location",d.getLocation());
        intent.putExtra("Res_phone",d.getPhone_no());
        intent.putExtra("Res_description",d.getDescription());
        intent.putExtra("Res_rating",d.getRating());
        System.out.println(d.getRating());

        startActivity(intent);
    }
    private void sortItemsByRating() {
        Collections.sort(item, new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                // Sort by descending order of rating
                return Integer.compare(item2.getRating(), item1.getRating());
            }
        });
        adapter.notifyDataSetChanged(); // Update the RecyclerView
    }

    private void saveItemsToSharedPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(item);
        editor.putString(ITEM_LIST_KEY, json);
        editor.apply();
    }

    private void loadItemsFromSharedPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_KEY, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(ITEM_LIST_KEY, "");
        Type type = new TypeToken<ArrayList<Item>>() {}.getType();
        item = gson.fromJson(json, type);

        if (item == null) {
            item = new ArrayList<>();
        }
    }

}
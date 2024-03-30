package com.example.smd_a2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnAdd;
    RecyclerView rvItems;
    ItemAdapter adapter;
    ArrayList<Item> item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rvItems=findViewById(R.id.rvItems);
        rvItems.setLayoutManager(new LinearLayoutManager(this));

        init();

        adapter=new ItemAdapter(item);
        rvItems.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this, FormActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    void init()
    {
        btnAdd=findViewById(R.id.btnAdd);

        item=new ArrayList<>();
        item.add(new Item("heavy khana","Apky samny wala ghar","03024593139","ek bar kha k dekho","desi"));
        item.add(new Item("heavy khana","Apky samny wala ghar","03024593139","ek bar kha k dekho","desi"));
        item.add(new Item("heavy khana","Apky samny wala ghar","03024593139","ek bar kha k dekho","desi"));
        item.add(new Item("heavy khana","Apky samny wala ghar","03024593139","ek bar kha k dekho","desi"));
        item.add(new Item("heavy khana","Apky samny wala ghar","03024593139","ek bar kha k dekho","desi"));
        item.add(new Item("heavy khana","Apky samny wala ghar","03024593139","ek bar kha k dekho","desi"));
        item.add(new Item("heavy khana","Apky samny wala ghar","03024593139","ek bar kha k dekho","desi"));
        item.add(new Item("heavy khana","Apky samny wala ghar","03024593139","ek bar kha k dekho","desi"));
        item.add(new Item("heavy khana","Apky samny wala ghar","03024593139","ek bar kha k dekho","desi"));
        item.add(new Item("heavy khana","Apky samny wala ghar","03024593139","ek bar kha k dekho","desi"));
        item.add(new Item("heavy khana","Apky samny wala ghar","03024593139","ek bar kha k dekho","desi"));
        item.add(new Item("heavy khana","Apky samny wala ghar","03024593139","ek bar kha k dekho","desi"));
        item.add(new Item("heavy khana","Apky samny wala ghar","03024593139","ek bar kha k dekho","desi"));
        item.add(new Item("heavy khana","Apky samny wala ghar","03024593139","ek bar kha k dekho","desi"));
        item.add(new Item("heavy khana","Apky samny wala ghar","03024593139","ek bar kha k dekho","desi"));

//        rvItems.setHasFixedSize(true);
    }
}
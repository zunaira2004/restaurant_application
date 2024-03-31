package com.example.smd_a2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Details_Activity extends AppCompatActivity {

    TextView tvName,tvCategory,tvLocation,tvPhone,tvDescription,tvRating;
    Button btnBack;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        if (intent != null) {
            String name = intent.getStringExtra("Res_name");
            String subname = intent.getStringExtra("Res_subname");
            String location = intent.getStringExtra("Res_location");
            String phone = intent.getStringExtra("Res_phone");
            String description = intent.getStringExtra("Res_description");
            int rating = intent.getIntExtra("Res_rating", 0);


            tvName = findViewById(R.id.tvName);
            tvCategory = findViewById(R.id.tvCategory);
            tvLocation = findViewById(R.id.tvLocation);
            tvPhone = findViewById(R.id.tvPhone);
            tvDescription = findViewById(R.id.tvDescription);
            tvRating=findViewById(R.id.tvRating);

            tvName.setText(name);
            tvCategory.setText(subname);
            tvLocation.setText(location);
            tvPhone.setText(phone);
            tvDescription.setText(description);
            tvRating.setText(String.valueOf(rating));

        }

        btnBack=findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Details_Activity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

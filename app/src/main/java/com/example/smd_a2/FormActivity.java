package com.example.smd_a2;

import static com.example.smd_a2.MainActivity.item;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class FormActivity extends AppCompatActivity {

    Button btnSubmit;
    TextInputEditText etName,etSubname,etLocation,etPhone,etDescription, etRating;
    protected void onCreate(Bundle saveInstanceState) {

        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_form);

       init();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                String name = etName.getText().toString();
                String subname = etSubname.getText().toString();
                String location = etLocation.getText().toString();
                String phone = etPhone.getText().toString().trim();
                String description = etDescription.getText().toString();

                int rating = 0;
                rating = Integer.parseInt(etRating.getText().toString());



                resultIntent.putExtra("Res_name", name);
                resultIntent.putExtra("Res_subname", subname);
                resultIntent.putExtra("Res_location", location);
                resultIntent.putExtra("Res_phone", phone);
                resultIntent.putExtra("Res_description", description);
                resultIntent.putExtra("Res_rating", rating);

                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });


    }
    void init()
    {
        btnSubmit=findViewById(R.id.btnSubmit);
        etName=findViewById(R.id.etName);
        etSubname=findViewById(R.id.etSubname);
        etLocation=findViewById(R.id.etLocation);
        etPhone=findViewById(R.id.etPhone);
        etDescription=findViewById(R.id.etDescription);
        etRating=findViewById(R.id.etRating);
    }
}

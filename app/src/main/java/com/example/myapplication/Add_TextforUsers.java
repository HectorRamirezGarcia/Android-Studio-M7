package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Add_TextforUsers extends AppCompatActivity {

    String [] array_noms;
    int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__textfor_users);

        Intent intent = getIntent();
        array_noms = intent.getStringArrayExtra("array_noms");
        contador = intent.getIntExtra("contador", 0);

        final Button button = findViewById(R.id.Add_UserText);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText form_txt_nom = findViewById(R.id.editTextNameUser);
                String nom = form_txt_nom.getText().toString();
                array_noms[contador] = nom;
                contador++;
                }
            });
        }

        @Override
        public void onBackPressed() {
            Intent returnIntent = new Intent();
            returnIntent.putExtra("array_noms", array_noms);
            returnIntent.putExtra("contador", contador);
            setResult(RESULT_OK, returnIntent);
            finish();
        }

    }

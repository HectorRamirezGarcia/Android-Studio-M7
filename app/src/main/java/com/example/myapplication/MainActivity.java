package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    int puntaje1, puntaje2, puntaje3, puntaje4, puntaje5, puntaje6;
    int racha1, racha2, racha3, racha4, racha5, racha6;
    String[] array_noms;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        array_noms = intent.getStringArrayExtra("array_noms");
        puntaje1 = intent.getIntExtra("puntaje1", puntaje1);
        puntaje2 = intent.getIntExtra("puntaje2", puntaje2);
        puntaje3 = intent.getIntExtra("puntaje3", puntaje3);
        puntaje4 = intent.getIntExtra("puntaje4", puntaje4);
        puntaje5 = intent.getIntExtra("puntaje5", puntaje5);
        puntaje6 = intent.getIntExtra("puntaje6", puntaje6);
        racha1 = intent.getIntExtra("racha1", racha1);
        racha2 = intent.getIntExtra("racha2", racha2);
        racha3 = intent.getIntExtra("racha3", racha3);
        racha4 = intent.getIntExtra("racha4", racha4);
        racha5 = intent.getIntExtra("racha5", racha5);
        racha6 = intent.getIntExtra("racha6", racha6);

        Button btn = findViewById(R.id.buttonStart);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (MainActivity.this, Add_Users.class));
            }
        });

        Button btn2 = findViewById(R.id.buttonViewEstadistics);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoResults();
            }
        });
    }

    private void gotoResults() {
        Intent intent = new Intent(this, view_estadisticts.class);
        intent.putExtra("array_noms", array_noms);
        intent.putExtra("puntaje1", puntaje1);
        intent.putExtra("puntaje2", puntaje2);
        intent.putExtra("puntaje3", puntaje3);
        intent.putExtra("puntaje4", puntaje4);
        intent.putExtra("puntaje5", puntaje5);
        intent.putExtra("puntaje6", puntaje6);
        intent.putExtra("racha1", racha1);
        intent.putExtra("racha2", racha2);
        intent.putExtra("racha3", racha3);
        intent.putExtra("racha4", racha4);
        intent.putExtra("racha5", racha5);
        intent.putExtra("racha6", racha6);
        startActivity(intent);
    }

}

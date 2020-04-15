package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class view_estadisticts extends AppCompatActivity {
    int puntaje1, puntaje2, puntaje3, puntaje4, puntaje5, puntaje6;
    int racha1, racha2, racha3, racha4, racha5, racha6;
    String[] array_noms;
    String resultado1, resultado2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_estadisticts);

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

        TextView txtResultado = findViewById(R.id.textViewResult);
        resultado1 += puntaje1+" "+puntaje2+" "+puntaje3+" "+puntaje4+" "+puntaje5+" "+puntaje6;
        resultado2 += racha1+" "+racha2+" "+racha3+" "+racha4+" "+racha5+" "+racha6;

        txtResultado.setText(resultado1);
        txtResultado.setText(resultado2);
    }

}

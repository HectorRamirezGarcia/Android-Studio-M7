package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Add_Users extends AppCompatActivity {

    int max_users = 6;
    String[] array_noms = new String[max_users];

    int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button afegirUsuari = findViewById(R.id.Add_UserText);
        afegirUsuari.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goToAfegirUsuaris();
            }
        });
    }
    @Override
    protected void onActivityResult (int requestCode, int resultCode, @Nullable Intent data){
    super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
           if (resultCode == RESULT_OK) {
              array_noms = data.getStringArrayExtra("array_noms");
              contador = data.getIntExtra("contador", 0);

               TextView txtResultado = findViewById(R.id.recyclerid);
               txtResultado.setText(array_noms[0] + " -- " + array_noms[1] + " ------> " + contador);
                }
            }
        }
    private void goToAfegirUsuaris() {
        Intent intent = new Intent(this, Add_TextforUsers.class);
        intent.putExtra("array_noms", array_noms);
        intent.putExtra("contador", contador);
        startActivityForResult(intent, 1);
    }
}
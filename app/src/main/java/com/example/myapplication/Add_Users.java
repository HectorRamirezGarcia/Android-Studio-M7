package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Add_Users extends AppCompatActivity {

    RecyclerView recycler;

    Button btn_startgame;

    int max_users = 6;
    String[] array_noms = new String[max_users];

    int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_jugadores);

        btn_startgame = findViewById(R.id.buttonStartGame);
        btn_startgame.setVisibility(View.GONE);

        final Button afegirusuari = findViewById(R.id.buttonAddUsers);
        afegirusuari.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goToAfegirUsuaris();
            }
        });

        btn_startgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoStartGame();
            }
        });
    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, @Nullable Intent data){
    super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1){
            if(resultCode == RESULT_OK){
                array_noms = data.getStringArrayExtra("array_noms");
                contador = data.getIntExtra("contador", 0);
                TextView txtResultado = findViewById(R.id.resultado);
                String resultado = "";
                for (int i = 0; i < contador; i++){
                    resultado += array_noms[i]+" ";
                }
                txtResultado.setText(resultado);

                if (array_noms.length > 1 ) {
                    btn_startgame.setVisibility(View.VISIBLE);
                    }
                }
        }

    }

    private void goToAfegirUsuaris() {
        Intent intent = new Intent(this, Add_TextforUsers.class);
        intent.putExtra("array_noms", array_noms);
        intent.putExtra("contador", contador);
        startActivityForResult(intent, 1);
    }

    private void gotoStartGame() {
        Intent intent = new Intent(this, Quiz.class);
        intent.putExtra("array_noms", array_noms);
        intent.putExtra("contador", contador);
        startActivity(intent);
    }
}

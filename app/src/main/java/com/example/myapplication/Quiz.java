package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz extends AppCompatActivity {

    int jugador;
    int puntaje1, puntaje2, puntaje3, puntaje4, puntaje5, puntaje6;
    int racha1, racha2, racha3, racha4, racha5, racha6;

    private int id_answer[] = {
            R.id.answer1, R.id.answer2, R.id.answer3, R.id.answer4
    };
    private int correct_answer, current_question, posicion, contador;
    private String[] all_questions;
    private TextView text_question;
    private RadioGroup group;
    private String[] array_noms;
    private TextView text_users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Intent intent = getIntent();
        array_noms = intent.getStringArrayExtra("array_noms");

        text_users = findViewById(R.id.textViewUserRD);

        text_question = (TextView) findViewById(R.id.text_question);
        group = (RadioGroup) findViewById(R.id.radio_answers);


        all_questions = getResources().getStringArray(R.array.all_questions);
        posicion=1;
        current_question = 0;
        contador=0;
        show_question();

        Button btn_check = (Button) findViewById(R.id.btncheck);
        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = group.getCheckedRadioButtonId();
                int answer =-1;
                for (int i = 0; i < id_answer.length; i++) {
                    if (id_answer[i] == id){
                        answer = i;
                        }
                    }
                if (answer == correct_answer){
                    if (posicion == 1){
                        puntaje1+=1;
                        racha1+=1;
                    }
                    if (posicion == 2){
                        puntaje2+=1;
                        racha2+=1;
                    }
                    if (posicion == 3){
                        puntaje3+=1;
                        racha3+=1;

                    }
                    if (posicion == 4){
                        puntaje4+=1;
                        racha4+=1;

                    }
                    if (posicion == 5){
                        puntaje5+=1;
                        racha5+=1;

                    }
                    if (posicion == 6) {
                        puntaje6+=1;
                        racha6+=1;

                    }
                    Toast.makeText(Quiz.this, R.string.correct, Toast.LENGTH_SHORT).show();
                    }
                else {
                    Toast.makeText(Quiz.this, R.string.incorrect, Toast.LENGTH_SHORT).show();
                    if (posicion == 1){
                        racha1=0;
                    }
                    if (posicion == 2){
                        racha2=0;
                    }
                    if (posicion == 3){
                        racha3=0;
                    }
                    if (posicion == 4){
                        racha4=0;
                    }
                    if (posicion == 5){
                        racha5=0;
                    }
                    if (posicion == 6) {
                        racha6=0;
                    }
                    }
                if (posicion > array_noms.length-1){
                    posicion=0;
                }
                else {
                    posicion++;
                }
                current_question++;
                show_question();
                gotoResults();
                }
        });
    }

    private void show_question() {
        String q = all_questions[current_question];
        String[] parts = q.split(";");

        group.clearCheck();
        text_question.setText(parts[0]);

        text_users.setText(array_noms[jugador]);

        for (int i = 0; i < id_answer.length; i++){
            RadioButton rb = (RadioButton) findViewById(id_answer[i]);
            String answer = parts[i+1];
            if (answer.charAt(0) == '*'){
                correct_answer = i;
                answer = answer.substring(1);
            }
            rb.setText(answer);
        }
        if (jugador > array_noms.length-1){
            jugador = 0;
        }
        else{
            jugador++;
        }

    }

    private void gotoResults() {
        Intent intent = new Intent(this, MainActivity.class);
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

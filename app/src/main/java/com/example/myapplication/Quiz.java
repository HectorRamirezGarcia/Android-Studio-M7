package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz extends AppCompatActivity {

    private int id_answer[] = {
            R.id.answer1, R.id.answer2, R.id.answer3, R.id.answer4
    };
    private int correct_answer, current_question;
    private String[] all_questions;
    private TextView text_question;
    private RadioGroup group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        text_question = (TextView) findViewById(R.id.text_question);
        group = (RadioGroup) findViewById(R.id.radio_answers);


        all_questions = getResources().getStringArray(R.array.all_questions);
        current_question = 0;
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
                    Toast.makeText(Quiz.this, R.string.correct, Toast.LENGTH_SHORT).show();
                    }
                else {
                    Toast.makeText(Quiz.this, R.string.incorrect, Toast.LENGTH_SHORT).show();
                    }
                current_question++;
                show_question();
                }
        });
    }

    private void show_question() {
        String q = all_questions[current_question];
        String[] parts = q.split(";");

        group.clearCheck();
        text_question.setText(parts[0]);

        for (int i = 0; i < id_answer.length; i++){
            RadioButton rb = (RadioButton) findViewById(id_answer[i]);
            String answer = parts[i+1];
            if (answer.charAt(0) == '*'){
                correct_answer = i;
                answer = answer.substring(1);
            }
            rb.setText(answer);
        }
    }
}

    package com.example.multiscreens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

    public class MainActivity extends AppCompatActivity {
    private String[] questions = {"Java is a person?", "Java was introduced in 1995",
            "Java was created using Python","Java has abstration class?",
            "Java has interfaces?"};
    private boolean[] answers ={false, true, false, true, true};
    private int score = 0;
    Button yes;
    Button no;

    TextView question;

    private int index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        yes =findViewById(R.id.yes);
        no = findViewById(R.id.no);
        question = findViewById(R.id.question);
        question.setText(questions[index]);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index <= questions.length-1) {
                    if (answers[index] == true) {
                        score++;
                    }
                    index++;
                    if (index <= questions.length - 1) {
                        question.setText(questions[index]);
                    } else {
                        Toast.makeText(MainActivity.this, "Your score : " + score +"/" + questions.length, Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Restart the app to play again...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index <= questions.length-1){
                    if(answers[index]==false){
                        score++;

                    }
                    index++;
                    if(index <= questions.length-1){
                        question.setText(questions[index]);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Your score : " +score + "/" + questions.length, Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "Restar the app to play again...", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
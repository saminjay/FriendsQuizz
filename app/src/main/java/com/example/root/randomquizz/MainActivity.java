package com.example.root.randomquizz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private int finalScore = 0;
    String ans1, ans2, ans3;
    CheckBox option1, option2, option3, option4, option5, option6, option7, option8;
    String finalMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup answer1 = findViewById(R.id.answer1);
        RadioGroup answer2 = findViewById(R.id.answer2);
        RadioGroup answer3 = findViewById(R.id.answer3);

        answer1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton selectedAnswer =  findViewById(checkedId);
                ans1 = selectedAnswer.getText().toString();
            }
        });

        answer2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton selectedAnswer = (RadioButton) findViewById(checkedId);
                ans2 = selectedAnswer.getText().toString();
            }
        });

        answer3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton selectedAnswer = findViewById(checkedId);
                ans3 = selectedAnswer.getText().toString();
            }
        });

        option1 = findViewById(R.id.answer6_option1);
        option2 = findViewById(R.id.answer6_option2);
        option3 = findViewById(R.id.answer6_option3);
        option4 = findViewById(R.id.answer6_option4);
        option5 = findViewById(R.id.answer6_option5);
        option6 = findViewById(R.id.answer6_option6);
        option7 = findViewById(R.id.answer6_option7);
        option8 = findViewById(R.id.answer6_option8);
    }

    public void submit(View view) {
        EditText nameText = (EditText) findViewById(R.id.name);
        String name = nameText.getText().toString();


        if (Objects.equals(ans1,"Dutch"))
            finalScore++;

        if(Objects.equals(ans2,"Moist Maker"))
            finalScore++;

        if(Objects.equals(ans3,"Wethead"))
            finalScore++;

        EditText answer4 = findViewById(R.id.answer4);
        String ans4 = answer4.getText().toString();
        if(Objects.equals(ans4, "Statistical analysis and data reconfiguration"))
            finalScore++;

        EditText answer5 = findViewById(R.id.answer5);
        String ans5 = answer5.getText().toString();
        if(Objects.equals(ans5, "Muriel"))
            finalScore++;

        if(option1.isChecked() && !option2.isChecked() && option3.isChecked() && !option4.isChecked() && option5.isChecked() && !option6.isChecked() && !option7.isChecked() && !option8.isChecked())
            finalScore++;

        if(finalScore<5)
            finalMessage = name + ", Your score is " + finalScore + "/6";
        else
            finalMessage = name + ", You are definitely a big fan of FRIENDS. Your score is " + finalScore + "/6";

        Toast.makeText(getApplicationContext(),finalMessage,Toast.LENGTH_LONG).show();
        finalScore=0;
    }
}

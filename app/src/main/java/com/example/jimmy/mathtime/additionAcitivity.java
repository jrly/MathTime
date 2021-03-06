package com.example.jimmy.mathtime;

import android.app.Activity;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import java.util.*;

public class additionAcitivity extends Activity {

    Button button0;
    Button button1;
    Button button2;
    Button button3;
    TextView sum;
    Button startButton;
    TextView resultTextView;
    TextView pointsTextView;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    int locationOfCorrectAnswer;
    int score = 0;
    int numberOfQuestions = 0;
    TextView timerTextView;
    Button playAgainButton;
    RelativeLayout gameRelativeLayout;
    GridLayout buttonLayout;
    float percent;

    public void playAgain(View view){
        score = 0;
        numberOfQuestions = 0;
        timerTextView.setText("30s");
        pointsTextView.setText("0/0");
        resultTextView.setText("");
        playAgainButton.setVisibility(View.INVISIBLE);
        generateQuestion();

        new CountDownTimer(30100, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                buttonLayout.setVisibility(View.VISIBLE);
                sum.setVisibility(View.VISIBLE);
                timerTextView.setText(String.valueOf(millisUntilFinished/1000) + "s");
            }

            @Override
            public void onFinish() {
                playAgainButton.setVisibility(View.VISIBLE);
                timerTextView.setText("0s");
                resultTextView.setText("Your score:" + percent + "%\n Questions:" + Integer.toString(score) + "/" + numberOfQuestions);
                buttonLayout.setVisibility(View.INVISIBLE);
                sum.setVisibility(View.INVISIBLE);

            }
        }.start();
    }

    public void generateQuestion() {
        Random rand = new Random();

        int a = rand.nextInt(21);
        int b = rand.nextInt(21);
        int incorrectAnswer;

        sum.setText(a + " + " + b);
        locationOfCorrectAnswer = rand.nextInt(4);

        answers.clear();

        for (int i=0; i<4;i++){

            if(i == locationOfCorrectAnswer){
                answers.add(a+b);
            }
            else{

                incorrectAnswer = rand.nextInt(a+b);
                while (incorrectAnswer == a+b) {
                    incorrectAnswer = rand.nextInt(a+b);
                }
                answers.add(incorrectAnswer);
            }
        }

        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));

    }



    public void start(View view) {

        new CountDownTimer(4000, 100){

            @Override
            public void onTick(long millisUntilFinished) {
                startButton.setText(String.valueOf(millisUntilFinished/1000));
                String go = startButton.getText().toString();
                if(go == "0"){
                    startButton.setText("Go!");
                }

            }

            @Override
            public void onFinish() {
                startButton.setVisibility(View.INVISIBLE);
                gameRelativeLayout.setVisibility(RelativeLayout.VISIBLE);
                playAgain(findViewById(R.id.playAgain));
            }
        }.start();
    }

    public void chooseAnswer(View view) {

        if (view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))) {
            score++;
            resultTextView.bringToFront();
            resultTextView.setText("Correct!");
            //resultTextView.setBackgroundColor(-16711936);

        } else {
            resultTextView.bringToFront();
            resultTextView.setText("Incorrect!");
            //resultTextView.setBackgroundColor(-65536);
        }
        numberOfQuestions++;
        pointsTextView.setText(Integer.toString(score) + "/" + numberOfQuestions);
        percent = Math.round((score/(float)numberOfQuestions)*100.0);             //get the percentage recieved
        generateQuestion();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition_acitivity);

        startButton = (Button) findViewById(R.id.goButton);
        sum = (TextView) findViewById(R.id.divTextView);
        resultTextView = (TextView) findViewById(R.id.resultTextView);
        pointsTextView = (TextView) findViewById(R.id.pointsTextView);
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        timerTextView = (TextView) findViewById(R.id.timerTextView);
        playAgainButton = (Button) findViewById(R.id.playAgain);
        gameRelativeLayout = (RelativeLayout) findViewById(R.id.gameRelativeLayout);
        buttonLayout = (GridLayout) findViewById(R.id.buttonLayout);


    }
}


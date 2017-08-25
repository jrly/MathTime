package com.example.jimmy.mathtime;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    Button addButton;
    Button subButton;
    Button multButton;
    Button divButton;

    public void addActivity(View view){
        Intent i = new Intent(getApplicationContext(), additionAcitivity.class);
        startActivity(i);
    }

    public void multActivity(View view){
        Intent i = new Intent(getApplicationContext(), multActivity.class);
        startActivity(i);
    }

    public void subActivity(View view){
        Intent i = new Intent(getApplicationContext(), subActivity.class);
        startActivity(i);
    }

    public void divActivity(View view){
        Intent i = new Intent(getApplicationContext(), divisionActivity.class);
        startActivity(i);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = (Button) findViewById(R.id.addButton);
        subButton = (Button) findViewById(R.id.subButton);
        multButton = (Button) findViewById(R.id.multButton);
        divButton = (Button) findViewById(R.id.divButton);



    }
}

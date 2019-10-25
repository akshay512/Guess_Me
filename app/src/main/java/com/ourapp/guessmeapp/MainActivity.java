package com.ourapp.guessmeapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button b1;
    int randomNumber;  //number to be generated randomly
    int guess;  //number user guessed
    String message; //message to display
    TextView msg; //textview to display message on screen
    public void generateRandomNumber() {

        Random r = new Random();  //declaring a random number generator

        randomNumber = r.nextInt(20) + 1;  //generating a random number where maximum value that can be generated is 20 and it starts fom zero so add 1 to get bound from 1 to 20

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.chk);
        msg = findViewById(R.id.msg); //textview from xml

        generateRandomNumber();// ge

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText num = (EditText) findViewById(R.id.gusssdnum);  //getting users text
                guess = Integer.parseInt(num.getText().toString());  //converting edit text value to int
                if(randomNumber == guess) {
                    message = "You guessed correct";
                    generateRandomNumber();  //generate random number again if he guessed correct
                }
                else if(randomNumber<guess){
                    message = guess+" is More";
                }
                else{
                    message = guess+" is Less";
                }
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();  //display toast message
                msg.setText(message);  //display text

            }
        });

    }
}


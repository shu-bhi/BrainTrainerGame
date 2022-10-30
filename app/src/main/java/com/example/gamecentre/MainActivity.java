package com.example.gamecentre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public void BrainGame(View view){
        Intent intent = new Intent(getApplicationContext(),nextPage.class);
        startActivity(intent);
    }

    //public void TicGame(View view){
        //Intent intent = new Intent(getApplicationContext(),tictactoe.class);
        //startActivity(intent);
  //  }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
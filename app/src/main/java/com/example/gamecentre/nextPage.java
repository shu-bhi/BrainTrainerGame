package com.example.gamecentre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class nextPage extends AppCompatActivity {
     ArrayList<Integer> answer=new ArrayList<Integer>();
     int locationofCorrectAnswer;
     TextView result;
     int score=0;
     int TotalQuess=0;
     TextView sumTv;
     TextView scoreTv;
     Button b1,b2,b3,b4;
     TextView timerTv;
     Button b5playagain;
     public  void playAgain(View view){
       score = 0;
       TotalQuess =0;
         scoreTv.setText(Integer.toString(score)+"/"+Integer.toString(TotalQuess));
       timerTv.setText("30");
       newQuestion();
       b5playagain.setVisibility(View.INVISIBLE);
         new CountDownTimer( 30100,1000){

             @Override
             public void onTick(long l) {
                 timerTv.setText(String.valueOf(l/1000)+"s");
             }

             @Override
             public void onFinish() {
                 result.setText("Done!");
                 b5playagain.setVisibility(View.VISIBLE);

             }
         }.start();

      }
     public void chooseAnswer(View view){
         if(Integer.toString(locationofCorrectAnswer).equals(view.getTag().toString())){
           result.setText("correct😎");
           score++;
         }else{
             result.setText("wrong😔");
         }
         TotalQuess++;
         scoreTv.setText(Integer.toString(score)+"/"+Integer.toString(TotalQuess));
         newQuestion();
     }

     public  void newQuestion(){
         Random rand = new Random();
         int a = rand.nextInt(100);
         int b = rand.nextInt(100);
         sumTv.setText(Integer.toString(a)+ " + "+ Integer.toString(b));
         locationofCorrectAnswer=rand.nextInt(4);
         answer.clear();
         for(int i =0;i<4;i++){
             if(i==locationofCorrectAnswer){
                 answer.add(a+b);
             }else{
                 int wrongAnswer=rand.nextInt(200);
                 while(wrongAnswer==a+b){
                     wrongAnswer=rand.nextInt(200);
                 }
                 answer.add(wrongAnswer);
             }
         }
         b1.setText(Integer.toString(answer.get(0)));
         b2.setText(Integer.toString(answer.get(1)));
         b3.setText(Integer.toString(answer.get(2)));
         b4.setText(Integer.toString(answer.get(3)));
     }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_page);
         b1 =findViewById(R.id.button1);
         b2 =findViewById(R.id.button2);
         b3 =findViewById(R.id.button3);
         b4 =findViewById(R.id.button4);
         sumTv = findViewById(R.id.quesTv);
         result = findViewById(R.id.textViewResult);
         timerTv = findViewById(R.id.textViewTimer);
         scoreTv=findViewById(R.id.textViewscore);
         b5playagain =findViewById(R.id.buttonplayAgain);
        playAgain(findViewById(R.id.textViewTimer));
    }
}
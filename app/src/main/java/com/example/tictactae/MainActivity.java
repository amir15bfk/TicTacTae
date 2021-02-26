package com.example.tictactae;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //1 : X  2 :O
    private int player ,player1Score=0 ,player2Score=0,counter;

    private Button but [][]= new Button[3][3];
    private ImageView X,O,ImageOfResult;
    Random rand = new Random();
    private int arena[][]={
            {0,0,0},
            {0,0,0},
            {0,0,0}
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        but[0][0] = findViewById(R.id.B00);
        but[0][1] = findViewById(R.id.B01);
        but[0][2] = findViewById(R.id.B02);
        but[1][0] = findViewById(R.id.B10);
        but[1][1] = findViewById(R.id.B11);
        but[1][2] = findViewById(R.id.B12);
        but[2][0] = findViewById(R.id.B20);
        but[2][1] = findViewById(R.id.B21);
        but[2][2] = findViewById(R.id.B22);

        startGame();

    }
    private void startGame(){
        arena=new int [][]{
            {0,0,0},
            {0,0,0},
            {0,0,0}
        };
        counter= 0;
        for (Button[] innerArray: but) {
            // second for...each loop access each element inside the row
            for(Button data: innerArray) {
                data.setBackgroundColor(Color.parseColor("#00ffffff"));
                data.setEnabled(true);
            }
        }
        player=rand.nextInt(2)+1;
        X=findViewById(R.id.X);
        O=findViewById(R.id.O);
        if (player==1 ){

            X.setVisibility(View.VISIBLE);
            O.setVisibility(View.INVISIBLE);

        }else {
            X.setVisibility(View.INVISIBLE);
            O.setVisibility(View.VISIBLE);

        }



    }
    private void updateTheResult(){

            TextView TheResult= (TextView) findViewById(R.id.theresult);
            TextView OScore= (TextView) findViewById(R.id.oscore);
            TextView XScore= (TextView) findViewById(R.id.xscore);
            TheResult.setText("O "+player2Score+" - "+player1Score+" X");
            OScore.setText( ""+player2Score);
            XScore.setText(""+player1Score);


    }
    private int YouWan(){
        int win=0;
        for (int i= 0 ; i<3;i++){
            if (arena[i][0]==player && arena[i][1]==player && arena[i][2]==player)
                win=i+1;
            if (arena[0][i]==player && arena[1][i]==player && arena[2][i]==player)
                win=i+4;

        }
        if (arena[0][0]==player && arena[1][1]==player && arena[2][2]==player)
            win=8;
        if (arena[2][0]==player && arena[1][1]==player && arena[0][2]==player)
            win=9;
        return win;
    }
    public void ClickB00(View v){
        play(0,0);

    }
    public void ClickB01(View v){
        play(0,1);

    }
    public void ClickB02(View v){
        play(0,2);

    }
    public void ClickB10(View v){
        play(1,0);

    }
    public void ClickB11(View v){
        play(1,1);

    }
    public void ClickB12(View v){
        play(1,2);

    }
    public void ClickB20(View v){
        play(2,0);

    }
    public void ClickB21(View v){
        play(2,1);

    }
    public void ClickB22(View v){
        play(2,2);

    }
    private void play(int i ,int j){
        but[i][j].setEnabled(false);
        if (player == 1){
            but[i][j].setBackgroundResource(R.drawable.close);
            arena[i][j]= 1;

        }else {
            but[i][j].setBackgroundResource(R.drawable.circle_ring);
            arena[i][j]= 2;

        }
        counter++;
        int result = YouWan();
        if (result>0){
           /* if (result<4){

                but[result][0].setBackgroundTintList(ColorStateList.valueOf(R.id.green));

            }*/
           ImageOfResult = findViewById(R.id.result) ;
           ImageOfResult.setVisibility(View.VISIBLE);
           if (player== 1) {
               ImageOfResult.setBackgroundResource(R.drawable.close);
               player1Score++;
           }
           else {ImageOfResult.setBackgroundResource(R.drawable.circle_ring);
           player2Score++;
           }
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after 5s = 5000ms
                    ImageOfResult.setVisibility(View.INVISIBLE);
                    startGame();
                }
            }, 2000);
            updateTheResult();
            for (Button[] innerArray: but) {
                // second for...each loop access each element inside the row
                for(Button data: innerArray) {

                    data.setEnabled(false);
                }
            }



        }else if (counter==9) {
            ImageOfResult = findViewById(R.id.resultisdraw) ;
            ImageOfResult.setVisibility(View.VISIBLE);
            ImageOfResult.setBackgroundResource(R.drawable.draw);
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after 5s = 5000ms
                    ImageOfResult.setVisibility(View.INVISIBLE);
                    startGame();
                }
            }, 2000);
            for (Button[] innerArray: but) {
                // second for...each loop access each element inside the row
                for(Button data: innerArray) {

                    data.setEnabled(false);
                }
            }



        }else {
            if (player==2 ){
                player=1;
                X.setVisibility(View.VISIBLE);
                O.setVisibility(View.INVISIBLE);

            }else {
                player = 2;
                X.setVisibility(View.INVISIBLE);
                O.setVisibility(View.VISIBLE);

            }
        }

    }

}
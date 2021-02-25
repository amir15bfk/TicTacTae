package com.example.tictactae;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int player ;
    private Button but [][]= new Button[3][3];
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
        for (Button[] innerArray: but) {
            // second for...each loop access each element inside the row
            for(Button data: innerArray) {
                data.setEnabled(true);
            }
        }
        player=rand.nextInt(2)+1;
        


    }
}
package com.riyachaudhari.firstproject.tictactoe_game;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView turn, score_x, score_o, playernamex, playernameo;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;
    int scorex, scoreo;
    int player_x=0;
    int player_o=1;
    int count=9;
    int activeplayer= player_x;
    int[] filled= {-1,-1,-1,-1,-1,-1,-1,-1,-1};
    Boolean gameactive= true;
    String namex, nameo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         namex= getIntent().getExtras().getString("pnamex").toString();
         nameo=getIntent().getExtras().getString("pnameo").toString();

        initializeview();
        playernamex.setText(namex);
        playernameo.setText(nameo);

    }

    private void initializeview() {

        score_x= findViewById(R.id.score_x);
        score_o= findViewById(R.id.score_o);
        turn= findViewById(R.id.turn);
        playernamex= findViewById(R.id.playernamex);
        playernameo= findViewById(R.id.playernameo);

        btn0= findViewById(R.id.btn0);
        btn1= findViewById(R.id.btn1);
        btn2= findViewById(R.id.btn2);
        btn3= findViewById(R.id.btn3);
        btn4= findViewById(R.id.btn4);
        btn5= findViewById(R.id.btn5);
        btn6= findViewById(R.id.btn6);
        btn7= findViewById(R.id.btn7);
        btn8= findViewById(R.id.btn8);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

         Button btn= findViewById(v.getId());
         int tag= Integer.parseInt(btn.getTag().toString());

         if(filled[tag]!=-1)
         {
             return;
         }
         if(!gameactive)
         {
             return;
         }

         if(activeplayer==player_x)
         {
             count--;
             btn.setText("X");
             activeplayer=player_o;
             filled[tag]=player_x;
             turn.setText("O Turn");
             btn.setBackground(getDrawable(R.color.playerx));

         }
         else
         {
             count--;
             btn.setText("O");
             activeplayer=player_x;
             filled[tag]=player_o;
             turn.setText("X Turn");
             btn.setBackground(getDrawable(R.color.playero));

         }
         checkwin();

         if(count==0){
             pop_up("Game Tie","No player wins the Game");
         }

    }

    private void checkwin() {

        int[][] wins={ {0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6} };

        for(int i=0; i<8; i++)
        {
             int x=wins[i][0];
             int y=wins[i][1];
             int z=wins[i][2];

             if(filled[x]==filled[y] && filled[y]==filled[z] && filled[x]==player_x)
             {
                 pop_up("Congratulations",namex+" wins the Game");
                 gameactive=false;
                 scorex++;
                 score_x.setText(""+scorex);
             }

             if(filled[x]==filled[y] && filled[y]==filled[z] && filled[x]==player_o)
             {
                 pop_up("Congratulations", nameo+" wins the Game");
                 gameactive=false;
                 scoreo++;
                 score_o.setText(""+scoreo);
             }
        }
    }

    public void pop_up(String title, String message){
        AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        resetgame();
                    }
                }).create().show();
    }



    private void resetgame() {

        count=9;
        activeplayer= player_x;
        filled= new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1};
        gameactive= true;

        btn0.setText("");
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");

        btn0.setBackground(getDrawable(R.color.grey));
        btn1.setBackground(getDrawable(R.color.grey));
        btn2.setBackground(getDrawable(R.color.grey));
        btn3.setBackground(getDrawable(R.color.grey));
        btn4.setBackground(getDrawable(R.color.grey));
        btn5.setBackground(getDrawable(R.color.grey));
        btn6.setBackground(getDrawable(R.color.grey));
        btn7.setBackground(getDrawable(R.color.grey));
        btn8.setBackground(getDrawable(R.color.grey));

    }


}


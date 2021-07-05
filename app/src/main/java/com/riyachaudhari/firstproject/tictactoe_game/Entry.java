package com.riyachaudhari.firstproject.tictactoe_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Entry extends AppCompatActivity {

    EditText playerx, playero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);

        playerx= findViewById(R.id.etplayerx);
        playero= findViewById(R.id.etplayero);
    }

    public void goNext(View view) {
        //intent

        if (TextUtils.isEmpty(playerx.getText().toString())) {

            Toast.makeText(Entry.this, "Player 1 name is empty", Toast.LENGTH_SHORT).show();
            return;

        } else if(TextUtils.isEmpty(playero.getText().toString())) {
            Toast.makeText(Entry.this, "Player 2 name is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        else{

            Intent intent = new Intent(Entry.this, MainActivity.class);
            intent.putExtra("pnamex", playerx.getText().toString());
            intent.putExtra("pnameo", playero.getText().toString());
            startActivity(intent);

        }

    }
}
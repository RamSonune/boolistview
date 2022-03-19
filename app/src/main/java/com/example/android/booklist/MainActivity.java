package com.example.android.booklist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView booksMain ;
    CardView cardView1;
    TextView welcomeText;
    CardView NovelCv;
    CardView CyberCv ;
    CardView MotivationalCv;
    CardView MoneyCv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        booksMain = findViewById(R.id.booksMain);
        cardView1 = findViewById(R.id.firstCard);
        welcomeText = findViewById(R.id.UserInMain);
        NovelCv = findViewById(R.id.NovelCV);
        CyberCv = findViewById(R.id.CyberCV);
        MotivationalCv = findViewById(R.id.MotivationalCV);
        MoneyCv = findViewById(R.id.MoneyCV);


        Intent intent = this.getIntent();
        if (intent!=null){
            String welcome = intent.getStringExtra("userName");
            welcomeText.setText(welcome);
        }

//        booksMain.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent booksInt = new Intent(MainActivity.this,BooksList.class);
//                startActivity(booksInt);
//            }
//        });

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent booksInt = new Intent(MainActivity.this,BooksList.class);
                startActivity(booksInt);
            }
        });

        // openging the novel card view
        NovelCv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent novelInt = new Intent(MainActivity.this, Novels.class);
                startActivity(novelInt);
            }
        });

        CyberCv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent CyberInt = new Intent(MainActivity.this,Cyber.class);
                startActivity(CyberInt);
            }
        });

        MotivationalCv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MotivationInt = new Intent(MainActivity.this,Motivational.class);
                startActivity(MotivationInt);
            }
        });

        MoneyCv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MoneyInt = new Intent(MainActivity.this,Money.class);
                startActivity(MoneyInt);
            }
        });
    }
}
package com.example.android.booklist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BookSIngle extends AppCompatActivity {
    ImageView bookSingle ;
    TextView description ;
    Button viewInt ;
    Button downloadInt ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_single);
        bookSingle = findViewById(R.id.bookSingle);
        description = findViewById(R.id.DescriptionFull);
        viewInt = findViewById(R.id.viewInt);
        downloadInt = findViewById(R.id.downInt);

        Intent intent = this.getIntent();
        if (intent!=null){
            int bookImagesSingle =intent.getIntExtra("bookImage" , R.drawable.android);
            bookSingle.setImageResource(bookImagesSingle);

            String urlInt = intent.getStringExtra("url");

            viewInt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(BookSIngle.this, "Loading..." , Toast.LENGTH_SHORT).show();
                    Intent goToView = new Intent(BookSIngle.this,ViewOnline.class);
                    goToView.putExtra("urlView" , urlInt);
                    startActivity(goToView);
                }
            });

            downloadInt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goToTheUrl(urlInt);
                }
            });






        }

    }
    private void goToTheUrl(String url ){
        Uri uri = Uri.parse(url);
        startActivity(new Intent(Intent.ACTION_VIEW , uri));

    }
}


//    String bookDes = String.valueOf(intent.getIntExtra("des" , R.string.bookdes1));
//            description.setText(bookDes);
//
//            int book = intent.getIntExtra("des" , R.string.bookdes1);
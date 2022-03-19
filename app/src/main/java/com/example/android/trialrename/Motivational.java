package com.example.android.trialrename;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Motivational extends AppCompatActivity {
    ListView listViewMotivation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motivational);

        listViewMotivation = findViewById(R.id.listViewMotivation);

        String [] bookNameMotiv = {"Wings of Fire" , "The Miracle Morning" ,"Ikigai","I am Malala","The Monk Who Sold His Ferrari","Think Like a Monk","Seven Habits of Highly Successfull" +
                "People" , "12 Rules For Life"};
        String [] authorMotiv = {"APJ","Miracle","japanese","mala","Robin Sharma" ,"Jay Shetty","Stephen Covey","Jordan Peterson"};
        String [] urlMotiv = {"https://firebasestorage.googleapis.com/v0/b/fir-71644.appspot.com/o/Wings%20of%20fire.pdf?alt=media&token=aeee422b-490c-45b0-b8f4-cdd9c750cdf2" ,
        "https://firebasestorage.googleapis.com/v0/b/fir-71644.appspot.com/o/The%20Miracle%20Morning.pdf?alt=media&token=2ba21a98-4821-4e7b-81be-1ca477f67dbb" ,
        "https://firebasestorage.googleapis.com/v0/b/fir-71644.appspot.com/o/Ikigai.pdf?alt=media&token=432bba9b-b54a-4d43-8871-ce37c28e903a" ,

        "https://firebasestorage.googleapis.com/v0/b/fir-71644.appspot.com/o/I%20am%20Malala.pdf?alt=media&token=c15328f4-c598-4b95-91f6-0ce07f78f83c",
        "https://firebasestorage.googleapis.com/v0/b/fir-71644.appspot.com/o/The%20Monk%20Who%20Sold.pdf?alt=media&token=d70b82c5-fa5e-4c54-aeb8-cacfdf6f15ab",
        "https://firebasestorage.googleapis.com/v0/b/fir-71644.appspot.com/o/jayshetty.pdf?alt=media&token=d7f253fc-edf9-49c4-8747-251cd9644408",

        "https://firebasestorage.googleapis.com/v0/b/fir-71644.appspot.com/o/seven%20habits.pdf?alt=media&token=23efbefc-ea79-4b10-94c1-880395c8ff00",
        "https://firebasestorage.googleapis.com/v0/b/fir-71644.appspot.com/o/12-Rules-for-Life.pdf?alt=media&token=634ad618-f678-4182-8f66-de81daa64139"};
        int [] bookImageMotiv = {R.drawable.apjabdulji , R.drawable.miracle,R.drawable.ikigai,R.drawable.malala,R.drawable.monkrobin,R.drawable.thinklikemonk , R.drawable.sevenhabits,R.drawable.twelverule};

        ArrayList<BookCustom> arrayListMotiv = new ArrayList<>();

        for (int i =0 ; i< bookImageMotiv.length; i++){
            BookCustom bookCustomMotiv = new BookCustom(bookNameMotiv[i], authorMotiv[i] , urlMotiv[i] , bookImageMotiv[i] );
            arrayListMotiv.add(bookCustomMotiv);
        }

        BookAdapter adapterMotiv = new BookAdapter(this,arrayListMotiv);

        listViewMotivation.setAdapter(adapterMotiv);

        listViewMotivation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent MotivList = new Intent(Motivational.this, BookSIngle.class);
                MotivList.putExtra("bookImage" , bookImageMotiv[position]);
                MotivList.putExtra("url" ,urlMotiv[position]);
                startActivity(MotivList);
            }
        });
    }
}
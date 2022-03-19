package com.example.android.trialrename;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Cyber extends AppCompatActivity {
    ListView listViewCyber ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cyber);

        listViewCyber = findViewById(R.id.listViewCyber);

        String [] bookNameCyber = {"Computer Network" , "Linux : The Complete Reference" , "Computer Communication and Networking" , "Linux Basics for Hackers" , "CEH","The Internet" +
                "Book" };
        String [] authorCyber = {"Tanenbaum" , "Richard Petersen" , "Springer" , "OccupyTheWeb" ,"Kimberley Graves" , "Doughlas Comer"};
        int [] ImageBookCyber = {R.drawable.computernettanen , R.drawable.linuxcomplete , R.drawable.computernetspringer , R.drawable.linuxhackes ,R.drawable.ceh11, R.drawable.theinternetbook};
        String [] urlCyber = {"https://firebasestorage.googleapis.com/v0/b/fir-71644.appspot.com/o/Computer%20networks.pdf?alt=media&token=300405b5-ab22-47dd-ab4e-a4bb67059dfe" ,
        "https://firebasestorage.googleapis.com/v0/b/fir-71644.appspot.com/o/Linux%20-%20The%20Complete%20Reference.pdf?alt=media&token=57905c23-57f4-4606-84da-c8a2c46ad72c" ,
        "https://firebasestorage.googleapis.com/v0/b/fir-71644.appspot.com/o/Computer%20Communication%2C%20Networking.pdf?alt=media&token=d32b5ca5-2ef2-4695-bf27-a296058c8c62",

        "https://firebasestorage.googleapis.com/v0/b/fir-71644.appspot.com/o/Linux%20Basics%20for%20Hackers.pdf?alt=media&token=19b1da3c-89d7-41dc-86e3-09e7ea42ca34",
        "https://firebasestorage.googleapis.com/v0/b/fir-71644.appspot.com/o/CEHKimberley.pdf?alt=media&token=63c9cac1-983e-447f-8bbc-7bcc568c9eab",
        "https://firebasestorage.googleapis.com/v0/b/fir-71644.appspot.com/o/The%20Internet%20Book.pdf?alt=media&token=16583457-9ff8-4780-9092-0453a9b02129"};

        ArrayList<BookCustom> arrayListCyber = new ArrayList<>();

        for ( int i =0; i<bookNameCyber.length ; i++){
            BookCustom bookCustomCyber = new BookCustom(bookNameCyber[i],authorCyber[i],urlCyber[i], ImageBookCyber[i]);
            arrayListCyber.add(bookCustomCyber);
        }

        BookAdapter bookAdapterCyber = new BookAdapter(this, arrayListCyber);

        listViewCyber.setAdapter(bookAdapterCyber);

        listViewCyber.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent CyberList = new Intent(Cyber.this , BookSIngle.class);
                CyberList.putExtra("bookImage" ,ImageBookCyber[position]);
                CyberList.putExtra("url" , urlCyber[position]);
                startActivity(CyberList);
            }
        });




    }
}
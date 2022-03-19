package com.example.android.booklist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Money extends AppCompatActivity {
    ListView listViewMoney ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money);

        listViewMoney = findViewById(R.id.listViewMoney);

        String [] bookNameMoney = {"The Richest Man in Babylon","The Psychology of Money","Rich Dad Poor Dad","Think and Grow Rich","Learn to Earn"};
        String [] authorMoney = {"George Samuel Clason","Morgan Housel","Robert Kiyosaki","Napoleon Hill","Peter Lynch"};
        String [] urlMoney = {"https://firebasestorage.googleapis.com/v0/b/fir-71644.appspot.com/o/Clason-RichestManInBabylon.pdf?alt=media&token=eb5164b4-c3b2-4dc0-b1c0-7fe58e49abf2",
        "https://firebasestorage.googleapis.com/v0/b/fir-71644.appspot.com/o/PsychologyOfMoney.pdf?alt=media&token=81ae4ca8-e727-48cf-9266-6c705a1e35f0",
        "https://firebasestorage.googleapis.com/v0/b/fir-71644.appspot.com/o/Rich%20Dad%20Poor%20Dad.pdf?alt=media&token=e6942a35-f3a1-469a-ba13-1fe64736621c",

        "https://firebasestorage.googleapis.com/v0/b/fir-71644.appspot.com/o/Think%20And%20Grow%20Rich.pdf?alt=media&token=b84f7fb5-08c2-4908-bbe8-ba6d7bc9ba8c",
        "https://firebasestorage.googleapis.com/v0/b/fir-71644.appspot.com/o/learn%20to%20earn.pdf?alt=media&token=c52c3269-7be5-43ee-8cb0-324e1cdf13f9"};
        int [] imageBookMoney = {R.drawable.richestbabylon,R.drawable.psychomoney,R.drawable.richdpoord,R.drawable.thinkandgrow,R.drawable.learntolearn};

        ArrayList<BookCustom> arrayListMoney = new ArrayList<>();

        for (int i =0; i<bookNameMoney.length;i++){
            BookCustom customMoney = new BookCustom(bookNameMoney[i] ,authorMoney[i],urlMoney[i],imageBookMoney[i]);
            arrayListMoney.add(customMoney);
        }

        BookAdapter adapterMoney = new BookAdapter(this,arrayListMoney);

        listViewMoney.setAdapter(adapterMoney);

        listViewMoney.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent MoneyList = new Intent(Money.this, BookSIngle.class);
                MoneyList.putExtra("bookImage" , imageBookMoney[position]);
                MoneyList.putExtra("url",urlMoney[position]);
                startActivity(MoneyList);
            }
        });
    }
}
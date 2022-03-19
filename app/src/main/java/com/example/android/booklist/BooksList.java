package com.example.android.booklist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class BooksList extends AppCompatActivity {
    ListView listView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_list);

        listView = findViewById(R.id.listView);

        String[] bookName = {"C++", "Data Analysis from the Scratch with Python", "Head First Android Development" ,   "Head First Python", "JavaScript" ,"Learn Programming with C",
                "Machine Learning","Python Programming For Beginners"};
        String[] authorName = {"MALINI DEVI J", "Peters Morgan", "Dawn Griffiths and David Griffiths",   "Paul Barry","Stephen BlueMenthal","Noel Kalicharan" ,"Rudolph Russel","Adam Stewart"};
        // there is some problem with the images in this progject , the source of the problem is not found yet , after pasting the assets of the miwok also the photo did not appeared ..
        // heading towards the creation of the same project to assure that the images are properly downloaded .
        int[] bookImages = {R.drawable.cpp, R.drawable.datasci, R.drawable.android ,    R.drawable.pylogo ,R.drawable.js,R.drawable.c, R.drawable.machine,R.drawable.pylogo};

        int[] del = {R.string.bookdes0 , R.string.bookdes1 , R.string.bookdes2 , R.string.bookdes3 , R.string.bookdes4 , R.string.bookdes5 , R.string.bookdes6 , R.string.bookdes7
                , R.string.bookdes8 };

        String[] url = {"https://firebasestorage.googleapis.com/v0/b/fir-71644.appspot.com/o/C%2B%2B%20Programming%20Language.pdf?alt=media&token=0ea579ea-826b-4b85-b340-2558f6df52f6",
        "https://firebasestorage.googleapis.com/v0/b/fir-71644.appspot.com/o/Data%20Analysis%20From%20Scratch%20With%20Python.pdf?alt=media&token=727f103f-3a2b-4c40-ade1-9e45f6be1cab",
                "https://firebasestorage.googleapis.com/v0/b/fir-71644.appspot.com/o/Head%20First%20Android%20Development_%20A%20Brain-Friendly%20Guide%20(%20PDFDrive%20).pdf?alt=media&token=08b4681a-c0b0-4e06-b866-c3958599ef27",

        "https://firebasestorage.googleapis.com/v0/b/fir-71644.appspot.com/o/Head%20First%20PythonC.pdf.pdf?alt=media&token=3ed87f2d-9493-4464-9771-ba58e81d85c0",
        "https://firebasestorage.googleapis.com/v0/b/fir-71644.appspot.com/o/JavaScript_%20JavaScript%20For%20Beginners.pdf?alt=media&token=840cf18e-10a9-4ed6-b4b4-f6613841875b",
        "https://firebasestorage.googleapis.com/v0/b/fir-71644.appspot.com/o/Learn%20to%20Program%20with%20C.pdf?alt=media&token=69d694d5-668f-44e3-9f2a-14364f74de6b",

        "https://firebasestorage.googleapis.com/v0/b/fir-71644.appspot.com/o/Machine%20Learning_%20Step-by-Step.pdf?alt=media&token=a21c9d7c-b373-434f-b949-b8f0fd9814f4",
        "https://firebasestorage.googleapis.com/v0/b/fir-71644.appspot.com/o/Python%20Programming.pdf?alt=media&token=0e5024c1-94ef-4cf6-9b31-fdcc0262465c"};


        ArrayList<BookCustom> customArrayList = new ArrayList<>();

        for(int i =0; i<bookName.length ; i++){
            BookCustom bookCustom = new BookCustom(bookName[i] ,authorName [i] ,url[i] ,bookImages[i] , del[i]);
            customArrayList.add(bookCustom);
        }

        BookAdapter adapter = new BookAdapter(this , customArrayList);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent singleBook = new Intent(BooksList.this,BookSIngle.class);
                singleBook.putExtra("bookImage" , bookImages[position]);
                singleBook.putExtra("des" , del[position]);
                singleBook.putExtra("url" , url[position]);
                startActivity(singleBook);
            }
        });



    }
}





//,R.drawable.pylogo ,R.drawable.js,R.drawable.c,R.drawable.java,R.drawable.machine,R.drawable.pylogo};
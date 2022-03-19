package com.example.android.booklist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Novels extends AppCompatActivity {

    ListView listViewNov ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novels);

        listViewNov = findViewById(R.id.listViewNovel);

        String [] bookNameNov = {"The Girl in Room 105" ,"Half Girlfriend" ,"Fault in our stars" , "The Palace of Illusions" , "Living in the Light"};
        String [] authorNameNov = {"Chetan Bhagat","Chetan Bhagat","John Green","Chitra Lekha" ,"Shakti Gawain"};
        String [] urlNov = {"https://firebasestorage.googleapis.com/v0/b/fir-71644.appspot.com/o/The%20girl%20in%20room%20105.pdf?alt=media&token=f7f9da46-f552-48b5-a248-b76a091c6f60",
                "https://firebasestorage.googleapis.com/v0/b/fir-71644.appspot.com/o/Half%20Girlfriend.pdf?alt=media&token=5ea64ef9-ec15-44be-a75c-6336b80b72d8" ,
                "https://firebasestorage.googleapis.com/v0/b/fir-71644.appspot.com/o/fault.pdf?alt=media&token=f7458785-c4cc-4420-b33f-e6f7251cfbe6",

        "https://firebasestorage.googleapis.com/v0/b/fir-71644.appspot.com/o/The%20Palace%20of%20Illusions.pdf?alt=media&token=f55269be-d01a-4de6-b161-23a7dbe9dcf1",
        "https://firebasestorage.googleapis.com/v0/b/fir-71644.appspot.com/o/Living%20in%20the%20Light_%20A%20guide%20to%20personal%20transformation%20(%20PDFDrive%20).pdf?alt=media&token=6c9f5fbc-6f86-41f0-9bb9-172a94011d5d"};
        int [] ImagesNov = {R.drawable.roomonefive , R.drawable.halfgf , R.drawable.faultstars , R.drawable.thepalace , R.drawable.livlight};

        ArrayList<BookCustom> arrayListNov = new ArrayList<>();

        for (int i =0 ; i<bookNameNov.length; i++){
            BookCustom bookCustomNov  = new BookCustom(bookNameNov[i] , authorNameNov[i],urlNov[i] ,ImagesNov[i]);
            arrayListNov.add(bookCustomNov);
        }

        BookAdapter NovelAdapter = new BookAdapter(this, arrayListNov);


        listViewNov.setAdapter(NovelAdapter);

//        singleBook.putExtra("bookImage" , bookImages[position]);
//        singleBook.putExtra("des" , del[position]);
//        singleBook.putExtra("url" , url[position]);

        listViewNov.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent Novelist = new Intent(Novels.this , BookSIngle.class);
                // seding the intent with the wrong name , and it is supposed to be send with the common name as that of the Boolist
                // if the key name of the sending data is not catched in the BookSigle class then the default photo is taken
                Novelist.putExtra("bookImage" , ImagesNov[position]);
                Novelist.putExtra("url" , urlNov[position]);
                startActivity(Novelist);
            }
        });


    }
}
// does u also think that money management is difficult for you , getting financial stable in life but have no idea about it , then come here and become financially wise
// with the greater use of the technology the vulnerabilities in this tech has also increased which are exploited by the Cyber criminals , so  are you ready to defeat those cyber
// criminals by becoming a cyber warrior / defender .. well the training ground is over here !!!
package com.example.android.trialrename;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class BookAdapter extends ArrayAdapter<BookCustom> {
    public BookAdapter(@NonNull Context context, ArrayList <BookCustom> bookCustomArrayList) {
        super(context, 0 , bookCustomArrayList);
    }

    TextView bookNameAdapter;
    TextView authorNameAdapter;
    ImageView bookPicAdapter;


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listBook = convertView;
        if (convertView == null){
            listBook = LayoutInflater.from(getContext()).inflate(R.layout.list_child , parent , false);
        }

        BookCustom bookCustom = getItem(position);

        bookNameAdapter = listBook.findViewById(R.id.bookName);
        bookNameAdapter.setText(bookCustom.getBookName());

        authorNameAdapter = listBook.findViewById(R.id.authorName);
        authorNameAdapter.setText(bookCustom.getAuthorName());

        bookPicAdapter = listBook.findViewById(R.id.bookPic);
        bookPicAdapter.setImageResource(bookCustom.getImageBook());


        return listBook;
    }
}

package com.example.android.booklist;

public class BookCustom {
    private String bookName ;
    private String authorName ;
    private String url ;
    private int ImageBook ;
    private String description ;
    private int BookDes ;


    public BookCustom(String bookName , String authorName , String url , int ImageBook ,int Bookdes ){
        this.bookName = bookName ;
        this.authorName =  authorName ;
        this.url = url ;
        this.ImageBook = ImageBook ;
        this.BookDes = Bookdes;



    }

    public BookCustom(String bookName , String authorName , String url , int ImageBook){
        this.bookName = bookName ;
        this.authorName =  authorName ;
        this.url = url ;
        this.ImageBook = ImageBook ;




    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getImageBook() {
        return ImageBook;
    }
}

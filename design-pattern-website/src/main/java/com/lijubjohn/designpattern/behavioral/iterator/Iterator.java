package com.lijubjohn.designpattern.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liju on 8/29/16.
 */
public class Iterator {
}

//simple book interface
interface Book {
    void printName();//print name of the book
}
//book implementation
class BookImpl implements Book {
    String bookName;
    public BookImpl(String bookName) {
        this.bookName = bookName;
    }
    @Override
    public void printName() {
        System.out.println(bookName);
    }
}
//Book collection
interface BookCollection {
    void addBook(Book book);

    void removeBook(Book book);

    BookIterator bookIterator();
}
// Book collection implementation
class BookCollectionImpl implements BookCollection {
    private List<Book> books = new ArrayList<>();

    @Override
    public void addBook(Book book) {
        books.add(book);
    }
    @Override
    public void removeBook(Book book) {
        books.remove(book);
    }
    @Override
    public BookIterator bookIterator() {
        return new BookIteratorImpl(books);
    }
}
//Book iterator interface
interface BookIterator {
    boolean hasNext();
    Book next();
}
//Book iterator implementation
class BookIteratorImpl implements BookIterator {
    private List<Book> books;
    private int position;

    public BookIteratorImpl(List<Book> books) {
        this.books = books;
        this.position = 0;
    }
    @Override
    public boolean hasNext() {
        return books.size() > position;
    }
    @Override
    public Book next() {
        return books.get(position++);
    }
}
//Client class
class Client {
    public static void main(String[] args) {
        BookCollection bookCollection = new BookCollectionImpl();
        bookCollection.addBook(new BookImpl("Book A"));
        bookCollection.addBook(new BookImpl("Book B"));
        //uses book iterator
        final BookIterator bookIterator = bookCollection.bookIterator();
        while (bookIterator.hasNext()){
            bookIterator.next().printName();
        }
    }
}
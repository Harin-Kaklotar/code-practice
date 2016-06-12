package privateClassData;

/**
 * Created by liju on 6/10/16.
 */
public class Book {
    private String author;
    private int year;
    private String genre;

    public Book(String author, int year, String genre) {
        this.author = author;
        this.year = year;
        this.genre = genre;

    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }
}

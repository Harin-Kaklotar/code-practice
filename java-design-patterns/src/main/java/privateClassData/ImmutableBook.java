package privateClassData;

/**
 * Created by liju on 6/10/16.
 */
public class ImmutableBook {
    private  Book book;

    public ImmutableBook(String author, int year, String genre){
        book = new Book(author,year,genre);


    }

    public String getInfo(){
        return "ImmutableBook{" +
            "book=" + book +
            '}';

    }

    public String getDesciption(){
        //TODO - why book methods are not accessible here?

        return null;
    }


}

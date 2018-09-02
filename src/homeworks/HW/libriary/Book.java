package homeworks.HW.libriary;

/**
 * Created by nazar123 on 10.12.2017.
 */
public class Book {
    // * 1) Создать класс Книга
    private int id; // how to initialize int?
    private String nameOfBook = "";
    private String author = "";
    //нужно ли ето поле здесь?
    private Genre genre;

    public String getNameOfBook() {
        return nameOfBook;
    }

    public void setNameOfBook(String nameOfBook) {
        this.nameOfBook = nameOfBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id + " " + nameOfBook + " " + author;
    }

    public Book(int id, String nameOfBook, String author ) {
        this.id = id;
        this.nameOfBook = nameOfBook;
        this.author = author;
    }
}

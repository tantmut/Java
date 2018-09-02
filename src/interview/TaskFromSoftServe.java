package interview;

/**
 * Created by nazar on 4/2/2017.
 */
public class TaskFromSoftServe {

    public void processing(Book book) {
//        do something with book
    }

    public void processing(Article article) {
//        do something with article

//        Заменить параметры на класс interview.Reference, предложить рефакторинг
    }

    public static void main(String[] args) {
        TaskFromSoftServe serve = new TaskFromSoftServe();
        Book book = new Book("Author1", "Author2",
                "Author3", "Author4", true, 1985, 12, 56, "interview.Book");

        serve.processing(book);
    }

}
/*
* 1) Логическая связь
* 2) Общие параметры
* */

class Reference {
    private String author1;
    private String author2;
    private String author3;
    private String author4;
    private Boolean isUpdated;
    private int year;
    private int volume;

    public Reference(String author1, String author2, String author3,
                     String author4, Boolean isUpdated, int year, int volume) {
        this.author1 = author1;
        this.author2 = author2;
        this.author3 = author3;
        this.author4 = author4;
        this.isUpdated = isUpdated;
        this.year = year;
        this.volume = volume;
    }

    public String getAuthor1() {
        return author1;
    }

    public void setAuthor1(String author1) {
        this.author1 = author1;
    }

    public String getAuthor2() {
        return author2;
    }

    public void setAuthor2(String author2) {
        this.author2 = author2;
    }

    public String getAuthor3() {
        return author3;
    }

    public void setAuthor3(String author3) {
        this.author3 = author3;
    }

    public String getAuthor4() {
        return author4;
    }

    public void setAuthor4(String author4) {
        this.author4 = author4;
    }

    public Boolean getUpdated() {
        return isUpdated;
    }

    public void setUpdated(Boolean updated) {
        isUpdated = updated;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}

class Book extends Reference {
    private int countOfpages;
    private String nameBook;

    public Book(String author1, String author2, String author3,
                String author4, Boolean isUpdated, int year, int volume,
                int countOfpages, String nameBook) {
        super(author1, author2, author3, author4, isUpdated, year, volume);
        this.countOfpages = countOfpages;
        this.nameBook = nameBook;
    }

    public int getCountOfpages() {
        return countOfpages;
    }

    public void setCountOfpages(int countOfpages) {
        this.countOfpages = countOfpages;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }
}

class Article extends Reference {
    private String nameArticle;

    public Article(String author1, String author2, String author3,
                   String author4, Boolean isUpdated, int year, int volume, String nameArticle) {
        super(author1, author2, author3, author4, isUpdated, year, volume);
        this.nameArticle = nameArticle;
    }
}
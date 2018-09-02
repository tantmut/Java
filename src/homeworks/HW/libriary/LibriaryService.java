package homeworks.HW.libriary;

import java.time.LocalTime;
import java.util.*;

/*
 * 1) Создать класс Книга
 * 2) В классе Юзер добавить полей(пароль, роль(энам), логин)
 * 3) Вся логика библиотеки должна сосредоточена в одном классе
 * 4) Не использовать deprecated  классы и методы/ LocalTime
 * 5) Удалить лишние коллекции
 * 6) Продумать механизм взятие книги
 */

public class LibriaryService {

    Scanner reader = new Scanner(System.in);
    private final int attempsToEnterLogAndPass = 3;
    private final int OPENING_HOUR = 8;
    private final int CLOSING_HOUR = 17;

    Map<Genre, List<Book>> libriary = new HashMap<>();
    List<User> userCredential = new ArrayList<>();

    public LibriaryService() {

        List<Book> comedy = new ArrayList<>();
        List<Book> melodrama = new ArrayList<>();
        List<Book> triller = new ArrayList<>();

        Book bCom1 = new Book(1, "Тарас Бульба", "Гоголь");
        Book bCom2 = new Book(2, "Станционный смотритель", "Пушкин");

        Book bMel1 = new Book(1, "Дикий помещик", "Салтыков-Щедрин");
        Book bMel2 = new Book(2, "Злоумышленник", "Бунин");

        User su1 = new User("user", "123", Role.USER);
        User au1 = new User("admin", "123", Role.ADMIN);

        // add books to list
        comedy.add(bCom1);
        comedy.add(bCom2);
        melodrama.add(bMel1);
        melodrama.add(bMel2);

        // add genre and books to the libriary
        libriary.put(Genre.COMEDY, comedy);
        libriary.put(Genre.MELODRAMA, melodrama);
        libriary.put(Genre.TRILLER, triller);

        // add user credentials
        userCredential.add(su1);
        userCredential.add(au1);
    }

    private int randomNumber() {
        Random rand = new Random();
        return rand.nextInt(100);
    }

    // If libriary is open
    public boolean isLibriaryOpen() {

        LocalTime l = LocalTime.now();
        boolean flag = false;

        if (l.getHour() >= OPENING_HOUR && l.getHour() <= CLOSING_HOUR) {
            flag = true;
        }
        return flag;
    }

    public void watchListOfBook() {
        libriary.forEach((key, value) -> System.out.println(key + " : " + value));
    }

    //    @SuppressWarnings("unchecked")
    public void watchLictOfBookByGenre(Genre genre) {
        System.out.println(libriary.get(genre));
    }

    public void addBook(String genre, String author, String nameOfBook) {

        Genre genreUp = Genre.valueOf(genre.toUpperCase());
        try {
            libriary.get(genreUp).add(new Book(randomNumber(), author, nameOfBook));
        } catch (Throwable e) {
            System.out.println("java.lang.NullPointerException");
        }
    }

    public void deleteBookByAdmin(String genre, int id) {

        Genre genreUp = Genre.valueOf(genre.toUpperCase());
        List<Book> list = libriary.get(genreUp);
        try {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId() == id) {
                    list.remove(i);
                }
            }
        } catch (Throwable e) {
            System.out.println("java.lang.NullPointerException");
        }
    }

    public void giveBookToUser(String genre, String nameOfBook) {

        Genre genreUp = Genre.valueOf(genre.toUpperCase());
        List<Book> list = libriary.get(genreUp); // почему я не могу использывать list.get(i).getId
        try {
            for (int i = 0; i < libriary.get(genreUp).size(); i++) {//remove duplication of variable
                if (nameOfBook.contains(libriary.get(genreUp).get(i).getNameOfBook())) {
                    libriary.get(genreUp).remove(i);
                }
            }
        } catch (Throwable e) {
            System.out.println("java.lang.NullPointerException");
        }
    }

    public boolean checkEnterCredentials(String login, String userPassword, Role role) {
        boolean flag = false;
        for (int i = 0; i < userCredential.size(); i++) {
            if (userCredential.get(i).equals(new User(login, userPassword, role))) {
                flag = true;
            }
        }
        return flag;
    }

    private String enterData(String message) {
        System.out.println(message);
        return reader.nextLine();
    }

    //change method's name
    public boolean checkLogin(String login, String password, Role role) {

        boolean flag = true;

        if (!checkEnterCredentials(login, password, role)) {
            flag = false;
            System.out.println("You are blocked for a week.");
        }

        return flag;
    }

    private Role convertLoginToRole(String login) {

        Role userRole = Role.NOUSER;

        Role tempRole = Role.valueOf(login.toUpperCase());

        if (tempRole == Role.USER || tempRole == Role.ADMIN) {
            userRole = tempRole;
        }

        return userRole;
    }
    // change name's of method
    public void openLibriaryMenu() {
        //uncoment
//        if (!isLibriaryOpen()) {
//            System.out.println("The libriary is closed");
//            return;
//        }

        Role role = null;
        int count = 0;

        for (int i = 0; i < attempsToEnterLogAndPass; i++) {

            String login = enterData("Enter your login: ");

            String password = enterData("Enter your password: ");

            role = convertLoginToRole(login);

            if (checkLogin(login, password, role)) {
                count++;
                break;
            }
        }

        if (count == 0) {
            System.out.println("You are blocked on a next 5 hours");
            return;
        }

        if (role.equals(Role.ADMIN)) {
            while (true) {
                System.out.println(
                        "1.Delete book from libriary\n"
                                + "2. Give book to user\n"
                                + "3. Add book to libriary\n"
                                + "4. See a list of book in libriary\n"
                                + "5. Close program\n"
                );

                String genres = Arrays.toString(Genre.values());

                try {
                    switch (Integer.parseInt(enterData("Please enter your variant:"))) {//remove duplications
                        case 1:
                            System.out.println("You have choose between these type of genre" + genres);

                            String genre = enterData("Please enter genre of book");

                            int idOfBook = Integer.parseInt(enterData("Please enter book id, which you want to delete"));

                            deleteBookByAdmin(genre, idOfBook);
                            break;
                        case 2:
                            System.out.println("You have choose between these type of genre" + genres);
                            genre = enterData("Please enter genre of book");

                            String nameOfBook = enterData("Please enter name of book, which you want to give to user");
                            giveBookToUser(genre, nameOfBook);
                            break;
                        case 3:
                            System.out.println("You have choose between these type of genre" + genres);
                            genre = enterData("Please enter genre of book");

                            String author = enterData("Please enter author of book, which you want to add");
                            nameOfBook = enterData("Please enter name of book, which you want to add");

                            addBook(genre, author, nameOfBook);
                            break;
                        case 4:
                            watchListOfBook();
                            break;
                        case 5:
                            return;
                        default:
                            System.out.println("You enter invalid value");
                    }
                } catch (Throwable e) {
                    System.out.println("You have entered not integer");
                    return;
                }
            }
        } else if (role.equals(Role.USER)) {
            while (true) {
                System.out.println(
                        "1. Take a book\n"
                                + "2. See a list of book in libriary\n"
                                + "3. Close program\n"
                );
                try {
                    switch (Integer.parseInt(enterData("Please enter your variant:"))) {
                        case 1:
                            System.out.println("You have choose between these type of genre"
                                    + java.util.Arrays.asList(Genre.values()));
                            String genre = enterData("Please enter genre of book");
                            String nameOfBook = enterData("Please enter name of book, which you want to give to user");
                            giveBookToUser(genre, nameOfBook);
                            break;
                        case 2:
                            watchListOfBook();
                            break;
                        case 3:
                            return;
                        default:
                            System.out.println("You enter invalid value");
                            return;
                    }
                } catch (Throwable e) {
                    System.out.println("You have entered not integer");
                    return;
                }
            }
        }
    }
}


package homeworks.HW.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexHM {

    private static BufferedReader BUFFERED_READER =
            new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

//1) Любое количество букв, а потом две цифры и наоборот.
        String text = "sfd33";
        String regex = "[A-Za-z ]*\\d{2}";
//        String regex = "\\D*\\d{2}";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        System.out.println(matcher.matches());

        text = "33sfd";
        regex = "\\d{2}[A-Za-z ]*";
        pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(text);
        System.out.println(matcher.matches());

//        2) 2-4 цифры, а потом 2-4 буквы и наоборот.

        text = "33sfd";
        regex = "\\d{2,4}[A-Za-z ]{2,4}";
        pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(text);
        System.out.println(matcher.matches());

        text = "sfd55";
        regex = "[A-Za-z ]{2,4}\\d{2,4}";
        pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(text);
        System.out.println(matcher.matches());

//        3) Пользователь вводит имя и фамилию. Буквы могут быть в разных регистрах.
//        Проверить, чтобы первые буквы были в верхнем регистре, а остальные буквы - в нижнем.
        String name = BUFFERED_READER.readLine();
        String surname = BUFFERED_READER.readLine();

        regex = "\\p{Upper}{1}\\p{Lower}* \\p{Upper}{1}\\p{Lower}*";
        pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(name +" "+surname);
        System.out.println(matcher.matches());
    }
}

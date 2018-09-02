package homeworks.HW.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class CheckPhoneNumberMap {

    private static final BufferedReader BUFFERED_READER =
            new BufferedReader(new InputStreamReader(System.in));

    private static final String RIGTH_NUMBER_FORMAT = "(ххх)ххх-хх-хх";

    private static String userChoice;
    private static boolean numberFlag = false;

    static Map<String, String> regexMap = new HashMap<>();

    private static final String REGEX_LIFE_NUMBER = "\\({1}073\\){1}|\\({1}063\\){1}.*";

    private static final String REGEX_MTC_NUMBER = "\\({1}095\\){1}|\\({1}099\\){1}.*";

    private static final String REGEX_KYIVSTAR_NUMBER = "\\({1}067\\){1}|\\({1}097\\){1}.*";

    public static void main(String[] args) throws IOException {

        regexMap.put(REGEX_LIFE_NUMBER, "Пользователь имеет Лайф номер");
        regexMap.put(REGEX_MTC_NUMBER, "Пользователь имеет MTC номер");
        regexMap.put(REGEX_KYIVSTAR_NUMBER, "Пользователь имеет Kyivstar номер");

        userChoice = BUFFERED_READER.readLine();


     /*   regexMap.forEach((k, v) -> {
            if (Pattern.compile(k, Pattern.CASE_INSENSITIVE).matcher(userChoice).matches()) {
                System.out.println(v);
                numberFlag = true;
            }
        });*/

        Predicate<Map.Entry<String, String>> predicate = entry ->
                Pattern.compile(entry.getKey(), Pattern.CASE_INSENSITIVE)
                        .matcher(userChoice).matches();

        boolean flag = regexMap.entrySet().stream().anyMatch(predicate);

        if (!flag) {
            System.out.println("You entered inccorect number. Please entered next format "
                    + RIGTH_NUMBER_FORMAT);
            return;
        }

        regexMap.entrySet().stream()
                .filter(predicate).forEach(System.out::println);

//        System.out.println(numberFlag ? "" : "You entered inccorect number");
       /* if (!numberFlag) {
            System.out.println("You entered inccorect number. Please entered next format "
                    + RIGTH_NUMBER_FORMAT);
        }*/
    }
}

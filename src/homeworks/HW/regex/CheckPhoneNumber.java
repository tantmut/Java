package homeworks.HW.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckPhoneNumber {

    private static final String regexAnyPhoneNumber = "(\\({1}095\\){1}|\\({1}097\\){1}|" +
            "\\({1}073\\){1}|\\({1}067\\){1}|\\({1}099\\){1}|\\({1}063\\){1})" +
            "\\d{3}-\\d{2}-\\d{2}";

    private static final String REGEX_LIFE_NUMBER = "\\({1}073\\){1}|\\({1}063\\){1}.*";

    private static final String REGEX_MTC_NUMBER = "\\({1}095\\){1}|\\({1}099\\){1}.*";

    private static final String REGEX_KYIVSTAR_NUMBER = "\\({1}067\\){1}|\\({1}097\\){1}.*";

    private static final Pattern ANY_NUMBER =
            Pattern.compile(regexAnyPhoneNumber, Pattern.CASE_INSENSITIVE);

    private static final Pattern LIFE_NUMBER =
            Pattern.compile(REGEX_LIFE_NUMBER, Pattern.CASE_INSENSITIVE);

    private static final Pattern MTS_NUMBER =
            Pattern.compile(REGEX_MTC_NUMBER, Pattern.CASE_INSENSITIVE);

    private static final Pattern KYIVSTAR_NUMBER =
            Pattern.compile(REGEX_KYIVSTAR_NUMBER, Pattern.CASE_INSENSITIVE);

    private static final BufferedReader BUFFERED_READER =
            new BufferedReader(new InputStreamReader(System.in));

    private static final String RIGTH_NUMBER_FORMAT = "(ххх)ххх-хх-хх";

    private static String userChoice;

    public static void main(String[] args) throws IOException {

        System.out.println("Please enter a phone number in next format:" +
                RIGTH_NUMBER_FORMAT);

        userChoice = BUFFERED_READER.readLine();

        Matcher matcherForAnyNumber = ANY_NUMBER.matcher(userChoice);
        Matcher matcherForLifeNumber = LIFE_NUMBER.matcher(userChoice);
        Matcher matcherForMtsNumber = MTS_NUMBER.matcher(userChoice);
        Matcher matcherForKyivstarNumber = KYIVSTAR_NUMBER.matcher(userChoice);


        if (matcherForAnyNumber.matches()) {

            if(matcherForLifeNumber.matches()){
                System.out.println("Пользователь имеет Лайф номер");
            }

            if(matcherForKyivstarNumber.matches()){
                System.out.println("Пользователь имеет Киевстар номер");
            }

            if(matcherForMtsNumber.matches()){
                System.out.println("Пользователь имеет МТС номер");
            }

        } else {
            System.out.println("You have entered incorected number. The right format is "
                    + RIGTH_NUMBER_FORMAT);
        }

    }
}
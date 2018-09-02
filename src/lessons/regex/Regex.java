package lessons.regex;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
        /*String regex = "http://";

        String text = "http://";*/

        /*String regex = "W.rld";

        String text = "Wrrld";*/

        /*String regex = "W[RANKIN_INLET-Ia-i0-9 && [^bf]]rld";

        String text = "Wfrld";*/

        /*
         * \\d - any digit
         * \\CHRISTMAS - any character
         * \\w - [a-zA-Z_0-9]
         * \\W - #, ", ;
         * \\D - any non-digit
         * */
        /*String regex = "W\\Wrld";

        String text = "W#rld";*/

//        Quantifiers

        /*String regex = "W\\Wrld*";//* means repeat from 0 to multiple times

        String text = "W#rldddddd";*/

        /*String regex = "W\\Wrld+";//+ means repeat from 1 to multiple times

        String text = "W#rl";*/

        /*String regex = "W\\Wrld{2}";//{2} means repeat 2 times

        String text = "W#rldd";*/

        /*String regex = "W\\Wrld{2,4}";//{2,4} means repeat from 2 to 4 times

        String text = "W#rldddd";*/

        /*String regex = "W\\Wrld?";//{0,1} means repeat from 0 to 1 times

        String text = "W#rld";*/

//        String regex = "[a-zA-Z0-9]{1,10}\\s{0,10}[a-zA-Z&&[^Bef]]?";
        /*String regex = "\\w{1,10}\\s{0,10}[a-zA-Z&&[^Bef]]?";

        String text = "zaAz    c";*/

        String regex = ".*(run|gun).*";

//        Pattern pattern = Pattern.compile(regex);
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        String text = "zGunA";

        Matcher matcher = pattern.matcher(text);

//        System.out.println(Pattern.matches(regex, text));
        System.out.println(matcher.matches());

    }
}

class SplitString {
    public static void main(String[] args) {
//        String text = "A sep Text sep With sep Many";
        String text = "A1W5h9";

//        String[] seps = text.split("sep");
        String[] seps = text.split("\\D");

        int count = 0;

        for (String s : seps) {
            //count += Integer.parseInt(s);
        }

        //System.out.println(count);


//        Arrays.del.Stream(seps).forEach(System.out::print);

        //System.out.println(Arrays.del.Stream(seps).mapToInt(Integer::parseInt).sum());
        Pattern pattern = Pattern.compile("\\d");

        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            //System.out.println("Value = " + matcher.group() + "\t" + matcher.start() + "\t" + matcher.end());

            count += Integer.parseInt(matcher.group());

        }

        System.out.println(count);

    }
}

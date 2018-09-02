package del;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {

    public static void main(String[] args) {

        String s = "a";

        String s1 = "a";


        System.out.println(s.hashCode());

        System.out.println(s1.hashCode());

        String s2 = new String("a");
 
        System.out.println(s == s1);
        System.out.println(s == s2);
        System.out.println(s2.hashCode());


    }
}

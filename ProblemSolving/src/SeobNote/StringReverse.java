package SeobNote;

import java.util.HashSet;
import java.util.Set;

public class StringReverse {
    public static void main(String[] args) {
        String s = "abaskljqwkleasd";
        s = new StringBuffer(s).reverse().toString();
        System.out.println(s);
        Set<String> stringSet = new HashSet<>();
    }
}

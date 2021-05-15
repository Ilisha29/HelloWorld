package BOJ._1Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ12904 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String S = bufferedReader.readLine();
        String T = bufferedReader.readLine();
        while (T.length() != S.length()){
            String splitT = T.substring(0,T.length() - 1);
            String tail = T.substring(T.length() - 1);
            if (tail.equals("A"))
                T = splitT;
            else
                T = new StringBuffer(splitT).reverse().toString();
        }
        if (T.equals(S))
            System.out.println(1);
        else
            System.out.println(0);
        bufferedReader.close();
    }
}

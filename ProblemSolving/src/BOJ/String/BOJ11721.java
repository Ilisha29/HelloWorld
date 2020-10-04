package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11721 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string = bufferedReader.readLine();
        for (int i = 0; i < string.length(); i++) {
            if (i / 10 >= 1 && i % 10 == 0) {
                System.out.println();
            }
            System.out.print(string.charAt(i));
        }
        bufferedReader.close();
    }
}

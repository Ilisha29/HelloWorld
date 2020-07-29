package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ7597 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String string = bufferedReader.readLine();
            if (string.equals("#")) {
                break;
            }
            String[] strings = string.split("");
            int A = 0;
            int B = 0;
            int Awin = 0;
            int Bwin = 0;
            for (int i = 0; i < strings.length; i++) {
                if (strings[i].equals("A")) {
                    A++;
                } else if (strings[i].equals("B")) {
                    B++;
                }
                if ((A >= 4 || B >= 4) && Math.abs(A - B) >= 2) {
                    if (A > B) {
                        Awin++;
                    } else {
                        Bwin++;
                    }
                    A = 0;
                    B = 0;
                }
            }
            System.out.println("A " + Awin + " B " + Bwin);
        }
        bufferedReader.close();
    }
}

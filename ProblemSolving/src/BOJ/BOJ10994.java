package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10994 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        bufferedReader.close();
        int num = 2 * (2 * n - 1) - 1;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if ((i % 2 == 0) && (j % 2 == 0))
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}

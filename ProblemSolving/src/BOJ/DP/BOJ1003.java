package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1003 {
    public static void main(String[] args) throws IOException {
        int[][] fibonacci = new int[2][41];
        fibonacci[0][0] = 1;
        fibonacci[1][1] = 1;
        for (int i = 2; i < 41; i++) {
            fibonacci[0][i] = fibonacci[0][i - 1] + fibonacci[0][i - 2];
            fibonacci[1][i] = fibonacci[1][i - 1] + fibonacci[1][i - 2];
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int rep = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < rep; i++) {
            int N = Integer.parseInt(bufferedReader.readLine());
            System.out.println(fibonacci[0][N] + " " + fibonacci[1][N]);
        }
        bufferedReader.close();
    }
}

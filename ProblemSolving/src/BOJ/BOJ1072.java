package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        long X = Long.parseLong(stringTokenizer.nextToken());
        long Y = Long.parseLong(stringTokenizer.nextToken());
        long Z = (Y * 100) / X;
        long N = Y/100;
        if (Z >= 99) {
            System.out.println(-1);
        } else {
            while (((Y + N) * 100) / (X + N) == Z) {
                N++;
            }
            System.out.println(N);
        }
        bufferedReader.close();
    }
}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int A = Integer.parseInt(stringTokenizer.nextToken());
        int B = Integer.parseInt(stringTokenizer.nextToken());
        int V = Integer.parseInt(stringTokenizer.nextToken());
        int day = (V - B - 1) / (A - B) + 1;
        System.out.println(day);
        bufferedReader.close();
    }
}

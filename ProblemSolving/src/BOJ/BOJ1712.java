package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1712 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int A = Integer.parseInt(stringTokenizer.nextToken());
        int B = Integer.parseInt(stringTokenizer.nextToken());
        int C = Integer.parseInt(stringTokenizer.nextToken());
        int answer = 0;
        if (B >= C) {
            System.out.println(-1);
        } else {
            while (true) {
                if ((C - B) * answer - A > 0) {
                    break;
                } else {
                    answer++;
                }
            }
            System.out.println(answer);
        }
        bufferedReader.close();
    }
}

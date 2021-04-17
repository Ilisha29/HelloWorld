package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int A = Integer.parseInt(stringTokenizer.nextToken());
        int B = Integer.parseInt(stringTokenizer.nextToken());
        int count = 0;
        while (A < B) {
            if (B % 10 == 1) {
                B /= 10;
                count++;
            } else if (B % 2 == 0) {
                B /= 2;
                count++;
            } else {
                break;
            }
        }
        if (A == B) {
            System.out.println(count + 1);
        } else {
            System.out.println(-1);
        }
        bufferedReader.close();
    }
}

package BOJ._5BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        long X = Integer.parseInt(stringTokenizer.nextToken());
        long Y = Integer.parseInt(stringTokenizer.nextToken());
        long Z = (Y * 100) / X;
        if (X == Y) {
            System.out.println(-1);
        } else if (Z >= 99) {
            System.out.println(-1);
        } else {
            System.out.println(calculateAnswer(X, Y, Z));
        }
        bufferedReader.close();
    }

    private static long calculateAnswer(long X, long Y, long Z) {
        long start = 0;
        long end = Integer.MAX_VALUE;
        while (start <= end) {
            long mid = (start + end) / 2;
            long newZ = (100 * (Y + mid)) / (X + mid);
            if (newZ > Z) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
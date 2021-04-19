package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int K = Integer.parseInt(stringTokenizer.nextToken());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int[] line = new int[K];
        for (int i = 0; i < K; i++) {
            line[i] = Integer.parseInt(bufferedReader.readLine());
        }
        long start = 1;
        long end = Integer.MAX_VALUE;
        long answer = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            int count = 0;
            for (int i = 0; i < line.length; i++) {
                count += line[i] / mid;
            }
            if (count < N) {
                end = mid - 1;
            } else {
                start = mid + 1;
                answer  = Math.max(answer, mid);
            }
        }
        System.out.println(answer);
        bufferedReader.close();
    }
}

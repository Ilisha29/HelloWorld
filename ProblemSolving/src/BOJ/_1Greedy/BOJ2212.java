package BOJ._1Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int K = Integer.parseInt(bufferedReader.readLine());
        int[] censors = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            censors[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(censors);
        int[] gap = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            gap[i] = censors[i + 1] - censors[i];
        }
        Arrays.sort(gap);
        int sum = 0;
        for (int i = 0; i < gap.length - K + 1; i++) {
            sum += gap[i];
        }
        System.out.println(sum);
        bufferedReader.close();
    }
}

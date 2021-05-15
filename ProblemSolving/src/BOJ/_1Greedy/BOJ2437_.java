package BOJ._1Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2437_ {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] input = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(input);
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (sum + 1 < input[i]) {
                break;
            }
            sum += input[i];
        }
        System.out.println(sum + 1);
        bufferedReader.close();
    }
}


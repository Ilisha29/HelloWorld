package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2847 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] array = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            array[i] = Integer.parseInt(bufferedReader.readLine());
        }
        int answer = 0;
        for (int i = 1; i < N; i++) {
            if (array[i] >= array[i - 1]) {
                int changeNum = array[i - 1] - 1;
                answer += array[i] - changeNum;
                array[i] = changeNum;
            }
        }
        System.out.println(answer);
        bufferedReader.close();
    }
}

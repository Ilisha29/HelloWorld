package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(bufferedReader.readLine());
        }
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += arr[i];
        }
        boolean isfind = false;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (isfind)
                    break;
                if (i == j)
                    continue;
                if (sum - arr[i] - arr[j] == 100) {
                    arr[i] = 101;
                    arr[j] = 101;
                    Arrays.sort(arr);
                    for (int k = 0; k < 7; k++) {
                        System.out.println(arr[k]);
                    }
                    isfind = true;
                }
            }
        }
        bufferedReader.close();
    }
}

package BOJ._1Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        if (N <= 2) {
            if (N == 1) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        } else {
            int[] array = new int[10001];
            array[1] = 1;
            array[2] = 2;
            for (int i = 3; i <= N; i++) {
                array[i] = (array[i - 1] + array[i - 2]) % 10007;
            }
            System.out.println(array[N]);
        }
        bufferedReader.close();
    }
}

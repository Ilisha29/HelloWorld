package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2166 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        long[] x = new long[N + 1];
        long[] y = new long[N + 1];
        for (int i = 0; i < N; i++) {
            String[] strings = bufferedReader.readLine().split(" ");
            x[i] = Long.parseLong(strings[0]);
            y[i] = Long.parseLong(strings[1]);
        }
        x[N] = x[0];
        y[N] = y[0];
        long sumA = 0;
        long sumB = 0;
        for (int i = 0; i < N; i++) {
            sumA += x[i] * y[i + 1];
            sumB += y[i] * x[i + 1];
        }
        long sum = sumA - sumB;
        double answer = Math.abs(sum) / 2.0;
        String s  = String.format("%.1f", answer); //너무한거아님???? 로직문제가 아니라 출력 형식!!! 및  반올림!!!! 오류
        System.out.println(s);
        bufferedReader.close();
    }
}

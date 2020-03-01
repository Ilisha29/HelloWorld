import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2166 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        long[] x = new long[N + 1];
        long[] y = new long[N + 1];
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            x[i] = Long.parseLong(stringTokenizer.nextToken());
            y[i] = Long.parseLong(stringTokenizer.nextToken());
        }
        x[N] = x[0];
        y[N] = y[0];
        double answer = CCW(x, y) / 2.0;
        System.out.println(answer);
        bufferedReader.close();
    }

    private static double CCW(long[] x, long[] y) {
        long sum = 0;
        for (int i = 0; i <= x.length - 1; i++) {
            sum += x[i] * y[i + 1];
            sum -= x[i + 1] * y[i];
        }
        return Math.abs(sum);
    }

}

package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ18310 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] list = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(list);
        System.out.println(list[(N - 1) / 2]);
        bufferedReader.close();
    }
}

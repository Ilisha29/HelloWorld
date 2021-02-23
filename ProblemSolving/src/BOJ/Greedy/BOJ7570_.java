package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ7570_ {
    //가장 긴 증가 수열
    public static void main(String[] args)  throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] num = new int[N + 1];
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            int tmp = Integer.parseInt(stringTokenizer.nextToken());
            num[tmp] = num[tmp-1] + 1;
            answer = Math.max(answer,num[tmp]);
        }
        System.out.println(N - answer);
        bufferedReader.close();
    }
}

package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int L = Integer.parseInt(stringTokenizer.nextToken());
        int[] holes = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(holes);
        int beforeReach = 0;
        int answer = 0;
        for (int i = 0; i < holes.length; i++) {
            if (holes[i] > beforeReach) {
                answer++;
                beforeReach = holes[i] + L - 1;
            }
        }
        System.out.println(answer);
        bufferedReader.close();
    }
}

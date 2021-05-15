package BOJ._5BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2343 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int[] array = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int start = 1;
        int end = 1000000000;
        int maxVideo = 0;
        for (int i = 0; i < array.length; i++) {
            maxVideo = Math.max(array[i], maxVideo);
        }
        int answer = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = (start + end) / 2;
            int blueRay = 0;
            int tmpSum = 0;
            if (mid < maxVideo) {
                start = mid + 1;
                continue;
            }
            for (int i = 0; i < N; i++) {
                if (tmpSum + array[i] > mid) {
                    blueRay++;
                    tmpSum = array[i];
                } else {
                    tmpSum += array[i];
                }
            }
            if (tmpSum > 0) {
                blueRay++;
            }
            if (blueRay <= M) {
                answer = Math.min(answer, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(answer);
        bufferedReader.close();
    }
}

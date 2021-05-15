package BOJ._5BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] trees = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int needs = inputs[1];
        int start = 0;
        int end = 100;
        while (start <= end) {
            int mid = (start + end) / 2;
            long cutTree = 0;
            for (int i = 0; i < trees.length; i++) {
                if (trees[i] > mid) {
                    cutTree += trees[i] - mid;
                }
            }
            if (cutTree >= (long) needs) {
                start = mid + 1;
            } else {
                end = mid -1;
            }
        }
        System.out.println(end);
        bufferedReader.close();
    }
}

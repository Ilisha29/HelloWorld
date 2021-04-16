package BOJ.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int[] array = new int[N];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(bufferedReader.readLine());
        }
        Arrays.sort(array);
        System.out.println(printAnswer(M, array));
        bufferedReader.close();
    }

    private static int printAnswer(int M, int[] array) {
        int min = Integer.MAX_VALUE;
        int j = 0;
        for (int i = 0; i < array.length && j < array.length; ) {
            if (array[i] - array[j] >= M) {
                min = Math.min(min, array[i] - array[j]);
                j++;
            } else {
                i++;
            }
        }
        return min;
    }
}

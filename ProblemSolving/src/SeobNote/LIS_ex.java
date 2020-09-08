package SeobNote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LIS_ex {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] array = new int[n];
        int[] LIS = new int[n];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
            LIS[i] = 1;
        }
        reverse_array(array);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) {
                    LIS[i] = Math.max(LIS[i], LIS[j] + 1);
                }
            }
        }
        int MAX = 0;
        for (int i = 0; i < LIS.length; i++) {
            MAX = LIS[i] > MAX ? LIS[i] : MAX;
        }
        System.out.println(array.length - MAX);
    }

    private static void reverse_array(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int tmp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = tmp;
        }
    }
}

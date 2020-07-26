package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(bufferedReader.readLine());
        }
        Arrays.sort(arr);
        for (int i = 0; i < Math.pow(2, 9); i++) {
            int sum = 0;
            if (Integer.bitCount(i) == 7) {
                String[] strings = Integer.toBinaryString(i).split("");
                for (int j = 0; j < strings.length; j++) {
                    if (strings[j].equals("1")) {
                        sum += arr[j];
                    }
                }
                if (sum == 100) {
                    for (int j = 0; j < strings.length; j++) {
                        if (strings[j].equals("1")) {
                            System.out.println(arr[j]);
                        }
                    }
                    break;
                }
            }
        }
        bufferedReader.close();
    }
}

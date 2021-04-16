package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int rep = Integer.parseInt(bufferedReader.readLine());
        long[] array = new long[101];
        array[1] = 1;
        array[2] = 1;
        array[3] = 1;
        for (int i = 4; i <= 100; i++) {
            array[i] = array[i - 2] + array[i - 3];
        }
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < rep; i++) {
            stringBuilder.append(array[Integer.parseInt(bufferedReader.readLine())]);
            stringBuilder.append("\n");
        }
        System.out.print(stringBuilder.toString());
        bufferedReader.close();
    }
}

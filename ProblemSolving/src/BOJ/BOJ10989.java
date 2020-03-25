package BOJ;

import java.io.*;
import java.util.Arrays;

public class BOJ10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(bufferedReader.readLine());
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(bufferedReader.readLine());
        }
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            bufferedWriter.write(array[i] + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}

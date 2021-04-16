package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int rep = Integer.parseInt(bufferedReader.readLine());
        int[] arr;
        for (int i = 0; i < rep; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int num = Integer.parseInt(stringTokenizer.nextToken());
            int sum = 0;
            arr = new int[num];
            for (int j = 0; j < num; j++) {
                int score = Integer.parseInt(stringTokenizer.nextToken());
                arr[j] = score;
                sum += score;
            }
            float avg = sum / (float) num;
            int count = 0;
            for (int j = 0; j < num; j++) {
                if (avg < arr[j])
                    count++;
            }
            System.out.println(String.format("%.3f", (count * 100) / (float) num) + "%");
        }
        bufferedReader.close();
    }
}

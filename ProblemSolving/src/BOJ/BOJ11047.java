package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] array = new int[Integer.parseInt(stringTokenizer.nextToken())];
        int money = Integer.parseInt(stringTokenizer.nextToken());
        int answer = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(bufferedReader.readLine());
        }
        for (int i = array.length - 1; i >= 0; i--) {
            if (money == 0) {
                break;
            }
            while (money >= array[i]) {
                answer++;
                money -= array[i];
            }
        }
        System.out.println(answer);
        bufferedReader.close();
    }
}

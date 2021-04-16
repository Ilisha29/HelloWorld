package 코테대비책.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 못생긴수 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int index = 1;
        int num = 2;
        while (true) {
            if (num % 2 == 0 || num % 3 == 0 || num % 5 == 0) {
                index++;
            }
            num++;
            if (index == N) {
                break;
            }

        }
        System.out.println(num);
        bufferedReader.close();
    }
}

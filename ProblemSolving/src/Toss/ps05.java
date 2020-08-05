package Toss;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ps05 {
    /*
    100 300 10 0 40 0 0 70 65
40 300 20 10 10 20 100 10 0
    */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String kToss = bufferedReader.readLine();
        String[] KToss = kToss.split(" ");
        String lToss = bufferedReader.readLine();
        String[] LToss = lToss.split(" ");
        int sum = 0;
        for (int i = 0; i < KToss.length; i++) {
            sum += Integer.parseInt(KToss[i]) - Integer.parseInt(LToss[i]);
            if (sum > 0) {
                System.out.print(sum);
                sum = 0;
            } else {
                System.out.print(0);
            }
            if (i != KToss.length - 1) {
                System.out.print(" ");
            }
        }
        bufferedReader.close();
    }
}

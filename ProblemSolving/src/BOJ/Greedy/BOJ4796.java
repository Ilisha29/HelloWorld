package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ4796 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int rep = 1;
        while (true) {
            String[] inputNumbers = bufferedReader.readLine().split(" ");
            if (inputNumbers[0].equals("0") && inputNumbers[1].equals("0") && inputNumbers[2].equals("0")) {
                break;
            }
            int L = Integer.parseInt(inputNumbers[0]);
            int P = Integer.parseInt(inputNumbers[1]);
            int V = Integer.parseInt(inputNumbers[2]);
            int remain = V % P;
            int count = (V / P) * L;
            count += Math.min(L, remain);
            System.out.println("Case " + rep + ": " + count);
            rep++;
        }
        bufferedReader.close();
    }
}

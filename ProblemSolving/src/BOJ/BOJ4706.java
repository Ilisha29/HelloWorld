package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 21 : 50
public class BOJ4706 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            double ta = Double.parseDouble(stringTokenizer.nextToken());
            double tb = Double.parseDouble(stringTokenizer.nextToken());
            if (ta == 0 && tb == 0)
                break;
            double answer = Math.sqrt(1 - (tb / ta) * (tb / ta));
            System.out.format("%.3f\n", answer);
        }
        bufferedReader.close();
    }
}
// 22 : 07 (17 minutes)
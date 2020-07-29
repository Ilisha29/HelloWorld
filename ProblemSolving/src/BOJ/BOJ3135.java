package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 21:35
public class BOJ3135 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int from = Integer.parseInt(stringTokenizer.nextToken());
        int to = Integer.parseInt(stringTokenizer.nextToken());
        int MIN = Math.abs(from - to);
        int num = 0;
        int rep = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < rep; i++) {
            int tmp = Integer.parseInt(bufferedReader.readLine());
            if (MIN > Math.abs(tmp - to)) {
                num = 1;
                MIN = Math.abs(tmp - to);
            }
        }
        num += MIN;
        System.out.println(num);
        bufferedReader.close();
    }
}
// 21:44 (9 minutes)
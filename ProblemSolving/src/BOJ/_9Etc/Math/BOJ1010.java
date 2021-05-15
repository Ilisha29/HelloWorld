package BOJ._9Etc.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int rep = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < rep; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int west = Integer.parseInt(stringTokenizer.nextToken());
            int east = Integer.parseInt(stringTokenizer.nextToken());
            if (west == 0 || west == east) {
                System.out.println(1);
            } else {
                west = Math.min(west, east - west);
                long tmpAnswer = 1;
                int count = 0;
                while (count < west) {
                    tmpAnswer *= east;
                    east--;
                    count++;
                }
                while (west > 0) {
                    tmpAnswer /= west;
                    west--;
                }
                System.out.println(tmpAnswer);
            }
        }
        bufferedReader.close();
    }
}

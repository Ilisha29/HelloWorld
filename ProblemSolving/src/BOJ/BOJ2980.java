package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2980 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(strings[0]);
        int L = Integer.parseInt(strings[1]);
        int[] roads = new int[L + 1];
        int[] red = new int[L + 1];
        int[] green = new int[L + 1];
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int D = Integer.parseInt(stringTokenizer.nextToken());
            int R = Integer.parseInt(stringTokenizer.nextToken());
            int G = Integer.parseInt(stringTokenizer.nextToken());
            roads[D] = 1;
            red[D] = R;
            green[D] = G;
        }
        int seconds = 0;
        for (int i = 1; i < roads.length; i++) {
            seconds++;
            if (roads[i] == 1) {
                if (seconds % (red[i] + green[i]) <= red[i]) {
                    seconds += red[i] - (seconds % (red[i] + green[i]));
                }
            }
        }
        /*while (location < L) {
            if (roads[location] == 0) {
                location++;
            } else {
                if (seconds % (red[location] + green[location]) >= red[location]) {
                    location++;
                }
            }
            seconds++;
        }*/
        System.out.println(seconds);
        bufferedReader.close();
    }
}

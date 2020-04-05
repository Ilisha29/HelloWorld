package 기출.LINE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _03 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String road = "111011110011111011111100011111";
        int n = 3;
        int answer = 0;

        String[] tmpRoads = road.split("");
        int[] roads = new int[tmpRoads.length];
        for (int i = 0; i < tmpRoads.length; i++) {
            roads[i] = Integer.parseInt(tmpRoads[i]);
        }

        for (int i = 0; i < roads.length; i++) {
            int canFixNum = n;
            int tmpLength = 0;
            for (int j = i; j < roads.length; j++) {
                if (roads[j] == 0 && canFixNum == 0) {
                    break;
                }
                if (roads[j] == 1) {
                    tmpLength++;
                }
                if (roads[j] == 0 && canFixNum != 0) {
                    tmpLength++;
                    canFixNum--;
                }
            }
            answer = tmpLength > answer ? tmpLength : answer;
        }
        System.out.println(answer);

        bufferedReader.close();
    }
}

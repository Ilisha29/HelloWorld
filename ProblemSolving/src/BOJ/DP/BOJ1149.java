package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[][] RGB = new int[Integer.parseInt(bufferedReader.readLine())][3];
        for (int i = 0; i < RGB.length; i++) {
            RGB[i] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for (int i = 1; i < RGB.length; i++) {
            RGB[i][0] += Math.min(RGB[i - 1][1], RGB[i - 1][2]);
            RGB[i][1] += Math.min(RGB[i - 1][0], RGB[i - 1][2]);
            RGB[i][2] += Math.min(RGB[i - 1][0], RGB[i - 1][1]);
        }
        System.out.println(Math.min(RGB[RGB.length - 1][0], Math.min(RGB[RGB.length - 1][1], RGB[RGB.length - 1][2])));
        bufferedReader.close();
    }
}

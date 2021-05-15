package BOJ._6DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//시간 초과는 StringBuilder로 해
public class BOJ11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] NM = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = NM[0];
        int[][] sumArray = new int[N][N];
        for (int i = 0; i < N; i++) {
            int[] tmpArray = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < N; j++) {
                if (j != 0) {
                    sumArray[i][j] = sumArray[i][j - 1] + tmpArray[j];
                } else {
                    sumArray[i][j] = tmpArray[j];
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < NM[1]; i++) {
            int[] inputM = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int startX = inputM[0] - 1;
            int startY = inputM[1] - 1;
            int endX = inputM[2] - 1;
            int endY = inputM[3] - 1;
            int sum = 0;
            for (int j = startX; j <= endX; j++) {
                if (startY == 0){
                    sum += sumArray[j][endY];
                } else {
                    sum += sumArray[j][endY] - sumArray[j][startY - 1];
                }
            }
            stringBuilder.append(sum + "\n");
        }
        System.out.print(stringBuilder);
        bufferedReader.close();
    }
}

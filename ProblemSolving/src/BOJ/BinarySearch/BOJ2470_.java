package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2470_ {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] inputs = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(inputs);
        if (inputs[0] >= 0) {
            System.out.println(inputs[0] + " " + inputs[1]);
        } else if (inputs[N - 1] <= 0) {
            System.out.println(inputs[N - 2] + " " + inputs[N - 1]);
        } else {
            int upperZeroIndex = 0;
            for (int i = 0; i < inputs.length; i++) {
                if (inputs[i] >= 0) {
                    upperZeroIndex = i;
                    break;
                }
            }
            int minGap = 2147483640;
            int firstNum = 0;
            int secondNum = 0;
            for (int i = 0; i < upperZeroIndex; i++) {
                int start = upperZeroIndex;
                int end = inputs.length - 1;
                while (start <= end) {
                    int mid = (start + end) / 2;
                    int tmpGap = inputs[i] + inputs[mid];
                    if (Math.abs(tmpGap) < minGap) {
                        firstNum = inputs[i];
                        secondNum = inputs[mid];
                        minGap = Math.abs(tmpGap);
                    }
                    if (tmpGap < 0) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            }
            System.out.println(firstNum + " " + secondNum);
        }
        bufferedReader.close();
    }
}

package BOJ;
// How to DP??
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 01 : 40 start
public class BOJ14501 {
    static int[] duration;
    static int[] pay;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bufferedReader.readLine());
        duration = new int[size];
        pay = new int[size];
        int Max = 0;
        for (int i = 0; i < size; i++) {
            String[] strings = bufferedReader.readLine().split(" ");
            duration[i] = Integer.parseInt(strings[0]);
            pay[i] = Integer.parseInt(strings[1]);
        }

        for (int i = 0; i < size; i++) {
            if (i + duration[i] > size) {
                duration[i] = 0;
            }
        }

        for (int i = 0; i < Math.pow(2, size); i++) {
            int N = i;
            int[] array = new int[size];
            int index = 0;
            while (N > 1) {
                array[index++] = N % 2;
                N /= 2;
            }
            array[index] = N;
            int[] array2 = new int[size];
            for (int j = 0; j < array.length; j++) {
                if (array[j] == 1) {
                    for (int k = 0; k < duration[j]; k++) {
                        array2[j + k]++;
                    }
                }
            }

            int overTwo = 0;
            for (int j = 0; j < array2.length; j++) {
                if (array2[j] > 1) {
                    overTwo++;
                }
            }
            int tmpAnswer = 0;
            if (overTwo == 0) {
                for (int j = 0; j < array.length; j++) {
                    if (array[j] == 1 && duration[j] != 0) {
                        tmpAnswer += pay[j];
                    }
                }
                Max = tmpAnswer > Max ? tmpAnswer : Max;
            }
        }
        System.out.println(Max);
        bufferedReader.close();
    }
}
// 02 : 40 end

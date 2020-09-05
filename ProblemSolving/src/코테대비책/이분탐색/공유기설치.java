package 코테대비책.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 공유기설치 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(strings[0]);
        int[] array = new int[N];
        int wifi = Integer.parseInt(strings[1]);
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(bufferedReader.readLine());
        }
        Arrays.sort(array);
        int maxLength = array[array.length - 1] - array[0];
        System.out.println(wifiBinarySearch(array, 1, maxLength, wifi));
        bufferedReader.close();
    }

    private static int wifiBinarySearch(int[] array, int i, int maxLength, int wifi) {
        while (i <= maxLength) {
            int mid = (i + maxLength) / 2;
            int tmpWifi = 1;
            int pre = array[0];
            for (int j = 1; j < array.length; j++) {
                if (tmpWifi > wifi) {
                    break;
                }
                if (array[j] - pre >= mid) {
                    tmpWifi++;
                    pre = array[j];
                }
            }
            if (tmpWifi < wifi) {
                maxLength = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return (maxLength);
    }
}

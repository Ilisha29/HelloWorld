package 코테대비책.이분탐색;

import java.util.Arrays;

public class 부품찾기 {
    public static void main(String[] args) {
        int[] array = {9, 3, 7, 8, 2};
        int[] brray = {9, 3, 7, 8, 2};
        int[] find = {5, 7, 9};
        for (int i = 0; i < find.length; i++) {
            System.out.println(Arrays.binarySearch(array, find[i]));
        }
        System.out.println("=================");
        for (int i = 0; i < find.length; i++) {
            Arrays.sort(brray);
            System.out.println(Arrays.binarySearch(brray, find[i]));
        }
    }
}

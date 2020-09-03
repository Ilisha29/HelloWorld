package 코테대비책.이분탐색;

import java.util.Arrays;

public class 정렬된배열에서특정수의개수구하기 {
    public static int BinarySearchLeft(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            // 찾은 경우 중간점 인덱스 반환
            if (arr[mid] == target) {
                if (mid == 0 || arr[mid - 1] != target)
                    return mid;
                else
                    end = mid - 1;
            }
            // 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
            else if (arr[mid] > target) end = mid - 1;
                // 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
            else start = mid + 1;
        }
        return -1;
    }

    public static int BinarySearchRight(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            // 찾은 경우 중간점 인덱스 반환
            if (arr[mid] == target) {
                if (mid == arr.length - 1 || arr[mid + 1] != target)
                    return mid;
                else
                    start = mid + 1;
            }
            // 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
            else if (arr[mid] > target) end = mid - 1;
                // 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
            else start = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[100];
        for (int i = 0; i < 100; i++) {
            array[i] = (int) (Math.random() * 10);
        }
        Arrays.sort(array);
        int target = 9;

        int left = BinarySearchLeft(array, target, 0, array.length - 1);
        if (left == -1) {
            System.out.println(-1);
        } else {
            int rigth = BinarySearchRight(array, target, 0, array.length - 1);
            System.out.println(rigth - left + 1);
        }
        for (int i = 0; i < 100; i++) {
            System.out.print(array[i] + " ");
        }
    }
}

package BOJ;

import java.util.Scanner;

public class BOJ2798 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int findNum = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        /*
        for (int i = 0; i < size - 2; i++) {
            answers[i] = array[i] + array[i + 1] + array[i + 2];
        }
        틀린 로직이였다. sort해서 연속합으로 하면 안되는 경우가 생길수 있다.
        */
        //int answer = array[0] + array[1] + array[2]; //이렇게 초기화하면 앞선 배열 3개가 이미 findNum값을 넘어서면 틀린 결괏값이 나옴
        int answer = 0;
        for (int i = 0; i < array.length - 2; i++) {
            for (int j = i + 1; j < array.length - 1; j++) {
                for (int k = j + 1; k < array.length; k++) {
                    if (array[i] + array[j] + array[k] <= findNum && answer < array[i] + array[j] + array[k]) {
                        answer = array[i] + array[j] + array[k];
                    }
                }
            }
        }
        System.out.println(answer);
    }
}

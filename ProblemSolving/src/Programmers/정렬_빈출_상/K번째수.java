package Programmers.정렬_빈출_상;

import java.util.ArrayList;
import java.util.Collections;

// 21 : 38
public class K번째수 {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] answer = solution(array, commands);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i] + " ");
        }
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int findIndex = commands[i][2];
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int j = start - 1; j <= end - 1; j++) {
                arrayList.add(array[j]);
            }
            Collections.sort(arrayList);
            answer[i] = arrayList.get(findIndex - 1);
        }
        return answer;
    }
}
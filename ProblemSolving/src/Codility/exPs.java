package Codility;

import java.util.HashSet;
import java.util.Set;

public class exPs {
    public static void main(String[] args) {
        int[][] As = {
                {1, 3, 6, 4, 1, 2},
                {1, 2, 3},
                {-1, -3}
        };
        for (int i = 0; i < As.length; i++) {
            System.out.println(solution(As[i]));
        }
    }

    public static int solution(int[] A) {
        Set<Integer> integerSet = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            integerSet.add(A[i]);
        }
        int answer = 1;
        while (integerSet.contains(answer)) {
            answer++;
        }
        return answer;
    }
}

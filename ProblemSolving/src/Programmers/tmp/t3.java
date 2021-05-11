package Programmers.tmp;

import java.util.ArrayList;
import java.util.List;

public class t3 {
    public static void main(String[] args) {
        int[][] maps = {
                {1, 28, 41, 22, 25, 79, 4},
                {39, 20, 10, 17, 19, 18, 8},
                {21, 4, 13, 12, 9, 29, 19},
                {58, 1, 20, 5, 8, 16, 9},
                {5, 6, 15, 2, 39, 8, 29},
                {39, 7, 17, 5, 4, 49, 5},
                {74, 46, 8, 11, 25, 2, 11}
        };
        int p = 19;
        int r = 6;
        System.out.println(solution(maps, p, r));
    }

    public static int solution(int[][] maps, int p, int r) {
        int answer = 0;
        for (int i = 0; i < maps.length + 1; i++) {
            for (int j = 0; j < maps.length + 1; j++) {
                int targetX = i;
                int targetY = j;
                int[][] range = new int[maps.length + 1][maps.length + 1];
                for (int k = 0; k < range.length; k++) {
                    for (int l = 0; l < range.length; l++) {
                        int halfR = r / 2;
                        if (Math.abs(targetX - k) + Math.abs(targetY - l) <= halfR) {
                            range[k][l] = 1;
                        }
                    }
                }
                List<Integer> yellow = new ArrayList<>();
                List<Integer> blue = new ArrayList<>();
                for (int k = 0; k < maps.length; k++) {
                    for (int l = 0; l < maps.length; l++) {
                        int yellowOrBlue = isYellowOrBlue(k, l, range);
                        if (yellowOrBlue == 1) {
                            yellow.add(maps[k][l]);
                        } else if (yellowOrBlue == 2) {
                            blue.add(maps[k][l]);
                        }
                    }
                }
                int sum = 0;
                for (int k = 0; k < yellow.size(); k++) {
                    if (yellow.get(k) <= p) {
                        sum++;
                    }
                }
                for (int k = 0; k < blue.size(); k++) {
                    if (blue.get(k) <= p / 2) {
                        sum++;
                    }
                }
                answer = Math.max(answer, sum);
            }
        }
        return answer;
    }

    private static int isYellowOrBlue(int k, int l, int[][] range) {
        int pointCount = 0;
        if (range[k][l] == 1) {
            pointCount++;
        }
        if (range[k + 1][l] == 1) {
            pointCount++;
        }
        if (range[k][l + 1] == 1) {
            pointCount++;
        }
        if (range[k + 1][l + 1] == 1) {
            pointCount++;
        }
        if (pointCount == 3) {
            return 2;
        } else if (pointCount == 4) {
            return 1;
        }
        return 0;
    }
}

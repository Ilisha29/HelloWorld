package BOJ;

import java.util.Scanner;

public class BOJ2096 {
    /*
    N줄에 0 이상 9 이하의 숫자가 세 개씩 적혀 있다. 내려가기 게임을 하고 있는데, 이 게임은 첫 줄에서 시작해서 마지막 줄에서 끝나게 되는 놀이이다.
    먼저 처음에 적혀 있는 세 개의 숫자 중에서 하나를 골라서 시작하게 된다. 그리고 다음 줄로 내려가는데,
    다음 줄로 내려갈 때에는 다음과 같은 제약 조건이 있다. 바로 아래의 수로 넘어가거나,
    아니면 바로 아래의 수와 붙어 있는 수로만 이동할 수 있다는 것이다. 이 제약 조건을 그림으로 나타내어 보면 다음과 같다.
    예제
    3
    1 2 3
    4 5 6
    4 9 0
    ========
    18 6
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] map = new int[N][3];
        int[][] answer1 = new int[N][3];
        int[][] answer2 = new int[N][3];
        int max = 0;
        int min = 0;
        //입력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        answer1[0][0] = map[0][0];
        answer1[0][1] = map[0][1];
        answer1[0][2] = map[0][2];

        answer2[0][0] = map[0][0];
        answer2[0][1] = map[0][1];
        answer2[0][2] = map[0][2];

        //최대 계산
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    if (answer1[i - 1][0] > answer1[i - 1][1]) {
                        answer1[i][j] += map[i][j] + answer1[i - 1][0];
                    } else {
                        answer1[i][j] += map[i][j] + answer1[i - 1][1];
                    }
                } else if (j == 1) {
                    int tmpMax = answer1[i - 1][0];
                    if (tmpMax < answer1[i - 1][1]) {
                        tmpMax = answer1[i - 1][1];
                    }
                    if (tmpMax < answer1[i - 1][2]) {
                        tmpMax = answer1[i - 1][2];
                    }
                    answer1[i][j] = map[i][j] + tmpMax;
                } else if (j == 2) {
                    if (answer1[i - 1][1] > answer1[i - 1][2]) {
                        answer1[i][j] += map[i][j] + answer1[i - 1][1];
                    } else {
                        answer1[i][j] += map[i][j] + answer1[i - 1][2];
                    }
                }
            }
        }

        if (answer1[N - 1][0] > answer1[N - 1][1]) {
            max = answer1[N - 1][0];
        } else {
            max = answer1[N - 1][1];
        }
        if (max < answer1[N - 1][2]) {
            max = answer1[N - 1][2];
        }
        System.out.print(max + " ");


        //최소 계산
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    if (answer2[i - 1][0] > answer2[i - 1][1]) {
                        answer2[i][j] += map[i][j] + answer2[i - 1][1];
                    } else {
                        answer2[i][j] += map[i][j] + answer2[i - 1][0];
                    }
                } else if (j == 1) {
                    int tmpMin = answer2[i - 1][0];
                    if (tmpMin > answer2[i - 1][1]) {
                        tmpMin = answer2[i - 1][1];
                    }
                    if (tmpMin > answer2[i - 1][2]) {
                        tmpMin = answer2[i - 1][2];
                    }
                    answer2[i][j] = map[i][j] + tmpMin;
                } else if (j == 2) {
                    if (answer2[i - 1][1] < answer2[i - 1][2]) {
                        answer2[i][j] += map[i][j] + answer2[i - 1][1];
                    } else {
                        answer2[i][j] += map[i][j] + answer2[i - 1][2];
                    }
                }
            }
        }

        if (answer2[N - 1][0] > answer2[N - 1][1]) {
            min = answer2[N - 1][1];
        } else {
            min = answer2[N - 1][0];
        }

        if (min > answer2[N - 1][2]) {
            min = answer2[N - 1][2];
        }
        System.out.println(min);


        /*
        회고 : 알고리즘 파악은 30분 걸렸다......
        결국 로직은 맞았었는데.....
        구현하는데 2시간 10분이 걸렸다.......
        구현능력부족......
        */
    }
}

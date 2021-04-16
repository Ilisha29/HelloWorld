package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 22 : 07 start
public class BOJ14500 {
    static int[][] map;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int row = Integer.parseInt(stringTokenizer.nextToken());
        int col = Integer.parseInt(stringTokenizer.nextToken());
        map = new int[row + 20 ][col + 20];
        for (int i = 10; i < row+10; i++) {
            StringTokenizer stringTokenizer1 = new StringTokenizer(bufferedReader.readLine());
            for (int j = 10; j < col + 10; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer1.nextToken());
            }
        }
        //==========================입력 끝==========================

        answer = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                ㅁ모양(i, j);
                ㅡ모양(i, j);
                ㅣ모양(i, j);
                ㅜ모양(i, j);
                ㅓ모양(i, j);
                ㅗ모양(i, j);
                ㅏ모양(i, j);
                L11모양(i, j);
                L12모양(i, j);
                L13모양(i, j);
                L14모양(i, j);
                L21모양(i, j);
                L22모양(i, j);
                L23모양(i, j);
                L24모양(i, j);
                ㄹ1모양(i, j);
                ㄹ2모양(i, j);
                ㄹ3모양(i, j);
                ㄹ4모양(i, j);
            }
        }
        System.out.println(answer);
        bufferedReader.close();
    }

    private static void ㄹ4모양(int i, int j) {
        int[] X = {i, i, i - 1, i - 1};
        int[] Y = {j, j + 1, j + 1, j + 2};
        for (int k = 0; k < 4; k++) {
            if (0 > X[k] || X[k] >= map.length || 0 > Y[k] || Y[k] >= map[0].length) {
                return;
            }
        }
        int tmpAnswer = 0;
        for (int k = 0; k < 4; k++) {
            tmpAnswer += map[X[k]][Y[k]];
        }
        answer = tmpAnswer > answer ? tmpAnswer : answer;
    }

    private static void ㄹ3모양(int i, int j) {
        int[] X = {i, i + 1, i + 1, i + 2};
        int[] Y = {j, j, j + 1, j + 1};
        for (int k = 0; k < 4; k++) {
            if (0 > X[k] || X[k] >= map.length || 0 > Y[k] || Y[k] >= map[0].length) {
                return;
            }
        }
        int tmpAnswer = 0;
        for (int k = 0; k < 4; k++) {
            tmpAnswer += map[X[k]][Y[k]];
        }
        answer = tmpAnswer > answer ? tmpAnswer : answer;
    }

    private static void ㄹ2모양(int i, int j) {
        int[] X = {i, i + 1, i + 1, i + 2};
        int[] Y = {j, j, j - 1, j - 1};
        for (int k = 0; k < 4; k++) {
            if (0 > X[k] || X[k] >= map.length || 0 > Y[k] || Y[k] >= map[0].length) {
                return;
            }
        }
        int tmpAnswer = 0;
        for (int k = 0; k < 4; k++) {
            tmpAnswer += map[X[k]][Y[k]];
        }
        answer = tmpAnswer > answer ? tmpAnswer : answer;
    }

    private static void ㄹ1모양(int i, int j) {
        int[] X = {i, i, i + 1, i + 1};
        int[] Y = {j, j + 1, j + 1, j + 2};
        for (int k = 0; k < 4; k++) {
            if (0 > X[k] || X[k] >= map.length || 0 > Y[k] || Y[k] >= map[0].length) {
                return;
            }
        }
        int tmpAnswer = 0;
        for (int k = 0; k < 4; k++) {
            tmpAnswer += map[X[k]][Y[k]];
        }
        answer = tmpAnswer > answer ? tmpAnswer : answer;
    }

    private static void L24모양(int i, int j) {
        int[] X = {i, i, i, i + 1};
        int[] Y = {j, j + 1, j + 2, j + 2};
        for (int k = 0; k < 4; k++) {
            if (0 > X[k] || X[k] >= map.length || 0 > Y[k] || Y[k] >= map[0].length) {
                return;
            }
        }
        int tmpAnswer = 0;
        for (int k = 0; k < 4; k++) {
            tmpAnswer += map[X[k]][Y[k]];
        }
        answer = tmpAnswer > answer ? tmpAnswer : answer;
    }

    private static void L23모양(int i, int j) {
        int[] X = {i, i, i + 1, i + 2};
        int[] Y = {j, j + 1, j, j};
        for (int k = 0; k < 4; k++) {
            if (0 > X[k] || X[k] >= map.length || 0 > Y[k] || Y[k] >= map[0].length) {
                return;
            }
        }
        int tmpAnswer = 0;
        for (int k = 0; k < 4; k++) {
            tmpAnswer += map[X[k]][Y[k]];
        }
        answer = tmpAnswer > answer ? tmpAnswer : answer;
    }

    private static void L22모양(int i, int j) {
        int[] X = {i, i + 1, i + 1, i + 1};
        int[] Y = {j, j, j + 1, j + 2};
        for (int k = 0; k < 4; k++) {
            if (0 > X[k] || X[k] >= map.length || 0 > Y[k] || Y[k] >= map[0].length) {
                return;
            }
        }
        int tmpAnswer = 0;
        for (int k = 0; k < 4; k++) {
            tmpAnswer += map[X[k]][Y[k]];
        }
        answer = tmpAnswer > answer ? tmpAnswer : answer;
    }

    private static void L21모양(int i, int j) {
        int[] X = {i, i, i - 1, i - 2};
        int[] Y = {j, j + 1, j + 1, j + 1};
        for (int k = 0; k < 4; k++) {
            if (0 > X[k] || X[k] >= map.length || 0 > Y[k] || Y[k] >= map[0].length) {
                return;
            }
        }
        int tmpAnswer = 0;
        for (int k = 0; k < 4; k++) {
            tmpAnswer += map[X[k]][Y[k]];
        }
        answer = tmpAnswer > answer ? tmpAnswer : answer;
    }

    private static void L14모양(int i, int j) {
        int[] X = {i, i, i, i - 1};
        int[] Y = {j, j + 1, j + 2, j + 2};
        for (int k = 0; k < 4; k++) {
            if (0 > X[k] || X[k] >= map.length || 0 > Y[k] || Y[k] >= map[0].length) {
                return;
            }
        }
        int tmpAnswer = 0;
        for (int k = 0; k < 4; k++) {
            tmpAnswer += map[X[k]][Y[k]];
        }
        answer = tmpAnswer > answer ? tmpAnswer : answer;
    }

    private static void L13모양(int i, int j) {
        int[] X = {i, i, i + 1, i + 2};
        int[] Y = {j, j + 1, j + 1, j + 1};
        for (int k = 0; k < 4; k++) {
            if (0 > X[k] || X[k] >= map.length || 0 > Y[k] || Y[k] >= map[0].length) {
                return;
            }
        }
        int tmpAnswer = 0;
        for (int k = 0; k < 4; k++) {
            tmpAnswer += map[X[k]][Y[k]];
        }
        answer = tmpAnswer > answer ? tmpAnswer : answer;
    }

    private static void L12모양(int i, int j) {
        int[] X = {i, i, i, i + 1};
        int[] Y = {j, j + 1, j + 2, j};
        for (int k = 0; k < 4; k++) {
            if (0 > X[k] || X[k] >= map.length || 0 > Y[k] || Y[k] >= map[0].length) {
                return;
            }
        }
        int tmpAnswer = 0;
        for (int k = 0; k < 4; k++) {
            tmpAnswer += map[X[k]][Y[k]];
        }
        answer = tmpAnswer > answer ? tmpAnswer : answer;
    }

    private static void L11모양(int i, int j) {
        int[] X = {i, i + 1, i + 2, i + 2};
        int[] Y = {j, j, j, j + 1};
        for (int k = 0; k < 4; k++) {
            if (0 > X[k] || X[k] >= map.length || 0 > Y[k] || Y[k] >= map[0].length) {
                return;
            }
        }
        int tmpAnswer = 0;
        for (int k = 0; k < 4; k++) {
            tmpAnswer += map[X[k]][Y[k]];
        }
        answer = tmpAnswer > answer ? tmpAnswer : answer;
    }

    private static void ㅏ모양(int i, int j) {
        int[] X = {i, i + 1, i + 2, i + 1};
        int[] Y = {j, j, j, j + 1};
        for (int k = 0; k < 4; k++) {
            if (0 > X[k] || X[k] >= map.length || 0 > Y[k] || Y[k] >= map[0].length) {
                return;
            }
        }
        int tmpAnswer = 0;
        for (int k = 0; k < 4; k++) {
            tmpAnswer += map[X[k]][Y[k]];
        }
        answer = tmpAnswer > answer ? tmpAnswer : answer;
    }

    private static void ㅗ모양(int i, int j) {
        int[] X = {i, i + 1, i + 1, i + 1};
        int[] Y = {j, j - 1, j, j + 1};
        for (int k = 0; k < 4; k++) {
            if (0 > X[k] || X[k] >= map.length || 0 > Y[k] || Y[k] >= map[0].length) {
                return;
            }
        }
        int tmpAnswer = 0;
        for (int k = 0; k < 4; k++) {
            tmpAnswer += map[X[k]][Y[k]];
        }
        answer = tmpAnswer > answer ? tmpAnswer : answer;
    }

    private static void ㅓ모양(int i, int j) {
        int[] X = {i, i + 1, i + 2, i + 1};
        int[] Y = {j, j, j, j - 1};
        for (int k = 0; k < 4; k++) {
            if (0 > X[k] || X[k] >= map.length || 0 > Y[k] || Y[k] >= map[0].length) {
                return;
            }
        }
        int tmpAnswer = 0;
        for (int k = 0; k < 4; k++) {
            tmpAnswer += map[X[k]][Y[k]];
        }
        answer = tmpAnswer > answer ? tmpAnswer : answer;
    }

    private static void ㅜ모양(int i, int j) {
        int[] X = {i, i, i, i + 1};
        int[] Y = {j, j + 1, j + 2, j + 1};
        for (int k = 0; k < 4; k++) {
            if (0 > X[k] || X[k] >= map.length || 0 > Y[k] || Y[k] >= map[0].length) {
                return;
            }
        }
        int tmpAnswer = 0;
        for (int k = 0; k < 4; k++) {
            tmpAnswer += map[X[k]][Y[k]];
        }
        answer = tmpAnswer > answer ? tmpAnswer : answer;
    }

    private static void ㅣ모양(int i, int j) {
        int[] X = {i, i + 1, i + 2, i + 3};
        for (int k = 0; k < 4; k++) {
            if (0 > X[k] || X[k] >= map.length) {
                return;
            }
        }
        int tmpAnswer = 0;
        for (int k = 0; k < 4; k++) {
            tmpAnswer += map[X[k]][j];
        }
        answer = tmpAnswer > answer ? tmpAnswer : answer;
    }

    private static void ㅡ모양(int i, int j) {
        int[] Y = {j, j + 1, j + 2, j + 3};
        for (int k = 0; k < 4; k++) {
            if (0 > Y[k] || Y[k] >= map[0].length) {
                return;
            }
        }
        int tmpAnswer = 0;
        for (int k = 0; k < 4; k++) {
            tmpAnswer += map[i][Y[k]];
        }
        answer = tmpAnswer > answer ? tmpAnswer : answer;
    }

    private static void ㅁ모양(int x, int y) {
        int[] X = {x, x, x + 1, x + 1};
        int[] Y = {y, y + 1, y, y + 1};
        for (int i = 0; i < 4; i++) {
            if (0 > X[i] || X[i] >= map.length || 0 > Y[i] || Y[i] >= map[0].length) {
                return;
            }
        }
        int tmpAnswer = 0;
        for (int i = 0; i < 4; i++) {
            tmpAnswer += map[X[i]][Y[i]];
        }
        answer = tmpAnswer > answer ? tmpAnswer : answer;
    }
}
// 23 : 17 end

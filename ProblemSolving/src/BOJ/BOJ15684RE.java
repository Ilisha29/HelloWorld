package BOJ;

import java.util.Scanner;

public class BOJ15684RE {
    static int N;
    static int M;
    static int H;
    static int minCnt = 9999;
    static int[][] array;
    static int[][] same;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        H = sc.nextInt();
        array = new int[H + 1][N + 1];
        same = new int[M][2];

        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            array[x][y] = 1;
        }

//		for (int h = 1; h <= H; h++) {
//			for (int g = 1; g <= N; g++) {
//				System.out.print(array[h][g]);
//			}
//			System.out.println();
//		}
        if (Check()) {
            System.out.println(0);
            System.exit(0);
        }

        for (int i = 1; i <= H; i++	) {
            for (int j = 1; j <= N - 1; j++) {
                if (array[i][j] == 1) {
                    j++;
                    continue;
                }
                array[i][j] = 1;
                Find(1, i, j);
                array[i][j] = 0;
            }
        }
        if (minCnt > 3)
            minCnt = -1;
        System.out.println(minCnt);
    }

    static boolean Check() {
        for (int i = 1; i <= N; i++) {
            int loc = i;
            for (int j = 1; j <= H; j++) {
                if (array[j][loc] == 1)
                    loc++;
                else if (array[j][loc - 1] == 1)
                    loc--;
            }
            if (loc != i)
                return false;
        }
        return true;
    }

    static void Find(int cnt, int x, int y) {

        //이미 minCnt를 발견하면 나간다.
        if (cnt >= minCnt)
            return;

        //1,2,3에서 걸리면 나간다.
        if (Check()) {
            minCnt = cnt;
            return;
        }

        //3까지도 답이 없으면 벗어난다.
        if (cnt == 3) {
            return;
        }

        int newX = x;
        int newY = y;

        for (int i = newX; i <= H; i++, newY = 1) {
            for (int j = newY; j <= N - 1; j++) {
                if (array[i][j] == 1) {
                    j++;
                    continue;
                }

                array[i][j] = 1;
                Find(cnt + 1, i, j + 2);
                array[i][j] = 0;
            }
        }
    }
}

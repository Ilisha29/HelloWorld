import java.util.Scanner;

public class BOJ14502 {
    /*
    8 8
2 0 0 0 0 0 0 2
2 0 0 0 0 0 0 2
2 0 0 0 0 0 0 2
2 0 0 0 0 0 0 2
2 0 0 0 0 0 0 2
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
     */
    //벽세우기
    //감염시키기
    //안전공간 세기
    static int[][] map;

    static int[][] wall(int[][] copyMap, int wallNum) {
        return copyMap;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[N][M] = scanner.nextInt();
            }
        }
        int wallNum = 0;
        int maxSafe = 0;
        int[][] copyMap =  map;

        wall(copyMap, wallNum);


    }
}

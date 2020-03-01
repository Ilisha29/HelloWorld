import java.util.Scanner;

public class BOJ1932 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        /*
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        */
        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    map[i][j] += map[i - 1][j];
                } else if (j == i) {
                    map[i][j] += map[i - 1][j - 1];
                } else {
                    if (map[i][j] + map[i - 1][j - 1] > (map[i][j] + map[i - 1][j])) {
                        map[i][j] += map[i - 1][j - 1];
                    } else {
                        map[i][j] += map[i - 1][j];
                    }
                }
            }
        }
        /*
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        */
        int max = map[N-1][0];
        for (int i = 1; i < N ; i++) {
            if(map[N-1][i] > max){
                max = map[N-1][i];
            }
        }
        System.out.println(max);
    }
}


package KAKAO;

// 14 : 00
public class KAKAO2020_자물쇠와_열쇠 {
    static int M;
    static int N;
    static int L;

    public static void main(String[] args) {
        boolean answer = false;
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1, 0}, {1, 1, 0, 0}, {1, 0, 1, 1}, {1, 0, 1, 0}};

        M = key.length;
        N = lock.length;
        L = 3 * N;
        int[][] newLock = new int[L][L];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                newLock[N + i][N + j] = lock[i][j];
            }
        }

        for (int i = 0; i < 4; i++) {
            if (answer) break;
            for (int j = 0; j <= 2 * N; j++) {
                for (int k = 0; k <= 2 * N; k++) {

                    for (int l = 0; l < M; l++) {
                        for (int m = 0; m < M; m++) {
                            newLock[l + j][m + k] += key[l][m];
                        }
                    }

                    int oneNum = 0;
                    for (int l = N; l < 2 * N; l++) {
                        for (int m = N; m < 2 * N; m++) {
                            if (newLock[l][m] == 0 || newLock[l][m] == 2) {
                                break;
                            }
                            if (newLock[l][m] == 1) {
                                oneNum++;
                            }
                        }
                    }
                    if (oneNum == N * N) {
                        answer = true;
                        System.out.println("찾음");
                    }

                    for (int l = 0; l < M; l++) {
                        for (int m = 0; m < M; m++) {
                            newLock[l + j][m + k] -= key[l][m];
                        }
                    }
                }
            }
            key = ClockWise(key);
        }
        System.out.println(answer);
    }

    private static int[][] ClockWise(int[][] key) {
        int[][] tmpKey = new int[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                tmpKey[j][M - 1 - i] = key[i][j];
            }
        }
        for (int i = 0; i < tmpKey.length; i++) {
            key[i] = tmpKey[i].clone();
        }
        return key;
    }
}

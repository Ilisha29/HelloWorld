package KAKAO.KAKAO2020공채;

// 01 : 05
public class KAKAO2020공채_자물쇠와_열쇠_2nd {
    public static void main(String[] args) {
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(solution(key, lock));
    }

    public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int[][] newLcck = new int[lock.length + 2 * key.length][lock.length + 2 * key.length];
        for (int i = key.length; i < key.length + lock.length; i++) {
            for (int j = key.length; j < key.length + lock.length; j++) {
                newLcck[i][j] = lock[i - key.length][j - key.length];
            }
        }
        for (int i = 0; i <= newLcck.length - key.length; i++) {
            for (int j = 0; j <= newLcck.length - key.length; j++) {
                for (int k = 0; k < 4; k++) {
                    ClockWise(key);
                    for (int l = i; l < i + key.length; l++) {
                        for (int m = j; m < j + key.length; m++) {
                            newLcck[l][m] += key[l - i][m - j];
                        }
                    }
                    int oneNum = 0;
                    for (int l = key.length; l < key.length + lock.length; l++) {
                        for (int m = key.length; m < key.length + lock.length; m++) {
                            if (newLcck[l][m] == 1) {
                                oneNum++;
                            }
                        }
                    }
                    if (oneNum == lock.length * lock.length) {
                        return true;
                    }
                    for (int l = i; l < i + key.length; l++) {
                        for (int m = j; m < j + key.length; m++) {
                            newLcck[l][m] -= key[l - i][m - j];
                        }
                    }
                }
            }
        }
        for (int i = 0; i < newLcck.length; i++) {
            for (int j = 0; j < newLcck.length; j++) {
                System.out.print(newLcck[i][j]);
            }
            System.out.println();
        }
        return answer;

    }

    private static void ClockWise(int[][] key) {
        int[][] tmp = new int[key.length][key.length];
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                tmp[i][j] = key[key.length - 1 - j][i];
            }
        }
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                key[i][j] = tmp[i][j];
            }
        }
    }
}
// 01 : 28 end // 23분
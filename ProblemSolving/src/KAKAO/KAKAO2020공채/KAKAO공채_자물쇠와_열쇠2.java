package KAKAO.KAKAO2020공채;

public class KAKAO공채_자물쇠와_열쇠2 {
    public static void main(String[] args) {
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(solution(key, lock));
    }

    public static boolean solution(int[][] key, int[][] lock) {
        int lockMapSize = lock.length + 2 * (key.length - 1);
        int[][] newLock = new int[lockMapSize][lockMapSize];
        int x = 0;
        System.out.println(key.length);
        for (int i = key.length; i < key.length + lock.length; i++) {
            int y = 0;
            for (int j = key.length; j < key.length + lock.length; j++) {
                newLock[i - 1][j - 1] = lock[x][y];
                y++;
            }
            x++;
        }
        for (int i = 0; i < key.length + lock.length - 1; i++) {
            for (int j = 0; j < key.length + lock.length - 1; j++) {
                for (int z = 0; z < 4; z++) {
                    //check
                    ///더하기
                    for (int k = 0; k < key.length; k++) {
                        for (int l = 0; l < key.length; l++) {
                            newLock[i + k][j + l] += key[k][l];
                        }
                    }
                    ///답체크
                    if (isAnswer(newLock, key.length, lock.length)) {
                        return true;
                    }
                    ///빼기
                    for (int k = 0; k < key.length; k++) {
                        for (int l = 0; l < key.length; l++) {
                            newLock[i + k][j + l] -= key[k][l];
                        }
                    }
                    //rotate
                    key = rotateKey(key);
                }
            }
        }
        return false;
    }

    private static boolean isAnswer(int[][] newLock, int keyLength, int lockLength) {
        for (int i = 0; i < lockLength; i++) {
            for (int j = 0; j < lockLength; j++) {
                if (newLock[keyLength + i - 1][keyLength + j - 1] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[][] rotateKey(int[][] key) {
        int[][] newKey = new int[key.length][key.length];
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                newKey[j][key.length - 1 - i] = key[i][j];
            }
        }
        return newKey;
    }
}

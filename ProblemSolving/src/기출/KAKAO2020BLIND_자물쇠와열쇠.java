package 기출;

public class KAKAO2020BLIND_자물쇠와열쇠 {
    public static void main(String[] args) {
        int[][] key = {{0, 1, 0, 0}, {1, 1, 0, 0}, {0, 1, 0, 1}, {1, 0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        boolean answer = false;
        System.out.println(key.length);

        antiClockWise(key);

        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock.length; j++) {
                for (int k = 0; k < 4; k++) {
                    antiClockWise(key);
                    isPossibleCheck(i, j, key, lock, answer);
                }
            }
        }


        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                System.out.println(key[i][j]);
            }
        }
        System.out.println(answer);
    }
    //Key가 lock위의 움직임

    //Key와 lock비교
    private static boolean isPossibleCheck(int i, int j, int[][] key, int[][] lock, boolean answer) {
        for (int k = i; k < lock.length; k++) {
            for (int l = j; l < lock.length; l++) {
                if (1 != (lock[k][l] ^ key[k - i][l - j])) {
                    answer = false;
                }
            }
        }
        return answer;
    }


    //Key 반시계 회전
    private static int[][] antiClockWise(int[][] key) {
        int[][] copyKey = new int[key.length][key.length];
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                copyKey[i][j] = key[i][j];
            }
        }

        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                key[i][j] = copyKey[j][key.length - 1 - i];
            }
        }
        return key;
    }
}

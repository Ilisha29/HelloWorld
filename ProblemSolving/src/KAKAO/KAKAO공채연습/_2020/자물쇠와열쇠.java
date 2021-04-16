package KAKAO.KAKAO공채연습._2020;

public class 자물쇠와열쇠 {
    public static void main(String[] args) {
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(solution(key, lock));
    }

    public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int new_size = lock.length + 2 * key.length;
        int[][] new_map = new int[new_size][new_size];
        int X = 0;
        int Y = 0;
        for (int i = key.length; i < key.length + lock.length; i++) {
            Y = 0;
            for (int j = key.length; j < key.length + lock.length; j++) {
                new_map[i][j] = lock[X][Y];
                Y++;
            }
            X++;
        }
        for (int i = 0; i <= key.length + lock.length; i++) {
            for (int j = 0; j <= key.length + lock.length; j++) {
                for (int a = 0; a < 4; a++) {
                    for (int k = 0; k < key.length; k++) {
                        for (int l = 0; l < key.length; l++) {
                            new_map[i + k][j + l] += key[k][l];
                        }
                    }

                    ////2.열릴 가능성 체크
                    boolean is_all_one = true;
                    for (int k = key.length; k < key.length + lock.length; k++) {
                        for (int l = key.length; l < key.length + lock.length; l++) {
                            if (new_map[k][l] != 1) {
                                is_all_one = false;
                                break;
                            }
                        }
                    }
                    if (is_all_one)
                        return true;
                    /////2.

                    ///3. 다시 초기환
                    for (int k = 0; k < key.length; k++) {
                        for (int l = 0; l < key.length; l++) {
                            new_map[i + k][j + l] -= key[k][l];
                        }
                    }
                    ////3.
                    circulation(key);
                }
            }
        }
        return answer;
    }

    public static void circulation(int[][] key) {
        int length = key.length;
        int[][] new_key = new int[length][length];
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                new_key[i][j] = key[length - 1 - j][i];
            }
        }
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                key[i][j] = new_key[i][j];
            }
        }
    }
}

// 구현 (45분)

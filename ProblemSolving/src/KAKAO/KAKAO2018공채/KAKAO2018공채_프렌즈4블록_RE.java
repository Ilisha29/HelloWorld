package KAKAO.KAKAO2018공채;

import java.util.LinkedList;
import java.util.Queue;

// 18 : 44 start
public class KAKAO2018공채_프렌즈4블록_RE {
    public static void main(String[] args) {
        int m = 6;
        int n = 6;
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        System.out.println(solution(m, n, board));
    }

    public static int solution(int m, int n, String[] board) {
        String[][] map = new String[m][n];
        int answer = 0;
        for (int i = 0; i < map.length; i++) {
            String[] strings = board[i].split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = strings[j];
            }
        }

        while (true) {
            boolean[][] visit = new boolean[m][n];
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    String kakaos = map[i][j];
                    int sameNum = 4;
                    if (kakaos != " ") {
                        for (int k = 0; k < 2; k++) {
                            for (int l = 0; l < 2; l++) {
                                if (map[i + k][j + l].equals(kakaos)) {
                                    sameNum--;
                                }
                            }
                        }
                    }
                    if (sameNum == 0) {
                        for (int k = 0; k < 2; k++) {
                            for (int l = 0; l < 2; l++) {
                                visit[i + k][j + l] = true;
                            }
                        }
                    }

                }
            }

            int tmpAnswer = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (visit[i][j]) {
                        map[i][j] = " ";
                        tmpAnswer++;
                    }
                }
            }

            if (tmpAnswer == 0) {
                break;
            } else {
                answer += tmpAnswer;
            }

            for (int i = 0; i < n; i++) {
                Queue<String> queue = new LinkedList<>();
                for (int j = m - 1; j >= 0; j--) {
                    if (!map[j][i].equals(" ")) {
                        queue.offer(map[j][i]);
                        map[j][i] = " ";
                    }
                }
                int index = m - 1;
                while (!queue.isEmpty()) {
                    map[index--][i] = queue.poll();
                }
            }

        }

        return answer;
    }
}
// 19 : 30 // 45분걸림;;;;; 너무 조건을 좀 이상하게 생각했다....
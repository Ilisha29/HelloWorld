package KAKAO.KAKAO2018공채;

import java.util.LinkedList;
import java.util.Queue;

// 16 : 49
public class KAKAO2018공채_프렌즈4블록 {
    public static void main(String[] args) {

        int m = 4; //높이
        int n = 5; //폭
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        /*
        int m = 6;
        int n = 6;
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        */
        System.out.println(solution(m, n, board));
    }

    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        String[][] strings = new String[m][n];
        for (int i = 0; i < m; i++) {
            String[] kakaos = board[i].split("");
            for (int j = 0; j < n; j++) {
                strings[i][j] = kakaos[j];
            }
        }
        while (true) {
            //지워질수 있는거 찾기
            boolean[][] visited = new boolean[m][n];
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    String search = strings[i][j];
                    int num = 4;
                    if (search != " ") {
                        for (int k = 0; k < 2; k++) {
                            for (int l = 0; l < 2; l++) {
                                if (strings[i + k][j + l].equals(search)) {
                                    num--;
                                }
                            }
                        }
                    }
                    if (num == 0) {
                        for (int k = 0; k < 2; k++) {
                            for (int l = 0; l < 2; l++) {
                                visited[i + k][j + l] = true;
                            }
                        }
                    }
                }
            }

            //지워지는거 계산
            int trueNum = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j]) {
                        trueNum++;
                        strings[i][j] = " ";
                    }
                }
            }
            if (trueNum == 0) {
                break;
            } else {
                answer += trueNum;
            }

            //빈칸없애기
            for (int i = 0; i < n; i++) {
                Queue<String> queue = new LinkedList<>();
                for (int j = m - 1; j >= 0; j--) {
                    if (strings[j][i] != " ") {
                        queue.offer(strings[j][i]);
                        strings[j][i] = " ";
                    }
                }
                int index = m - 1;
                while (!queue.isEmpty()) {
                    strings[index--][i] = queue.poll();
                }
            }
        }
        return answer;
    }
}
// 17 : 25 // 35분정도 걸림
package KAKAO.KAKAO2019공채;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// 13 : 28 start
public class KAKAO2019_블록게임 {
    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 6, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 6, 0, 0, 0, 0, 0, 0, 0},
                {0, 6, 6, 0, 0, 0, 4, 0, 0, 0},
                {0, 0, 0, 0, 0, 4, 4, 0, 0, 0},
                {0, 0, 0, 0, 3, 0, 4, 0, 0, 0},
                {0, 0, 0, 2, 3, 0, 0, 0, 5, 5},
                {1, 2, 2, 2, 3, 3, 0, 0, 0, 5},
                {1, 1, 1, 0, 0, 0, 0, 0, 0, 5}};
        System.out.println(solution(board));
    }

    private static int solution(int[][] board) {
        int answer = 0;
        int X = board.length;
        int Y = board[0].length;
        while (true) {
            int tmpAnswer = 0;
            //블랙 블럭 한줄 뿌리기
            ArrayList<Block> blockArrayList = new ArrayList<Block>();
            for (int i = 0; i < Y; i++) {
                for (int j = 0; j < X; j++) {
                    if (board[j][i] != 0) {
                        break;
                    } else {
                        board[j][i] = -1;
                        blockArrayList.add(new Block(j, i));
                    }
                }
            }
            //2*3 체크
            for (int i = 0; i < board.length - 1; i++) {
                for (int j = 0; j < board[0].length - 2; j++) {
                    int[][] twoTreeBlock = new int[2][3];
                    twoTreeBlock[0][0] = board[i][j];
                    twoTreeBlock[0][1] = board[i][j + 1];
                    twoTreeBlock[0][2] = board[i][j + 2];
                    twoTreeBlock[1][0] = board[i + 1][j];
                    twoTreeBlock[1][1] = board[i + 1][j + 1];
                    twoTreeBlock[1][2] = board[i + 1][j + 2];
                    if (isCanEraseCase(twoTreeBlock)) {
                        tmpAnswer++;
                        board[i][j] = 0;
                        board[i][j + 1] = 0;
                        board[i][j + 2] = 0;
                        board[i + 1][j] = 0;
                        board[i + 1][j + 1] = 0;
                        board[i + 1][j + 2] = 0;
                    }
                }
            }
            //3*2 체크
            for (int i = 0; i < board.length - 2; i++) {
                for (int j = 0; j < board[0].length - 1; j++) {
                    int[][] threeTwoBlock = new int[3][2];
                    threeTwoBlock[0][0] = board[i][j];
                    threeTwoBlock[0][1] = board[i][j + 1];
                    threeTwoBlock[1][0] = board[i + 1][j];
                    threeTwoBlock[1][1] = board[i + 1][j + 1];
                    threeTwoBlock[2][0] = board[i + 2][j];
                    threeTwoBlock[2][1] = board[i + 2][j + 1];
                    if (isCanEraseCase(threeTwoBlock)) {
                        tmpAnswer++;
                        board[i][j] = 0;
                        board[i][j + 1] = 0;
                        board[i + 1][j] = 0;
                        board[i + 1][j + 1] = 0;
                        board[i + 2][j] = 0;
                        board[i + 2][j + 1] = 0;
                    }
                }
            }
            if (tmpAnswer == 0) {
                break;
            }
            answer += tmpAnswer;
            //뿌렸던 블럭 제거
            for (int i = 0; i < blockArrayList.size(); i++) {
                Block block = blockArrayList.get(i);
                board[block.x][block.y] = 0;
            }
        }
        return answer;
    }

    private static boolean isCanEraseCase(int[][] tmpBlock) {
        Set<Integer> set = new HashSet<>();
        int minusCount = 0;
        for (int i = 0; i < tmpBlock.length; i++) {
            for (int j = 0; j < tmpBlock[0].length; j++) {
                set.add(tmpBlock[i][j]);
                if (tmpBlock[i][j] == -1) {
                    minusCount++;
                }
            }
        }
        if (minusCount != 2) {
            return false;
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (Integer i : set) {
            arrayList.add(i);
        }
        if (arrayList.size() != 2) {
            return false;
        }
        Collections.sort(arrayList);
        if (arrayList.get(0) == -1 && arrayList.get(1) != 0) {
            return true;
        }
        return false;
    }
}

class Block {
    int x;
    int y;

    public Block(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
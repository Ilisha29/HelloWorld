package KAKAO.KAKAO2019윈터인턴.prac1;

import java.util.Stack;

public class K1 {
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        System.out.println(solution(board, moves));
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer>[] stacks = new Stack[board.length];
        for (int i = 0; i < stacks.length; i++) {
            stacks[i] = new Stack<>();
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != 0)
                    stacks[j].add(board[i][j]);
            }
        }
        for (int i = 0; i < moves.length; i++) {
            int stackIndex = moves[i] - 1;
            if (stacks[stackIndex].isEmpty())
                continue;
            int num = stacks[stackIndex].pop();
            if (stack.isEmpty()) {
                stack.add(num);
            } else {
                if (stack.peek() != num) {
                    stack.add(num);
                } else {
                    answer += 2;
                    stack.pop();
                }
            }
        }
        return answer;
    }
}

package KAKAO.KAKAO2019윈터인턴;

import java.util.Stack;

// 13 : 25 stack 잘못씀..
// 14 : 23 new Start
public class 크레인_인형뽑기 {
    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        System.out.println(solution(board, moves));
    }

    static Stack<Integer> integerStack;

    private static int solution(int[][] board, int[] moves) {
        int answer = 0;
        int N = board.length;
        integerStack = new Stack<>();
        int[] arrayIndex = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[j][i] != 0) {
                    arrayIndex[i] = j;
                    break;
                }
            }
        }

        for (int i = 0; i < moves.length; i++) {
            int col = moves[i] - 1;
            int row = arrayIndex[col];
            int popedNum = 0;
            if (board[row][col] == 0) {
                continue;
            } else {
                popedNum = board[row][col];
                board[row][col] = 0;
                if (row != N - 1) {
                    arrayIndex[col]++;
                }
            }
            if (integerStack.isEmpty()) {
                integerStack.push(popedNum);
            } else {
                int tmpNum = integerStack.peek();
                if (tmpNum == popedNum) {
                    answer += 2;
                    integerStack.pop();
                } else {
                    integerStack.push(popedNum);
                }
            }
        }
        return answer;
    }


    /*static int size;
    static Stack<Integer> stack1;
    static Stack<Integer> stack2;
    static Stack<Integer> stack3;
    static Stack<Integer> stack4;
    static Stack<Integer> stack5;
    static Stack<Integer> answerStack;

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        size = board.length;
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        stack3 = new Stack<>();
        stack4 = new Stack<>();
        stack5 = new Stack<>();
        answerStack = new Stack<>();
        for (int i = 0; i < size; i++) {
            for (int j = size - 1; j >= 0; j--) {
                if (i == 0) {
                    if (board[j][i] == 0) {
                        break;
                    } else {
                        stack1.push(board[j][i]);
                    }
                } else if (i == 1) {
                    if (board[j][i] == 0) {
                        break;
                    } else {
                        stack2.push(board[j][i]);
                    }
                } else if (i == 2) {
                    if (board[j][i] == 0) {
                        break;
                    } else {
                        stack3.push(board[j][i]);
                    }
                } else if (i == 3) {
                    if (board[j][i] == 0) {
                        break;
                    } else {
                        stack4.push(board[j][i]);
                    }
                } else {
                    if (board[j][i] == 0) {
                        break;
                    } else {
                        stack5.push(board[j][i]);
                    }
                }
            }
        }

        for (int i = 0; i < moves.length; i++) {
            int popedNum = 0;
            if (moves[i] == 1) {
                if (stack1.isEmpty()) continue;
                popedNum = stack1.pop();
            } else if (moves[i] == 2) {
                if (stack2.isEmpty()) continue;
                popedNum = stack2.pop();
            } else if (moves[i] == 3) {
                if (stack3.isEmpty()) continue;
                popedNum = stack3.pop();
            } else if (moves[i] == 4) {
                if (stack4.isEmpty()) continue;
                popedNum = stack4.pop();
            } else {
                if (stack5.isEmpty()) continue;
                popedNum = stack5.pop();
            }

            if (answerStack.isEmpty()) {
                answerStack.push(popedNum);
            } else {
                int tmpNum = answerStack.peek();
                if (tmpNum == popedNum) {
                    answer += 2;
                    answerStack.pop();
                } else {
                    answerStack.push(popedNum);
                }
            }
        }
        return answer;
    }*/
}
// 14 : 53 END 인덱스에서 너무 해맸다. 더 빨리 구현해야한다. 약 30분 소요

import java.util.Stack;

public class 카카오인턴01 {
    public static int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        for (int i = 0; i < moves.length; i++) {
            int e = upper(board, moves[i] - 1);
            if(e == -1){
                continue;
            }
            if(stack.isEmpty()){
                stack.add(e);
            }else{
                if(stack.peek() == e){
                    stack.pop();
                    answer+=2;
                }else{
                    stack.add(e);
                }
            }
        }

        return answer;
    }

    private static int upper(int[][] board, int index) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][index] != 0) {
                int temp = board[i][index];
                board[i][index] = 0;

                return temp;
            }
        }
        return -1;
    }
}

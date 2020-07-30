package KAKAO.KAKAO2020인턴;

import java.util.LinkedList;
import java.util.Queue;

// 16 : 13
public class 수식최대화 {
    public static void main(String[] args) {
        String expression = "50*6-3*2";
        long answer = 0;
        String[] operands = {"+-*", "+*-", "*-+", "*+-", "-+*", "-*+"};
        for (int i = 0; i < operands.length; i++) {
            long tmpAnswer = 0;
            String[] operandOrder = operands[i].split("");
            String tmp = expression.replace('+', ' ').replace('-', ' ').replace('*', ' ');
            String[] splits = expression.split("");
            Queue<String> operandQueue = new LinkedList<>();
            for (int j = 0; j < splits.length; j++) {
                if (splits[j].equals("+") || splits[j].equals("*") || splits[j].equals("-"))
                    operandQueue.offer(splits[j]);
            }
            Queue<Long> numQueue = new LinkedList<>();
            String[] tmpSplit = tmp.split(" ");
            for (int j = 0; j < tmpSplit.length; j++) {
                numQueue.offer(Long.parseLong(tmpSplit[j]));
            }
            long num = 0;
            for (int j = 0; j < operandOrder.length; j++) {
                num = numQueue.poll();
                int operandSize = operandQueue.size();
                for (int k = 0; k < operandSize; k++) {
                    if (operandQueue.peek().equals(operandOrder[j])) {
                        num = calculate(num, operandQueue.poll(), numQueue.poll());
                    } else {
                        numQueue.offer(num);
                        num = numQueue.poll();
                        operandQueue.offer(operandQueue.poll());
                    }
                }
                numQueue.offer(num);
            }
            answer = (Math.abs(num) > answer) ? Math.abs(num) : answer;
        }
        System.out.println(answer);
    }

    private static long calculate(long num, String tmpOperand, long tmpNum) {
        if (tmpOperand.equals("+")) {
            return num + tmpNum;
        } else if (tmpOperand.equals("-")) {
            return num - tmpNum;
        } else {
            return num * tmpNum;
        }
    }
}
// 15 : 12 (1시간)
package KAKAO.KAKAO2020인턴;

import java.util.LinkedList;
import java.util.Queue;

public class 수식최대화2 {
    public static void main(String[] args) {
        String[] expression = {"100-200*300-500+20", "50*6-3*2"};
        for (int i = 0; i < expression.length; i++) {
            System.out.println(solution(expression[i]));
        }
    }

    public static long solution(String expression) {
        long answer = 0;
        String[][] operandSet = {{"+", "-", "*"}, {"+", "*", "-"}, {"*", "-", "+"}, {"*", "+", "-"}, {"-", "+", "*"}, {"-", "*", "+"}};
        for (int i = 0; i < operandSet.length; i++) {
            String[] splitNum = expression.split("\\+|\\*|\\-");
            String[] tmpSplitOperand = expression.split("[0-9]");
            StringBuilder stringBuilder = new StringBuilder("");
            for (int j = 0; j < tmpSplitOperand.length; j++) {
                stringBuilder.append(tmpSplitOperand[j]);
            }
            String trimString = stringBuilder.toString().trim();
            String[] splitOperand = trimString.split("");
            Queue<Long> numQueue = new LinkedList<>();
            Queue<String> operandQueue = new LinkedList<>();
            for (int j = 0; j < splitNum.length; j++) {
                numQueue.add(Long.parseLong(splitNum[j]));
            }
            for (int j = 0; j < splitOperand.length; j++) {
                operandQueue.add(splitOperand[j]);
            }
            long sum = numQueue.poll();
            for (int j = 0; j < operandSet[i].length; j++) {
                String priorityOperand = operandSet[i][j];
                int operandQueueSize = operandQueue.size();
                for (int k = 0; k < operandQueueSize; k++) {
                    long num = numQueue.poll();
                    String operand = operandQueue.poll();
                    if (priorityOperand.equals(operand)) {
                        sum = calculateOperand(sum, num, operand);
                    } else {
                        numQueue.add(sum);
                        sum = num;
                        operandQueue.add(operand);
                    }
                    if (k == operandQueueSize - 1) {
                        numQueue.add(sum);
                        sum = numQueue.poll();
                    }
                }
            }
            answer = Math.max(Math.abs(sum), answer);
        }
        return answer;
    }

    private static long calculateOperand(long sum, long num, String operand) {
        if (operand.equals("+")) {
            return sum + num;
        } else if (operand.equals("-")) {
            return sum - num;
        } else {
            return sum * num;
        }
    }
}
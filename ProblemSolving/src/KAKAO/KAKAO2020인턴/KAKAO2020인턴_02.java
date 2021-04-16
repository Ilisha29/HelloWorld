package KAKAO.KAKAO2020인턴;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class KAKAO2020인턴_02 {
    public static void main(String[] args) {
        //System.out.println(solution("100-200*300-500+20"));
        System.out.println(solution("50*6-3*2"));
    }

    //3가지의 연산문자(+, -, *) 만으로 이루어진 연산 수식이 전달되며
    //만약 계산된 결과가 음수라면 해당 숫자의 절댓값으로 변환하여 제출하며 제출한 숫자가 가장 큰 참가자를 우승자로 선정하며
    public static long solution(String expression) {
        long answer = 0;
        boolean[] operand = new boolean[3]; // + , - , *
        String[] stringsOperand = {"+", "-", "*"};
        ArrayList<String> operandList = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            if (Character.toString(expression.charAt(i)).equals("+")) {
                operand[0] = true;
                operandList.add("+");
            } else if (Character.toString(expression.charAt(i)).equals("-")) {
                operand[1] = true;
                operandList.add("-");
            } else if (Character.toString(expression.charAt(i)).equals("*")) {
                operand[2] = true;
                operandList.add("*");
            }

        }
        int operandNum = 0;

        String[] canUseOperand = new String[operandNum];
        int index = 0;
        for (int i = 0; i < operand.length; i++) {
            if (operand[i]) {
                canUseOperand[index++] = stringsOperand[i];
            }
        }
        String[][] operands;
        if (operandNum == 1) {
            String[] strings = expression.split(canUseOperand[0]);
            answer = Integer.parseInt(strings[0]);
            for (int i = 1; i < strings.length; i++) {
                if (canUseOperand[0].equals("+")) {
                    answer += Integer.parseInt(strings[i]);
                } else if (canUseOperand[0].equals("-")) {
                    answer -= Integer.parseInt(strings[i]);
                } else {
                    answer *= Integer.parseInt(strings[i]);
                }
            }
            answer = Math.abs(answer);
        } else if (operandNum == 2) {
            operands = new String[2][2];
            String[] strings = expression.split("[^0-9]");
            operands[0][0] = canUseOperand[0];
            operands[0][1] = canUseOperand[1];
            operands[1][0] = canUseOperand[1];
            operands[1][1] = canUseOperand[0];

            for (int i = 0; i < 2; i++) {
                long tmpAnswer = 0;
                Deque<Long> deque = new LinkedList<>();
                Deque<String> stringDeque = new LinkedList<>();
                for (int j = 0; j < operandList.size(); j++) {
                    stringDeque.add(operandList.get(j));
                }
                for (int j = 0; j < strings.length; j++) {
                    deque.add(Long.parseLong(strings[j]));
                }
                long pollNum = deque.poll();
                deque.add(pollNum);
                for (int j = 0; j < 2; j++) {
                    String upperOperand = operands[i][j];
                    int size = stringDeque.size();
                    for (int k = 0; k < size; k++) {
                        if (stringDeque.getFirst().equals(upperOperand)) {
                            long dequeLast = deque.pollLast();
                            long dequeFirst = deque.pollFirst();
                            long result = 0;
                            if (upperOperand.equals("+")) {
                                result += dequeLast + dequeFirst;
                            } else if (upperOperand.equals("-")) {
                                result += dequeLast - dequeFirst;
                            } else {
                                result += dequeLast * dequeFirst;
                            }
                            deque.add(result);
                            stringDeque.pollFirst();
                        } else {
                            long dequeFirst = deque.pollFirst();
                            String stringQueueFirst = stringDeque.pollFirst();
                            deque.add(dequeFirst);
                            stringDeque.add(stringQueueFirst);
                        }
                    }
                    answer = Math.abs(deque.peekFirst()) > answer ? Math.abs(deque.peekFirst()) : answer;
                }
            }
        } else {
            operands = new String[6][3];
            operands[0][0] = canUseOperand[0];
            operands[0][1] = canUseOperand[1];
            operands[0][2] = canUseOperand[2];
            operands[1][0] = canUseOperand[0];
            operands[1][1] = canUseOperand[2];
            operands[1][2] = canUseOperand[1];
            operands[2][0] = canUseOperand[1];
            operands[2][1] = canUseOperand[0];
            operands[2][2] = canUseOperand[2];
            operands[3][0] = canUseOperand[1];
            operands[3][1] = canUseOperand[2];
            operands[3][2] = canUseOperand[0];
            operands[4][0] = canUseOperand[2];
            operands[4][1] = canUseOperand[0];
            operands[4][2] = canUseOperand[1];
            operands[5][0] = canUseOperand[2];
            operands[5][1] = canUseOperand[1];
            operands[5][2] = canUseOperand[0];

        }
        return answer;
    }
}
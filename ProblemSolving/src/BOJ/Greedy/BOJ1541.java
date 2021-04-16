package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        if (!input.contains("+") && !input.contains("-")) {
            System.out.println(Integer.parseInt(input));
        } else {
            String[] numbers = input.split("[+-]");
            String[] operands = input.replaceAll("[0123456789]", "").split("");
            Queue<Integer> numQueue = new LinkedList<>();
            Queue<String> operandQueue = new LinkedList<>();
            for (String num : numbers) {
                numQueue.add(Integer.parseInt(num));
            }
            for (String operand : operands) {
                operandQueue.add(operand);
            }
            int tmpNum = numQueue.poll();
            int size = operandQueue.size();
            for (int i = 0; i < size; i++) {
                String tmpOperand = operandQueue.poll();
                int tmpNum2 = numQueue.poll();
                if (tmpOperand.equals("+")) {
                    tmpNum += tmpNum2;
                } else {
                    numQueue.add(tmpNum);
                    operandQueue.add(tmpOperand);
                    tmpNum = tmpNum2;
                }
            }
            numQueue.add(tmpNum);
            tmpNum = numQueue.poll();
            int tmpSum = 0;
            if (!operandQueue.isEmpty()) {
                size = numQueue.size();
                for (int i = 0; i < size; i++) {
                    tmpSum += numQueue.poll();
                }
                System.out.println(tmpNum - tmpSum);
            } else {
                System.out.println(tmpNum);
            }
        }
        bufferedReader.close();
    }
}

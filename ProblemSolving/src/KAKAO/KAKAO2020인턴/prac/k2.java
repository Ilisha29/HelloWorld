package KAKAO.KAKAO2020인턴.prac;

import java.util.*;

public class k2 {
    public static void main(String[] args) {
        String[] input = {"100-200*300-500+20", "50*6-3*2"};
        for (int i = 0; i < input.length; i++) {
            System.out.println(solution(input[i]));
        }
    }

    public static long solution(String expression) {
        long answer = 0;
        String[] numbers = expression.split("\\+|-|\\*");
        String[] splitExpression = expression.split("");
        List<String> operands = new ArrayList<>();
        for (int i = 0; i < splitExpression.length; i++) {
            char c = splitExpression[i].charAt(0);
            if (!(c >= '0' && c <= '9')) {
                operands.add(splitExpression[i]);
            }
        }
        String[] operationCombination = {"*+-", "+-*", "+*-", "-+*", "-*+", "*-+"};
        for (int i = 0; i < operationCombination.length; i++) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(numbers[0]);
            for (int j = 1; j < numbers.length; j++) {
                arrayList.add(operands.get(j - 1));
                arrayList.add(numbers[j]);
            }
            String[] order = operationCombination[i].split("");
            for (int j = 0; j < order.length; j++) {
                String target = order[j];
                ArrayList<String> tmp = new ArrayList<>();
                for (int k = 0; k < arrayList.size(); k++) {
                    if (arrayList.get(k).equals(target)) {
                        tmp.add(calculate(tmp.remove(tmp.size() - 1), target, arrayList.get(k + 1)));
                        k++;
                    } else {
                        tmp.add(arrayList.get(k));
                    }
                }
                arrayList = tmp;
            }
            answer = Math.max(answer, Math.abs(Long.parseLong(arrayList.get(0))));
        }
        return answer;
    }

    private static String calculate(String remove, String target, String s) {
        long before = Long.parseLong(remove);
        long after = Long.parseLong(s);
        if (target.equals("-")) {
            return Long.toString((before - after));
        } else if (target.equals("+")) {
            return Long.toString((before + after));
        } else {
            return Long.toString((before * after));
        }
    }
}

package KAKAO.KAKAO2020공채.prac1;

import java.util.Stack;

public class K2 {
    public static void main(String[] args) {
        String[] tmp = {"(()())()",
                ")(",
                "()))((()"};
        for (int i = 1; i < tmp.length; i++) {
            System.out.println(solution(tmp[i]));
        }
    }

    public static String solution(String p) {
        if (isCorrect(p)) {
            return p;
        }
        return recursionString(p);
    }

    private static String recursionString(String p) {
        if (p.equals("")) {
            return p;
        }
        String[] split = p.split("");
        int left = 0;
        int right = 0;
        StringBuilder stringBuilder = new StringBuilder("");
        int index = 0;
        for (index = 0; index < split.length; index++) {
            stringBuilder.append(split[index]);
            if (split[index].equals("(")) {
                left++;
            } else {
                right++;
            }
            if (left != 0 && left == right) {
                index++;
                break;
            }
        }
        String u = stringBuilder.toString();
        stringBuilder = new StringBuilder("");
        for (int i = index ; i < split.length; i++) {
            stringBuilder.append(split[i]);
        }
        String v = stringBuilder.toString();
        if (isCorrect(u)) {
            return u + recursionString(v);
        } else {
            stringBuilder = new StringBuilder("(");
            stringBuilder.append(recursionString(v));
            stringBuilder.append(")");
            String[] splitU = u.split("");
            for (int i = 1; i < splitU.length - 1; i++) {
                if (splitU[i].equals(")")) {
                    stringBuilder.append("(");
                } else {
                    stringBuilder.append(")");
                }
            }
            return stringBuilder.toString();
        }
    }

    private static boolean isCorrect(String p) {
        Stack<String> stack = new Stack<>();
        String[] split = p.split("");
        for (int i = 0; i < split.length; i++) {
            if (stack.isEmpty()) {
                stack.add(split[i]);
            } else {
                if (split[i].equals(")") && stack.peek().equals("(")) {
                    stack.pop();
                } else {
                    stack.add(split[i]);
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}

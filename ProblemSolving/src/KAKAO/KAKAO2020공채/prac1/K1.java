package KAKAO.KAKAO2020공채.prac1;

import java.util.Stack;

//1:36
public class K1 {
    public static void main(String[] args) {
        String[] s = {
                "aabbaccc",
                "ababcdcdababcdcd",
                "abcabcdede",
                "abcabcabcabcdededededede",
                "xababcdcdababcdcd"
        };
        for (int i = 0; i < s.length; i++) {
            System.out.println(solution(s[i]));
        }
    }

    public static int solution(String s) {
        int answer = s.length();
        int sLength = s.length() / 2;
        for (int size = 1; size <= sLength; size++) {
            Stack<Compression> stack = new Stack<>();
            String[] splitString = s.split("");
            int index = 0;
            int count = 0;
            while (count < s.length() / size) {
                int innerCount = 0;
                StringBuilder stringBuilder = new StringBuilder("");
                while (innerCount < size) {
                    stringBuilder.append(splitString[index++]);
                    innerCount++;
                }
                insertStack(stack, stringBuilder.toString());
                count++;
            }
            int tmpAnswer = s.length() - index;
            while (!stack.isEmpty()) {
                Compression c = stack.pop();
                tmpAnswer += c.s.length();
                if (c.count != 1) {
                    tmpAnswer += Integer.toString(c.count).length();
                }
            }
            answer = Math.min(tmpAnswer, answer);
        }
        return answer;
    }

    private static void insertStack(Stack<Compression> stack, String tmpString) {
        if (stack.isEmpty()) {
            stack.add(new Compression(tmpString, 1));
        } else {
            if (stack.peek().s.equals(tmpString)) {
                stack.peek().count++;
            } else {
                stack.add(new Compression(tmpString, 1));
            }
        }
    }
}

class Compression {
    String s;
    int count;

    public Compression(String s, int count) {
        this.s = s;
        this.count = count;
    }
}
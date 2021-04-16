package KAKAO.KAKAO공채연습._2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호변환 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = {"(()())()", ")(", "()))((()"};
        for (int i = 0; i < strings.length; i++) {
            System.out.println(solution(strings[i]));
        }
        bufferedReader.close();
    }

    public static String solution(String p) {
        if (p == "")
            return "";
        else {
            String[] strings = p.split("");
            String u = "";
            String v = "";
            int index = 0;
            int sum = 0;
            for (int i = 0; i < strings.length; i++) {
                if (index != 0 && sum == 0) {
                    break;
                }
                if (strings[i].equals("(")) {
                    sum++;
                    u += strings[i];
                } else {
                    sum--;
                    u += strings[i];
                }
                index++;
            }
            for (int i = index; i < strings.length; i++) {
                v += strings[i];
            }

            if (u_is_correct(u)) {
                u += solution(v);
                return u;
            } else {
                String tmp = "(";
                tmp += solution(v);
                tmp += ")";
                String[] strings1 = u.split("");
                for (int i = 1; i < strings1.length - 1; i++) {
                    if (strings1[i].equals("(")) {
                        tmp += ")";
                    } else {
                        tmp += "(";
                    }
                }
                return tmp;
            }
        }
    }

    private static boolean u_is_correct(String u) {
        String[] strings = u.split("");
        Stack<String> stringStack = new Stack<>();
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals("(")) {
                stringStack.push("(");
            } else {
                if (stringStack.isEmpty()) {
                    stringStack.push(")");
                } else if (!stringStack.peek().equals("(")) {
                    stringStack.push(")");
                } else {
                    stringStack.pop();
                }
            }
        }
        if (stringStack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
// 구현 : 시뮬레이션 (30분)
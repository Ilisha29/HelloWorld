package KAKAO.KAKAO2020공채;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//재귀 & 구현
// 19 : 25 start
public class KAKAO2020공채_괄호변환 {
    public static void main(String[] args) {
        String[] p = {"(()())()", ")(", "()))((()"};
        for (int i = 0; i < p.length; i++) {
            System.out.println(solution(p[i]));
        }
    }

    /*
      1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
      2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
      3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
         3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
      4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
         4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
         4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
         4-3. ')'를 다시 붙입니다.
         4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
         4-5. 생성된 문자열을 반환합니다.
    */
    public static String solution(String p) {
        if (p.length() == 0) {
            return "";
        } else {
            String u = "";
            String v = "";
            String[] s = p.split("");
            Queue<String> stringQueue = new LinkedList<>();
            for (int i = 0; i < s.length; i++) {
                stringQueue.offer(s[i]);
            }
            int leftNum = 0;
            int rightNum = 0;
            while (leftNum == 0 || leftNum != rightNum) {
                if (stringQueue.peek().equals("(")) {
                    u += stringQueue.poll();
                    leftNum++;
                } else {
                    u += stringQueue.poll();
                    rightNum++;
                }
            }
            while (!stringQueue.isEmpty()) {
                v += stringQueue.poll();
            }
            if (isCollectString(u)) {
                u += solution(v);
                return u;
            } else {
                String a = "(";
                a += solution(v) + ")";
                u = u.substring(1, u.length() - 1);
                String[] splitU = u.split("");
                for (int i = 0; i < splitU.length; i++) {
                    if (splitU[i].equals("(")) {
                        a += ")";
                    } else if (splitU[i].equals(")")) {
                        a += "(";
                    } else {
                        a += "";
                    }
                }
                return a;
            }
        }
    }

    private static boolean isCollectString(String u) {
        Stack<String> strings = new Stack<>();
        String[] strings1 = u.split("");
        strings.push(strings1[0]);
        for (int i = 1; i < strings1.length; i++) {
            if (strings1[i].equals("(")) {
                strings.push(strings1[i]);
            } else {
                if (strings.peek().equals("(")) {
                    strings.pop();
                } else {
                    strings.push(strings1[i]);
                }
            }
        }
        if (strings.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
// 20 : 30  한시간이나 걸림;;;;

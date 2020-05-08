package KAKAO.KAKAO2018공채;

import java.util.Stack;

// 20 : 30
public class KAKAO2018공채_N진수게임 {
    public static void main(String[] args) {
        int[] n = {2, 16, 16}; //진법
        int[] t = {4, 16, 16}; //미리구할 숫자의 갯수
        int[] m = {2, 2, 2}; // 인원
        int[] p = {1, 1, 2}; // 튜브의 순서
        for (int i = 0; i < 3; i++) {
            System.out.println(solution(n[i], t[i], m[i], p[i]));
        }

    }

    public static String solution(int n, int t, int m, int p) {
        String answer = "";
        int length = m * t;
        String string = "";
        int tmpnumber = 0;
        Stack<String> stringStack = new Stack<>();
        while (string.length() <= length) {
            int number = tmpnumber;
            while (true) {
                int left = number % n;
                number /= n;
                if (left >= 10) {
                    if (left == 10) {
                        stringStack.add("A");
                    } else if (left == 11) {
                        stringStack.add("B");
                    } else if (left == 12) {
                        stringStack.add("C");
                    } else if (left == 13) {
                        stringStack.add("D");
                    } else if (left == 14) {
                        stringStack.add("E");
                    } else {
                        stringStack.add("F");
                    }
                } else {
                    stringStack.add(Integer.toString(left));
                }
                if (number == 0) {
                    break;
                }
            }
            int size = stringStack.size();
            for (int i = 0; i < size; i++) {
                string += stringStack.pop();
            }
            tmpnumber++;
        }
        int newP = p - 1;
        for (int i = 0; i < string.length(); i++) {
            if (i % m == newP) {
                answer += Character.toString(string.charAt(i));
                if (answer.length() == t) {
                    break;
                }
            }
        }
        return answer;
    }
}
// 21 : 40 end // 1시간 10분걸림.... 변수와 스택 위치가 잘못됐고,,, for문에 stack size를 잡으니 stackSize가 자꾸 최신화 되어서 원하는대로 for문이 돌아가지 않았다.
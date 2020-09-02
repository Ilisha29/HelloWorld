package KAKAO.KAKAO공채연습._2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열압축 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = {"aabbaccc", "ababcdcdababcdcd", "abcabcdede", "abcabcabcabcdededededede", "xababcdcdababcdcd"};
        for (int i = 0; i < strings.length; i++) {
            System.out.println(solution(strings[i]));
        }
        bufferedReader.close();
    }

    public static int solution(String s) {
        int answer = s.length();
        for (int i = 1; i <= s.length() / 2; i++) {
            String[] strings = s.split("");
            String before = "";
            int tmp_answer = 0;
            int dupli_str_num = 1;
            int index = 0;
            int end_index = s.length() - s.length() % i;
            while (true) {
                if (index == end_index) {
                    break;
                }
                String tmp = "";
                for (int j = 0; j < i; j++) {
                    tmp += strings[index++];
                }
                if (tmp.equals(before)) {
                    dupli_str_num++;
                } else {
                    tmp_answer += before.length();
                    if (dupli_str_num != 1) {
                        tmp_answer += Integer.toString(dupli_str_num).length();
                    }
                    before = tmp;
                    dupli_str_num = 0;
                }
            }
            tmp_answer += before.length();
            if (dupli_str_num != 1) { //초기화는 1이다 ㅜㅜ  0이 아니라 ㅜ
                tmp_answer += Integer.toString(dupli_str_num).length();
            }
            tmp_answer += s.length() - index;
            answer = tmp_answer < answer ? tmp_answer : answer;
        }
        return answer;
    }
}
// 구현문제 : 완탐
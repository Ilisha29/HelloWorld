package KAKAO;

import java.util.LinkedList;
import java.util.Queue;

public class KAKAO2020_문자열_압축 {
    /*
    aabbaccc
    ababcdcdababcdcd
    abcabcdede
    abcabcabcabcdededededede
    xababcdcdababcdcd
    */
    public static void main(String[] args) {
        String s = "xababcdcdababcdcd";
        int answer = s.length();
        int size = s.length() / 2;
        if (s.length() == 1) {
            System.out.println(1);
        } else {
            for (int i = 1; i <= size; i++) {
                int tmpAnswer = 0;
                String[] strings = s.split("");
                Queue<String> stringQueue = new LinkedList<>();
                int inputNum = (strings.length / i) * i;
                for (int j = 0; j < inputNum; j++) {
                    stringQueue.offer(strings[j]);
                }
                if (strings.length != stringQueue.size()) {
                    tmpAnswer += strings.length - stringQueue.size();
                }

                String standardString = "";
                int duplicateNum = 1;
                for (int j = 0; j < i; j++) {
                    standardString += stringQueue.poll();
                }

                while (!stringQueue.isEmpty()) {
                    String compareString = "";
                    for (int j = 0; j < i; j++) {
                        compareString += stringQueue.poll();
                    }

                    if (standardString.equals(compareString)) {
                        duplicateNum++;
                    } else {
                        tmpAnswer += standardString.length() + calculateJalitsu(duplicateNum);
                        standardString = compareString;
                        duplicateNum = 1;
                    }
                }
                tmpAnswer += standardString.length() + calculateJalitsu(duplicateNum);
                answer = tmpAnswer < answer ? tmpAnswer : answer;
            }
            System.out.println(answer);
        }
    }

    private static int calculateJalitsu(int n) {
        if (n == 1) {
            return 0;
        } else if (n >= 2 && n <= 9) {
            return 1;
        } else {
            int jalitsu = 0;
            while (n / 10 != 0) {
                n /= 10;
                jalitsu++;
            }
            return ++jalitsu;
        }
    }
}
//정말 20~30분안에 금방 해결해야 할 문제인데 너무 오래걸렸다.... 유형에 아직 익숙하지 못한 탓인지도 모르겠다.

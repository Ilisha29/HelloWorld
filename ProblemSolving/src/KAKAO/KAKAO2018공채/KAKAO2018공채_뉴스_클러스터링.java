package KAKAO.KAKAO2018공채;

import java.util.ArrayList;
import java.util.HashMap;

// 15 : 23
public class KAKAO2018공채_뉴스_클러스터링 {
    public static void main(String[] args) {
        String[][] strings = new String[4][2];
        strings[0][0] = "FRANCE";
        strings[0][1] = "french";
        strings[1][0] = "handshake";
        strings[1][1] = "shake hands";
        strings[2][0] = "aa1+aa2";
        strings[2][1] = "AAAA12";
        strings[3][0] = "E=M*C^2";
        strings[3][1] = "e=m*c^2";
        for (int i = 0; i < 4; i++) {
            System.out.println(solution(strings[i][0], strings[i][1]));
        }
    }

    /*
    자카드 유사도는 집합 간의 유사도를 검사하는 여러 방법 중의 하나로 알려져 있다.
    두 집합 A, B 사이의 자카드 유사도 J(A, B)는 두 집합의 교집합 크기를 두 집합의 합집합 크기로 나눈 값으로 정의된다.
     */
    public static int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        String[] strings1 = new String[str1.length() - 1];
        String[] strings2 = new String[str2.length() - 1];
        for (int i = 0; i < strings1.length; i++) {
            strings1[i] = str1.substring(i, i + 2);
        }
        for (int i = 0; i < strings2.length; i++) {
            strings2[i] = str2.substring(i, i + 2);
        }
        ArrayList<String> str1Side = new ArrayList<>();
        ArrayList<String> str2Side = new ArrayList<>();
        ArrayList<String> samesame = new ArrayList<>();

        for (int i = 0; i < strings1.length; i++) {
            if (65 <= strings1[i].charAt(0) && strings1[i].charAt(0) <= 90 && 65 <= strings1[i].charAt(1) && strings1[i].charAt(1) <= 90) {
                str1Side.add(strings1[i]);
            }
        }
        for (int i = 0; i < strings2.length; i++) {
            if (65 <= strings2[i].charAt(0) && strings2[i].charAt(0) <= 90 && 65 <= strings2[i].charAt(1) && strings2[i].charAt(1) <= 90) {
                str2Side.add(strings2[i]);
            }
        }
        HashMap<String, Integer> str1HashMap = new HashMap<>();
        HashMap<String, Integer> str2HashMap = new HashMap<>();

        for (int i = 0; i < str1Side.size(); i++) {
            String string = str1Side.get(i);
            if (str1HashMap.containsKey(string)) {
                str1HashMap.put(string, str1HashMap.get(string) + 1);
            } else {
                str1HashMap.put(string, 1);
            }
        }
        for (int i = 0; i < str2Side.size(); i++) {
            String string = str2Side.get(i);
            if (str2HashMap.containsKey(string)) {
                str2HashMap.put(string, str2HashMap.get(string) + 1);
            } else {
                str2HashMap.put(string, 1);
            }
        }

        int answer = 0;
        if (str1HashMap.size() == 0 && str2HashMap.size() == 0) {
            answer = 65536;
        } else {
            str1Side.clear();
            str2Side.clear();
            HashMap<String, Integer> sameSide = new HashMap<>();
            for (String key : str1HashMap.keySet()) {
                if (str2HashMap.containsKey(key)) {
                    int sameTime = str1HashMap.get(key) < str2HashMap.get(key) ? str1HashMap.get(key) : str2HashMap.get(key);
                    sameSide.put(key, sameTime);
                    str1HashMap.put(key, str1HashMap.get(key) - sameTime);
                    str2HashMap.put(key, str2HashMap.get(key) - sameTime);
                }
            }
            double str1num = 0;
            double str2num = 0;
            double sameNum = 0;
            for (String key : str1HashMap.keySet()) {
                str1num += str1HashMap.get(key);
            }
            for (String key : str2HashMap.keySet()) {
                str2num += str2HashMap.get(key);
            }
            for (String key : sameSide.keySet()) {
                sameNum += sameSide.get(key);
            }
            double tmpAnswer = (sameNum) / (str1num + str2num + sameNum);
            answer = (int) (tmpAnswer * 65536);
        }
        return answer;
    }
}
// 16 : 24 한시간 걸림;;; 좀 아쉽다;;;
package KAKAO.K2021공채;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class K2 {
    public static void main(String[] args) {
        String[][] orders = {
                {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"},
                {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"},
                {"XYZ", "XWY", "WXA"}
        };
        int[][] course = {
                {2, 3, 4},
                {2, 3, 5},
                {2, 3, 4}
        };
        for (int i = 0; i < orders.length; i++) {
            String[] result = solution(orders[i], course[i]);
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[j] + " ");
            }
            System.out.println();
        }
    }

    public static String[] solution(String[] orders, int[] course) {
        ArrayList<String> tmpAnswer = new ArrayList<>();
        //0. 정렬
        for (int i = 0; i < orders.length; i++) {
            String[] strings = orders[i].split("");
            Arrays.sort(strings);
            StringBuilder stringBuilder = new StringBuilder("");
            for (int j = 0; j < strings.length; j++) {
                stringBuilder.append(strings[j]);
            }
            orders[i] = stringBuilder.toString();
        }
        //1. 조합갯수 다 체크하기
        HashMap<String, Integer> combMap = new HashMap<>();
        for (int i = 0; i < orders.length; i++) {
            String order = orders[i];
            for (int j = 0; j < Math.pow(2, order.length()); j++) {
                if (Integer.bitCount(j) >= 2) {
                    int length = Integer.toBinaryString(j).length();
                    StringBuilder stringBuilder = new StringBuilder("");
                    for (int k = 0; k < order.length() - length; k++) {
                        stringBuilder.append("0");
                    }
                    stringBuilder.append(Integer.toBinaryString(j));
                    String combString = stringBuilder.toString();
                    stringBuilder = new StringBuilder("");
                    for (int k = 0; k < combString.length(); k++) {
                        if (combString.charAt(k) == '1') {
                            stringBuilder.append(order.charAt(k));
                        }
                    }
                    String stringComb = stringBuilder.toString();
                    combMap.put(stringComb, combMap.getOrDefault(stringComb, 0) + 1);
                }
            }
        }
        //2. course로
        for (int i = 0; i < course.length; i++) {
            int size = course[i];
            int max = 0;
            for (String comb : combMap.keySet()) {
                if (comb.length() == size && combMap.get(comb) >= 2) {
                    max = Math.max(max, combMap.get(comb));
                }
            }
            for (String comb : combMap.keySet()) {
                if (comb.length() == size && combMap.get(comb) == max) {
                    tmpAnswer.add(comb);
                }
            }
        }
        String[] answer = tmpAnswer.toArray(new String[0]);
        Arrays.sort(answer);
        return answer;
    }
}

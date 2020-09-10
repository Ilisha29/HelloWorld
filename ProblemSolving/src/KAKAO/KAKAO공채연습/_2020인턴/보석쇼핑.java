package KAKAO.KAKAO공채연습._2020인턴;

import java.util.HashMap;

public class 보석쇼핑 {
    public static void main(String[] args) {
        String[][] gems = {
                {"a", "a", "b"},
                {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"},
                {"AA", "AB", "AC", "AA", "AC"},
                {"XYZ", "XYZ", "XYZ"},
                {"ZZZ", "YYY", "NNNN", "YYY", "BBB"},
                {"aa"},
                {"aa", "bb"}

        };
        for (int i = 0; i < gems.length; i++) {
            int[] array = solution(gems[i]);
            for (int j = 0; j < 2; j++) {
                System.out.print(array[j] + "  ");
            }
            System.out.println();
        }
    }

    public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        int answerStart = 0;
        int answerEnd = gems.length - 1;
        int answerLength = answerEnd - answerStart;
        int typeNum = 0;
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < gems.length; i++) {
            hashMap.put(gems[i], 1);
        }
        typeNum = hashMap.size();
        hashMap.clear();
        int tmpStart = 0;
        int tmpEnd = 0;
        if (gems.length == 1) {
            answer[0] = 1;
            answer[1] = 1;
        } else {
            while (tmpEnd < gems.length) {
                if (hashMap.size() < typeNum) {
                    hashMap.put(gems[tmpEnd], hashMap.getOrDefault(gems[tmpEnd], 0) + 1);
                    tmpEnd++;
                }
                while (hashMap.size() == typeNum) {
                    if (tmpEnd - tmpStart - 1 < answerLength) {
                        answerStart = tmpStart;
                        answerEnd = tmpEnd - 1;
                        answerLength = answerEnd - answerStart;
                    }
                    hashMap.put(gems[tmpStart], hashMap.get(gems[tmpStart]) - 1);
                    if (hashMap.get(gems[tmpStart]) == 0) {
                        hashMap.remove(gems[tmpStart]);
                    }
                    tmpStart++;
                }
            }
            answer[0] = answerStart + 1;
            answer[1] = answerEnd + 1;
        }
        return answer;
    }
}
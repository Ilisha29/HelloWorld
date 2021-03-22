package KAKAO.KAKAO2020인턴;

import java.util.*;

public class 보석쇼핑2 {
    public static void main(String[] args) {
        String[][] gems = {{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"}, {"AA", "AB", "AC", "AA", "AC"}, {"XYZ", "XYZ", "XYZ"}, {"ZZZ", "YYY", "NNNN", "YYY", "BBB"}};
        for (int i = 0; i < gems.length; i++) {
            int[] answer = solution(gems[i]);
            System.out.println(answer[0] + " " + answer[1]);
        }
    }

    public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        Set<String> gemSet = new HashSet<>();
        for (int i = 0; i < gems.length; i++) {
            gemSet.add(gems[i]);
        }
        int gemNum = gemSet.size();
        int answerStart = 0;
        int answerEnd = gems.length - 1;
        Map<String, Integer> gemMap = new HashMap<>();
        int start = 0;
        int end = 0;
        while (true) {
            gemMap.put(gems[end], gemMap.getOrDefault(gems[end], 0) + 1);
            while (gemMap.size() == gemNum) {
                if (answerEnd - answerStart > end - start) {
                    answerEnd = end;
                    answerStart = start;
                }
                gemMap.put(gems[start], gemMap.get(gems[start]) - 1);
                if (gemMap.get(gems[start]) == 0) {
                    gemMap.remove(gems[start]);
                }
                start++;
                if (start >= end) {
                    break;
                }
            }
            end++;
            if (end == gems.length) {
                break;
            }
        }
        answer[0] = answerStart + 1;
        answer[1] = answerEnd + 1;
        return answer;
    }
}

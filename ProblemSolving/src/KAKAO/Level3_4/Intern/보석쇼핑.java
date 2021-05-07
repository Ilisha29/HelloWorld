package KAKAO.Level3_4.Intern;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 보석쇼핑 {
    public static void main(String[] args) {
        String[][] gems = {
                {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"},
                {"AA", "AB", "AC", "AA", "AC"},
                {"XYZ", "XYZ", "XYZ"},
                {"ZZZ", "YYY", "NNNN", "YYY", "BBB"}
        };
        for (int i = 0; i < gems.length; i++) {
            int[] answer = solution(gems[i]);
            System.out.println(answer[0] + " " + answer[1]);
        }
    }

    public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        answer[0] = 0;
        answer[1] = gems.length - 1;
        int length = answer[1] - answer[0] + 1;
        Set<String> gemSet = new HashSet<>();
        for (int i = 0; i < gems.length; i++) {
            gemSet.add(gems[i]);
        }
        int gemType = gemSet.size();
        gemSet.clear();
        int start = 0;
        int end = 0;
        Map<String, Integer> gemMap = new HashMap<>();
        while (true) {
            if (end == gems.length) {
                break;
            }
            gemMap.put(gems[end], gemMap.getOrDefault(gems[end], 0) + 1);
            while (gemMap.size() == gemType) {
                if (end - start + 1 < length) {
                    answer[0] = start;
                    answer[1] = end;
                    length = end - start + 1;
                }
                gemMap.put(gems[start], gemMap.get(gems[start]) - 1);
                if (gemMap.get(gems[start]) == 0) {
                    gemMap.remove(gems[start]);
                }
                start++;
            }
            end++;
        }
        answer[0]++;
        answer[1]++;
        return answer;
    }
}
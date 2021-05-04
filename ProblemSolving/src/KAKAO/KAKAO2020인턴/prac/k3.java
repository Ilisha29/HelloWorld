package KAKAO.KAKAO2020인턴.prac;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class k3 {
    public static void main(String[] args) {
        String[][] string = {

                {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"},
                {"AA", "AB", "AC", "AA", "AC"},
                {"XYZ", "XYZ", "XYZ"},
                {"ZZZ", "YYY", "NNNN", "YYY", "BBB"}
        };
        for (int i = 0; i < string.length; i++) {
            int[] answer = solution(string[i]);
            System.out.println(answer[0] + " " + answer[1]);
        }
    }

    public static int[] solution(String[] gems) {
        int[] answer = {0, gems.length - 1};
        Set<String> gemSet = new HashSet<>();
        for (int i = 0; i < gems.length; i++) {
            gemSet.add(gems[i]);
        }
        int gemType = gemSet.size();
        gemSet.clear();
        Map<String, Integer> getMap = new HashMap<>();
        int start = 0;
        int end = 0;
        while (true) {
            if (end == gems.length) {
                break;
            }
            getMap.put(gems[end], getMap.getOrDefault(gems[end], 0) + 1);
            while (gemType == getMap.size()) {
                if (end - start < answer[1] - answer[0]) {
                    answer[0] = start;
                    answer[1] = end;
                } else if (end - start == answer[1] - answer[0]) {
                    answer[0] = Math.min(start, answer[0]);
                    answer[1] = Math.min(end, answer[1]);
                }
                getMap.put(gems[start], getMap.get(gems[start]) - 1);
                if (getMap.get(gems[start]) == 0) {
                    getMap.remove(gems[start]);
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
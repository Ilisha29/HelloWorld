package KAKAO.KAKAO2019윈터인턴;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 보석쇼핑2 {
    public static void main(String[] args) {
        String[][] gems = {{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"},
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
        int[] answer = {0, gems.length - 1};
        int gemsTypeCount = calculate(gems);
        int start = 0;
        int end = 0;
        Map<String, Integer> map = new HashMap<>();

        while (end < gems.length) {
            if (map.size() != gemsTypeCount) {
                map.put(gems[end], map.getOrDefault(gems[0], 0) + 1);

            }
        }
        answer[0]++;
        answer[1]++;
        return answer;
    }

    private static int calculate(String[] gems) {
        Set<String> stringSet = new HashSet<>();
        for (int i = 0; i < gems.length; i++) {
            stringSet.add(gems[i]);
        }
        return stringSet.size();
    }
}
package KAKAO.KAKAO2018공채.prac;

import java.util.HashSet;
import java.util.Set;

public class k3 {
    public static void main(String[] args) {
        String[][] words = {{"go", "gone", "guild"},
                {"abc", "def", "ghi", "jklm"},
                {"word", "war", "warrior", "world"}};
        for (int i = 0; i < words.length; i++) {
            System.out.println(solution(words[i]));
        }
    }

    public static int solution(String[] words) {
        int answer = 0;
        for (int i = 0; i < words.length; i++) {
            String[] target = words[i].split("");
            Set<String> set = new HashSet<>();
            for (int j = 0; j < words.length; j++) {
                if (i != j) {
                    String[] strings = words[j].split("");
                    StringBuilder stringBuilder = new StringBuilder("");
                    for (int k = 0; k < strings.length; k++) {
                        stringBuilder.append(strings[k]);
                        set.add(stringBuilder.toString());
                    }
                }
            }
            StringBuilder stringBuilder = new StringBuilder("");
            for (int j = 0; j < target.length; j++) {
                stringBuilder.append(target[j]);
                answer++;
                if (!set.contains(stringBuilder.toString())) {
                    break;
                }
            }
        }
        return answer;
    }
}

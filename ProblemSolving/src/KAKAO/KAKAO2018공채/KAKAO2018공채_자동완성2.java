package KAKAO.KAKAO2018공채;

import java.util.Arrays;

public class KAKAO2018공채_자동완성2 {
    public static void main(String[] args) {
        String[][] words = {
                {"go", "gone", "guild"},
                {"abc", "def", "ghi", "jklm"},
                {"word", "war", "warrior", "world"},
                {"abc", "abcde"},
                {"abcfeg","ab"},
                {"ab","ac"}
        };
        for (int i = 0; i < words.length; i++) {
            System.out.println(solution(words[i]));
        }
    }

    public static int solution(String[] words) {
        int answer = 0;
        Arrays.sort(words);
        int length = words.length;
        for (int i = 0; i < length; i++) {
            int targetLength = words[i].length();
            if (i == 0) {
                int index = 0;
                while (index < targetLength) {
                    answer++;
                    char target = words[i].charAt(index);
                    char after;
                    if (index < words[i + 1].length()) {
                        after = words[i + 1].charAt(index);
                    } else {
                        after = '0';
                    }
                    if (target != after) {
                        break;
                    }
                    index++;
                }
            } else if (i == length - 1) {
                int index = 0;
                while (index < targetLength) {
                    answer++;
                    char target = words[i].charAt(index);
                    char before;
                    if (index < words[i - 1].length()) {
                        before = words[i - 1].charAt(index);
                    } else {
                        before = '0';
                    }
                    if (target != before) {
                        break;
                    }
                    index++;
                }
            } else {
                int index = 0;
                while (index < targetLength) {
                    answer++;
                    char target = words[i].charAt(index);
                    char before;
                    char after;
                    if (index < words[i - 1].length()) {
                        before = words[i - 1].charAt(index);
                    } else {
                        before = '0';
                    }
                    if (index < words[i + 1].length()) {
                        after = words[i + 1].charAt(index);
                    } else {
                        after = '0';
                    }
                    if (target != before && target != after) {
                        break;
                    }
                    index++;
                }
            }
        }
        return answer;
    }
}

package KAKAO.KAKAO2018공채.prac;

import java.util.Arrays;

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
        Arrays.sort(words);
        for (int i = 0; i < words.length; i++) {
            if (i == 0) {
                answer += calculate(words[i], words[i + 1]);
            } else if (i == words.length - 1) {
                answer += calculate(words[i], words[i - 1]);
            } else {
                answer += Math.max(calculate(words[i], words[i - 1]), calculate(words[i], words[i + 1]));
            }
        }
        return answer;
    }

    private static int calculate(String target, String word) {
        String[] splitTarget = target.split("");
        String[] splitWord = word.split("");
        if (word.contains(target)) {
            return target.length();
        }
        int minLength = Math.min(splitTarget.length, splitWord.length);
        int index;
        for (index = 0; index < minLength; index++) {
            if (!splitTarget[index].equals(splitWord[index])) {
                break;
            }
        }
        return index + 1;
    }
}

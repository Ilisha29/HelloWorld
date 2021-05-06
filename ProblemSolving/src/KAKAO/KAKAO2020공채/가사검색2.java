package KAKAO.KAKAO2020공채;

import java.util.HashMap;
import java.util.Map;

public class 가사검색2 {
    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] strings = {"fro??", "????o", "fr???", "fro???", "pro?","???","?????"};
        int[] result = solution(words, strings);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    private static int tmpAnswer;

    public static int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        Node front = new Node();
        Node back = new Node();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            insert(front, words[i]);
            insert(back, new StringBuilder(words[i]).reverse().toString());
            map.put(words[i].length(), map.getOrDefault(words[i].length(), 0) + 1);
        }

        for (int i = 0; i < queries.length; i++) {
            if (queries[i].charAt(0) == '?') {
                if (queries[i].charAt(queries[i].length() - 1) == '?') {
                    if (map.containsKey(queries[i].length())) {
                        answer[i] = map.get(queries[i].length());
                    } else {
                        answer[i] = 0;
                    }
                } else {
                    tmpAnswer = 0;
                    find(back, new StringBuilder(queries[i]).reverse().toString());
                    answer[i] = tmpAnswer;
                    tmpAnswer = 0;
                }
            } else {
                tmpAnswer = 0;
                find(front, queries[i]);
                answer[i] = tmpAnswer;
                tmpAnswer = 0;
            }
        }
        return answer;
    }

    private static void find(Node curr, String query) {
        int questionLength = 0;
        for (int i = 0; i < query.length(); i++) {
            if (query.charAt(i) == '?') {
                break;
            }
            questionLength++;
        }
        int remain = query.length() - questionLength;
        for (char c : query.toCharArray()) {
            if (c == '?' || !curr.children.containsKey(c)) {
                break;
            }
            curr = curr.children.get(c);
        }
        if (curr.children.size() != 0) {
            findCorrect(curr, remain);
        }
    }

    private static void findCorrect(Node curr, int remain) {
        if (remain == 0 && curr.isEnd) {
            tmpAnswer++;
            return;
        }
        if (curr.children.size() == 0) {
            return;
        }
        for (char c : curr.children.keySet()) {
            findCorrect(curr.children.get(c), remain - 1);
        }
    }

    private static void insert(Node curr, String word) {
        for (int i = 0; i < word.length(); i++) {
            curr = curr.children.computeIfAbsent(word.charAt(i), l -> new Node());
            if (i == word.length() - 1) {
                curr.isEnd = true;
            }
        }
    }
}

class Node {
    Map<Character, Node> children;
    boolean isEnd;

    Node() {
        children = new HashMap<>();
        isEnd = false;
    }
}

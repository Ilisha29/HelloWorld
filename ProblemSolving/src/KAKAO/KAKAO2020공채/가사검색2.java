package KAKAO.KAKAO2020공채;

import java.util.HashMap;
import java.util.Map;

public class 가사검색2 {
    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] strings = {"fro??", "????o", "fr???", "fro???", "pro?", "???", "?????"};
        int[] result = solution(words, strings);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Node> frontNodeMap = new HashMap<>();
        Map<Integer, Node> backNodeMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            int length = words[i].length();
            if (!frontNodeMap.containsKey(length)) {
                frontNodeMap.put(length, new Node());
            }
            if (!backNodeMap.containsKey(length)) {
                backNodeMap.put(length, new Node());
            }
            Node front = frontNodeMap.get(length);
            Node back = backNodeMap.get(length);
            insert(front, words[i]);
            insert(back, new StringBuilder(words[i]).reverse().toString());
            map.put(words[i].length(), map.getOrDefault(words[i].length(), 0) + 1);
        }

        for (int i = 0; i < queries.length; i++) {
            int queryLength = queries[i].length();
            Node front = frontNodeMap.get(queryLength);
            Node back = backNodeMap.get(queryLength);
            if (queries[i].charAt(0) == '?') {
                if (queries[i].charAt(queries[i].length() - 1) == '?') {
                    if (map.containsKey(queries[i].length())) {
                        answer[i] = map.get(queries[i].length());
                    } else {
                        answer[i] = 0;
                    }
                } else {
                    if (back == null) {
                        answer[i] = 0;
                        continue;
                    }
                    answer[i] = find(back, new StringBuilder(queries[i]).reverse().toString());
                }
            } else {
                if (front == null) {
                    answer[i] = 0;
                    continue;
                }
                answer[i] = find(front, queries[i]);
            }
        }
        return answer;
    }

    private static int find(Node curr, String query) {
        int tmpAnswer = 0;
        for (char c : query.toCharArray()) {
            if (c == '?' || !curr.children.containsKey(c)){
                break;
            }
            curr = curr.children.get(c);
            tmpAnswer = curr.cnt;
        }
        return tmpAnswer;
    }


    private static void insert(Node curr, String word) {
        for (char c : word.toCharArray()) {
            curr = curr.children.computeIfAbsent(c, l -> new Node());
            curr.cnt++;
            curr.c = c;
        }
    }
}

class Node {
    Map<Character, Node> children;
    int cnt;
    char c;

    Node() {
        children = new HashMap<>();
    }
}

package KAKAO.KAKAO2018공채;

import java.util.HashMap;
import java.util.Map;

public class 자동완성 {

    public static void main(String[] args) {
        String[][] words = {{"go", "gone", "guild"},
                {"abc", "def", "ghi", "jklm"},
                {"word", "war", "warrior", "world"}};
        for (int i = 0; i < words.length; i++) {
            System.out.println(solution(words[i]));
        }
    }

    private static int answer;

    public static int solution(String[] words) {
        answer = 0;
        Node root = new Node();
        for (int i = 0; i < words.length; i++) {
            insert(root, words[i]);
        }
        for (int i = 0; i < words.length; i++) {
            check(root, words[i]);
        }
        return answer;
    }

    private static void check(Node curr, String target) {
        for (char c : target.toCharArray()) {
            curr = curr.children.get(c);
            answer++;
            if (curr.cnt == 1) {
                return;
            }
        }
    }

    private static void insert(Node curr, String word) {
        for (char c : word.toCharArray()) {

            curr = curr.children.computeIfAbsent(c, l -> new Node());
            curr.cnt++;
        }
    }
}

class Node {
    Map<Character, Node> children;
    int cnt;

    public Node() {
        children = new HashMap<>();
    }
}
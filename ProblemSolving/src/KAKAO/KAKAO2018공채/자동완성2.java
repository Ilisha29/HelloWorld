package KAKAO.KAKAO2018공채;

import java.util.HashMap;
import java.util.Map;

public class 자동완성2 {
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
        Node2 root = new Node2();
        for (int i = 0; i < words.length; i++) {
            insert(root, words[i]);
        }
        for (int i = 0; i < words.length; i++) {
            find(root, words[i]);
        }
        return answer;
    }

    private static void find(Node2 root, String word) {
        for (char c : word.toCharArray()) {
            root = root.children.get(c);
            answer++;
            if (root.cnt == 1) {
                break;
            }
        }

    }

    private static void insert(Node2 curr, String word) {
        for (char c : word.toCharArray()) {
            curr = curr.children.computeIfAbsent(c, l -> new Node2());
            curr.cnt++;
        }
    }

}

class Node2 {
    Map<Character, Node2> children;
    int cnt;

    Node2() {
        children = new HashMap<>();
    }
}
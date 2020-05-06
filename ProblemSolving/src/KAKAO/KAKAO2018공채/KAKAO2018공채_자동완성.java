package KAKAO.KAKAO2018공채;

import java.util.HashMap;

// 12 : 11
public class KAKAO2018공채_자동완성 {
    public static void main(String[] args) {
        String[][] strings = {{"go", "gone", "guild"}, {"abc", "def", "ghi", "jklm"}, {"word", "war", "warrior", "world"}};
        for (int i = 0; i < strings.length; i++) {
            System.out.println(solution(strings[i]));
        }
    }

    //모든 단어는 알파벳 소문자로 구성되며 단어의 수 N과 단어들의 길이의 총합 L의 범위는 다음과 같다.
    public static int solution(String[] words) {
        int answer = 0;
        Trie trie = new Trie();
        for (String string : words) {
            trie.insert(string);
        }

        for (String string : words) {
            for (int i = 1; i <= string.length(); i++) {
                answer++;
                String word = string.substring(0, i);

                if (trie.findLeafs(word).size() == 1) {
                    break;
                }
            }
        }
        /*for (int i = 0; i < words.length; i++) {
            String findWord = "";
            String[] strings = words[i].split("");

            HashMap<String, Integer> hashMap = new HashMap<>();
            for (int j = 0; j < words.length; j++) {
                hashMap.put(words[j], 0);
            }
            boolean isFindAnswer = false;
            for (int j = 0; j < strings.length - 1; j++) {
                findWord += strings[j];
                ArrayList<String> beDeleteKeySey = new ArrayList<>();
                for (String key : hashMap.keySet()) {
                    String tmpKey = "";
                    if (key.length() >= findWord.length()) {
                        tmpKey = key.substring(0, findWord.length());
                    }
                    if (!tmpKey.equals(findWord)) {
                        beDeleteKeySey.add(key);
                    }
                }
                for (int k = 0; k < beDeleteKeySey.size(); k++) {
                    hashMap.remove(beDeleteKeySey.get(k));
                }
                if (hashMap.size() == 1) {
                    isFindAnswer = true;
                    answer += findWord.length();
                    break;
                }
            }
            if (!isFindAnswer) answer += words[i].length();
        }*/
        return answer;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode(' ');
    }
}

class TrieNode {
    private char data;
    private boolean isLeaf;
    private HashMap<Character, TrieNode> children;

    public TrieNode(char c) {
        this.data = c;
        children = new HashMap<>();
        isLeaf = false;
    }
    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

}
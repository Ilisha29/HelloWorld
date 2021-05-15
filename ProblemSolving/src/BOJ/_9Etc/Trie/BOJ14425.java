package BOJ._9Etc.Trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BOJ14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] NM = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int answer = 0;
        Trie root = new Trie();
        String[] input = new String[NM[0]];
        for (int i = 0; i < NM[0]; i++) {
            input[i] = bufferedReader.readLine();
        }
        for (int i = 0; i < NM[0]; i++) {
            insert(root, input[i]);
        }

        String[] check = new String[NM[1]];
        for (int i = 0; i < NM[1]; i++) {
            check[i] = bufferedReader.readLine();
        }
        for (int i = 0; i < NM[1]; i++) {
            if (isAnswer(root, check[i])) {
                answer++;
            }
        }
        System.out.println(answer);
        bufferedReader.close();
    }

    private static boolean isAnswer(Trie curr, String checkString) {
        char[] c = checkString.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (curr.children.containsKey(c[i])) {
                curr = curr.children.get(c[i]);
                if (i == c.length - 1 && !curr.isEnd) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    private static void insert(Trie curr, String inputString) {
        char[] c = inputString.toCharArray();
        for (int i = 0; i < c.length; i++) {
            curr = curr.children.computeIfAbsent(c[i], l -> new Trie());
            if (i == c.length - 1) {
                curr.isEnd = true;
            }
        }
    }
}

class Trie {
    Map<Character, Trie> children;
    boolean isEnd;

    public Trie() {
        this.children = new HashMap<>();
        this.isEnd = false;
    }
}

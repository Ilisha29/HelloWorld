package KAKAO.Level3_4.Intern;

import java.util.*;

public class 불량사용자 {
    public static void main(String[] args) {
        String[][] user_id = {
                {"frodo", "fradi", "crodo", "abc123", "frodoc"},
                {"frodo", "fradi", "crodo", "abc123", "frodoc"},
                {"frodo", "fradi", "crodo", "abc123", "frodoc"}
        };
        String[][] banned_id = {
                {"fr*d*", "abc1**"},
                {"*rodo", "*rodo", "******"},
                {"fr*d*", "*rodo", "******", "******"}
        };
        for (int i = 0; i < user_id.length; i++) {
            System.out.println(solution(user_id[i], banned_id[i]));
        }
    }

    private static List<String[]> combList;
    private static Set<String> answerSet;

    public static int solution(String[] user_id, String[] banned_id) {
        combList = new ArrayList<>();
        answerSet = new HashSet<>();
        permutation(user_id, 0, user_id.length, banned_id.length);
        for (int i = 0; i < combList.size(); i++) {
            if (isMatch(combList.get(i), banned_id)) {
                String[] strings = combList.get(i);
                Arrays.sort(strings);
                StringBuilder stringBuilder = new StringBuilder("");
                for (int j = 0; j < strings.length; j++) {
                    stringBuilder.append(strings[j]);
                    stringBuilder.append(",");
                }
                answerSet.add(stringBuilder.toString());
            }
        }
        return answerSet.size();
    }

    private static boolean isMatch(String[] strings, String[] banned_id) {
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() != banned_id[i].length()) {
                return false;
            }
            for (int j = 0; j < banned_id[i].length(); j++) {
                if (banned_id[i].charAt(j) != '*' && banned_id[i].charAt(j) != strings[i].charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void permutation(String[] user_id, int depth, int n, int k) {
        if (depth == k) {
            String[] comb = new String[k];
            for (int i = 0; i < k; i++) {
                comb[i] = user_id[i];
            }
            combList.add(comb);
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(user_id, depth, i);
            permutation(user_id, depth + 1, n, k);
            swap(user_id, depth, i);
        }
    }

    private static void swap(String[] user_id, int x, int y) {
        String tmp = user_id[x];
        user_id[x] = user_id[y];
        user_id[y] = tmp;
    }
}

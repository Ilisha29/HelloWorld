package KAKAO.KAKAO2019윈터인턴.prac1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class K3 {
    public static void main(String[] args) {
        String[][] userId = {
                {"frodo", "fradi", "crodo", "abc123", "frodoc"},
                {"frodo", "fradi", "crodo", "abc123", "frodoc"},
                {"frodo", "fradi", "crodo", "abc123", "frodoc"}};
        String[][] bannedId = {
                {"fr*d*", "abc1**"},
                {"*rodo", "*rodo", "******"},
                {"fr*d*", "*rodo", "******", "******"}
        };

        for (int i = 0; i < bannedId.length; i++) {
            System.out.println(solution(userId[i], bannedId[i]));
        }
    }

    private static Set<String> answerSet;

    public static int solution(String[] user_id, String[] banned_id) {
        answerSet = new HashSet<>();
        Arrays.sort(user_id, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        Arrays.sort(banned_id, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        perm(user_id, 0, user_id.length, banned_id.length, banned_id);
        return answerSet.size();
    }

    public static void perm(String[] arr, int depth, int n, int k, String[] banned_id) {
        if (depth == k) { // 한번 depth 가 k로 도달하면 사이클이 돌았음. 출력함.
            String[] tmp = new String[k];
            for (int i = 0; i < tmp.length; i++) {
                tmp[i] = arr[i];
            }
            if (isAnswer(tmp, banned_id)) {
                Arrays.sort(tmp);
                StringBuilder s = new StringBuilder("");
                for (int i = 0; i < tmp.length; i++) {
                    s.append(tmp[i]);
                    s.append(",");
                }
                answerSet.add(s.toString());
            }
            return;
        }
        for (int i = depth; i < n; i++) {
            swap(arr, i, depth);
            perm(arr, depth + 1, n, k, banned_id);
            swap(arr, i, depth);
        }
    }

    private static boolean isAnswer(String[] arr, String[] banned_id) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() != banned_id[i].length()) {
                return false;
            }
            for (int j = 0; j < arr[i].length(); j++) {
                char a = arr[i].charAt(j);
                char b = banned_id[i].charAt(j);
                if (b != '*' && a != b) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

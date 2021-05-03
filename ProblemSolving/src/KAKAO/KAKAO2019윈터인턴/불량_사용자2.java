package KAKAO.KAKAO2019윈터인턴;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 불량_사용자2 {
    public static void main(String[] args) {
        String[][] user_id = {{"frodo", "fradi", "crodo", "abc123", "frodoc"}, {"frodo", "fradi", "crodo", "abc123", "frodoc"}, {"frodo", "fradi", "crodo", "abc123", "frodoc"}};
        String[][] banned_id = {{"fr*d*", "abc1**"}, {"*rodo", "*rodo", "******"}, {"fr*d*", "*rodo", "******", "******"}};
        for (int i = 0; i < user_id.length; i++) {
            System.out.println(solution(user_id[i], banned_id[i]));
        }
    }

    public static int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
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
        int size = user_id.length;
        List<String> combSet = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, size); i++) {
            if (banned_id.length == Integer.bitCount(i)) {
                ArrayList<String> tmpComb = new ArrayList<>();
                String combString = Integer.toBinaryString(i);
                int length = combString.length();
                for (int j = 0; j < size - length; j++) {
                    combString = "0" + combString;
                }
                for (int j = 0; j < size; j++) {
                    if (combString.charAt(j) == '1') {
                        tmpComb.add(user_id[j]);
                    }
                }
                combSet.add(String.join(",", tmpComb));
            }
        }
        for (int i = 0; i < combSet.size(); i++) {
            String[] combset_user_id = combSet.get(i).split(",");
            boolean[] isAnswer = new boolean[1];
            perm(combset_user_id, 0, combset_user_id.length, combset_user_id.length, isAnswer, banned_id);
            if (isAnswer[0]) {
                answer++;
            }
        }
        return answer;
    }

    public static void perm(String[] arr, int depth, int n, int k, boolean[] isAnswer, String[] banned_id) {
        if (depth == k) {
            if (isCanAnswer(arr, banned_id)) {
                isAnswer[0] = true;
            }
            return;
        }
        for (int i = depth; i < n; i++) {
            swap(arr, i, depth);
            perm(arr, depth + 1, n, k, isAnswer, banned_id);
            swap(arr, i, depth);
        }
    }

    public static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(String[] arr, int k) {
        for (int i = 0; i < k; i++) {
            if (i == k - 1) System.out.println(arr[i]);
            else System.out.print(arr[i] + ",");
        }
    }

    private static boolean isCanAnswer(String[] comb_user_id, String[] banned_id) {
        for (int i = 0; i < comb_user_id.length; i++) {
            if (comb_user_id[i].length() != banned_id[i].length()) {
                return false;
            } else {
                for (int j = 0; j < banned_id[i].length(); j++) {
                    char c = banned_id[i].charAt(j);
                    if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                        if (c != comb_user_id[i].charAt(j)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
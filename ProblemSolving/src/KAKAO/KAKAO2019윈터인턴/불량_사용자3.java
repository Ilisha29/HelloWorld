package KAKAO.KAKAO2019윈터인턴;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 불량_사용자3 {
    public static void main(String[] args) {
        String[][] user_id = {
                {"frodo", "fradi", "crodo", "abc123", "frodoc"},
                {"frodo", "fradi", "crodo", "abc123", "frodoc"},
                {"frodo", "fradi", "crodo", "abc123", "frodoc"}
        };
        String[][] banned_id = {
                {"fr*d*", "abc1**"},
                {"*rodo", "*rodo", "******"},
                {"fr*d*", "*rodo", "******", "******"}};
        for (int i = 0; i < user_id.length; i++) {
            System.out.println(solution(user_id[i], banned_id[i]));
        }
    }

    private static ArrayList<String[]> arrayList;

    public static int solution(String[] user_id, String[] banned_id) {
        arrayList = new ArrayList<>();
        permutation(user_id, 0, user_id.length, banned_id.length);
        Set<String> stringSet = new HashSet<>();
        for (int i = 0; i < arrayList.size(); i++) {
            String[] tmp = arrayList.get(i);
            if (isCanAnswer(tmp, banned_id)) {
                Arrays.sort(tmp);
                StringBuilder stringBuilder = new StringBuilder("");
                for (int j = 0; j < tmp.length; j++) {
                    stringBuilder.append(tmp[j]);
                    stringBuilder.append(",");
                }
                stringSet.add(stringBuilder.toString());
            }
        }
        return stringSet.size();
    }

    private static boolean isCanAnswer(String[] tmp, String[] banned_id) {
        for (int i = 0; i < tmp.length; i++) {
            String userId = tmp[i];
            String banId = banned_id[i];
            if (userId.length() != banId.length()) {
                return false;
            }
            for (int j = 0; j < userId.length(); j++) {
                if (banId.charAt(j) != '*') {
                    if (banId.charAt(j) != userId.charAt(j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static void permutation(String[] user_id, int depth, int length, int K) {
        if (depth == K) {
            String[] tmp = new String[K];
            for (int i = 0; i < K; i++) {
                tmp[i] = user_id[i];
            }
            arrayList.add(tmp);
            return;
        }
        for (int i = depth; i < length; i++) {
            swap(user_id, i, depth);
            permutation(user_id, depth + 1, length, K);
            swap(user_id, i, depth);
        }
    }

    private static void swap(String[] user_id, int i, int depth) {
        String tmp = user_id[i];
        user_id[i] = user_id[depth];
        user_id[depth] = tmp;
    }
}

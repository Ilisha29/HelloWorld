package KAKAO.K2021공채;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class K3 {
    public static void main(String[] args) {
        String[] info = {
                "java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"
        };
        String[] query = {
                "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"
        };

        int[] result = solution(info, query);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i] + " ");
        }
    }

    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        Map<String, ArrayList<Integer>> hashMap = new HashMap<>();
        String[] keySet = new String[3 * 2 * 2 * 2];
        int index = 0;
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 2; j++) {
                for (int k = 1; k <= 2; k++) {
                    for (int l = 1; l <= 2; l++) {
                        StringBuilder stringBuilder = new StringBuilder("");
                        stringBuilder.append(i);
                        stringBuilder.append(j);
                        stringBuilder.append(k);
                        stringBuilder.append(l);
                        String key = stringBuilder.toString();
                        hashMap.put(key, new ArrayList<>());
                        keySet[index++] = key;
                    }
                }
            }
        }
        for (int i = 0; i < info.length; i++) {
            String[] detailInfo = info[i].split(" ");
            String language = detailInfo[0];
            String position = detailInfo[1];
            String age = detailInfo[2];
            String food = detailInfo[3];
            int score = Integer.parseInt(detailInfo[4]);
            String key = makeKey(language, position, age, food);
            hashMap.get(key).add(score);
        }
        for (String key : hashMap.keySet()) {
            Collections.sort(hashMap.get(key));
        }

        for (int i = 0; i < query.length; i++) {
            String newQuery = query[i].replaceAll("and", "");
            newQuery = newQuery.replaceAll("  ", " ");
            String[] splitQuery = newQuery.split(" ");
            int score = Integer.parseInt(splitQuery[4]);
            ArrayList<String> correctKey = new ArrayList<>();
            String key = makeKey(splitQuery[0], splitQuery[1], splitQuery[2], splitQuery[3]);
            for (int j = 0; j < keySet.length; j++) {
                if (isCanAnswer(key, keySet[j])) {
                    correctKey.add(keySet[j]);
                }
            }
            int count = 0;
            for (int j = 0; j < correctKey.size(); j++) {
                ArrayList<Integer> arrayList = hashMap.get(correctKey.get(j));
                if (arrayList.size() > 0 && score <= arrayList.get(arrayList.size() - 1))
                    count += bsearch(arrayList, score);
            }
            answer[i] = count;
        }
        return answer;
    }

    private static int bsearch(ArrayList<Integer> arrayList, int score) {
        int start = 0;
        int end = arrayList.size() - 1;
        int min = arrayList.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arrayList.get(mid) >= score) {
                min = Math.min(mid, min);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return arrayList.size() - min;
    }

    private static boolean isCanAnswer(String key, String s) {
        for (int i = 0; i < key.length(); i++) {
            if (key.charAt(i) == '4') {
                continue;
            } else {
                if (key.charAt(i) != s.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static String makeKey(String language, String position, String age, String food) {
        StringBuilder stringBuilder = new StringBuilder();
        if (language.equals("cpp")) {
            stringBuilder.append(1);
        } else if (language.equals("java")) {
            stringBuilder.append(2);
        } else if (language.equals("python")) {
            stringBuilder.append(3);
        } else {
            stringBuilder.append(4);
        }

        if (position.equals("backend")) {
            stringBuilder.append(1);
        } else if (position.equals("frontend")) {
            stringBuilder.append(2);
        } else {
            stringBuilder.append(4);
        }

        if (age.equals("junior")) {
            stringBuilder.append(1);
        } else if (age.equals("senior")) {
            stringBuilder.append(2);
        } else {
            stringBuilder.append(4);
        }

        if (food.equals("chicken")) {
            stringBuilder.append(1);
        } else if (food.equals("pizza")) {
            stringBuilder.append(2);
        } else {
            stringBuilder.append(4);
        }
        return stringBuilder.toString();
    }
}

package TEST.K;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class PS02 {
    public static void main(String[] args) {
        String[] order = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};
        System.out.println(solution(order, course));
    }

    public static String[] solution(String[] orders, int[] course) {
        HashMap<String, Integer> combSet = new HashMap<>();
        for (int i = 0; i < orders.length; i++) {
            String[] split = orders[i].split("");
            for (int j = 0; j < Math.pow(2, orders[i].length()); j++) {
                if (Integer.bitCount(j) >= 2) {
                    String bit = new StringBuffer(Integer.toBinaryString(j)).reverse().toString();
                    String[] bitSplit = bit.split("");
                    String comb = "";
                    for (int k = 0; k < bitSplit.length; k++) {
                        if (bitSplit[k].equals("1")) {
                            comb += split[k];
                        }
                    }
                    combSet.put(comb, 1);
                }
            }
        }
        combSet = eraseDuplicateKey(combSet);
        ArrayList<Comb> arrayList = new ArrayList<>();
        for (String key : combSet.keySet()) {
            String[] keySplit = key.split("");
            int count = 0;
            for (int i = 0; i < orders.length; i++) {
                String order = orders[i];
                boolean[] keyCheck = new boolean[keySplit.length];
                for (int j = 0; j < keySplit.length; j++) {
                    if (order.contains(keySplit[j])) {
                        keyCheck[j] = true;
                    }
                }
                if (isAllTrue(keyCheck)) {
                    count++;
                }
            }
            arrayList.add(new Comb(key, key.length(), count));
        }
        Collections.sort(arrayList);
        ArrayList<String> answers = new ArrayList<>();
        for (int i = 0; i < course.length; i++) {
            int courseNum = course[i];
            int beforeMax = 0;
            for (int j = 0; j < arrayList.size(); j++) {
                Comb comb = arrayList.get(j);
                if (courseNum == comb.length) {
                    if (comb.count > 1) {
                        if (beforeMax <= comb.count) {
                            answers.add(comb.key);
                            beforeMax = comb.count;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        String[] answer = new String[answers.size()];
        Collections.sort(answers);
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answers.get(i);
            //System.out.println(answer[i]);
        }
        return answer;
    }

    private static HashMap<String, Integer> eraseDuplicateKey(HashMap<String, Integer> combSet) {
        HashMap<String, Integer> newHashMap = new HashMap<>();
        for (String key : combSet.keySet()) {
            String[] strings = key.split("");
            Arrays.sort(strings);
            String newKey = "";
            for (int i = 0; i < strings.length; i++) {
                newKey += strings[i];
            }
            newHashMap.put(newKey, 1);
        }
        return newHashMap;
    }

    private static boolean isAllTrue(boolean[] keyCheck) {
        for (int i = 0; i < keyCheck.length; i++) {
            if (!keyCheck[i]) {
                return false;
            }
        }
        return true;
    }
}

class Comb implements Comparable<Comb> {
    String key;
    int length;
    int count;

    Comb(String key, int length, int count) {
        this.key = key;
        this.length = length;
        this.count = count;
    }

    @Override
    public int compareTo(Comb o) {
        if (this.length > o.length) {
            return 1;
        } else if (this.length < o.length) {
            return -1;
        } else {
            if (this.count > o.count) {
                return -1;
            } else if (this.count < o.count) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
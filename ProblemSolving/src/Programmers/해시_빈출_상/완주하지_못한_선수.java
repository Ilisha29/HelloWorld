package Programmers.해시_빈출_상;

import java.util.HashMap;

public class 완주하지_못한_선수 {
    public static void main(String[] args) {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};

        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            if (stringIntegerHashMap.containsKey(participant[i])) {
                stringIntegerHashMap.put(participant[i], stringIntegerHashMap.get(participant[i]) + 1);
            } else {
                stringIntegerHashMap.put(participant[i], 1);
            }
        }

        for (int i = 0; i < completion.length; i++) {
            if (stringIntegerHashMap.get(completion[i]) != 1) {
                stringIntegerHashMap.put(completion[i], stringIntegerHashMap.get(completion[i]) - 1);
            } else {
                stringIntegerHashMap.remove(completion[i]);
            }
        }
        String answer = "";
        for (String key : stringIntegerHashMap.keySet()) {
            answer = key;
        }

        System.out.println(answer);
        /*
        for (String key : stringIntegerHashMap.keySet()) {
            int value = stringIntegerHashMap.get(key);
            System.out.println(key + " : " + value);
        }
        */
    }
}

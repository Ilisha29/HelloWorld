package KAKAO.KAKAO2018공채.prac;

import java.util.*;

public class k2 {
    public static void main(String[] args) {
        String[] msgs = {
                "KAKAO",
                "TOBEORNOTTOBEORTOBEORNOT",
                "ABABABABABABABAB"
        };
        for (int i = 0; i < msgs.length; i++) {
            int[] answer = solution(msgs[i]);
            for (int j = 0; j < answer.length; j++) {
                System.out.println(answer[j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 'A'; i <= 'Z'; i++) {
            map.put(Character.toString(i), i - 64);
        }
        String[] strings = msg.split("");
        ArrayList<Integer> tmpAnswer = new ArrayList<>();
        int value = 27;
        Queue<String> stringsQueue = new LinkedList<>();
        for (int i = 0; i < strings.length; i++) {
            stringsQueue.add(strings[i]);
        }
        while (!stringsQueue.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder("");
            while (map.containsKey(stringBuilder.toString() + stringsQueue.peek())) {
                stringBuilder.append(stringsQueue.poll());
            }
            tmpAnswer.add(map.get(stringBuilder.toString()));
            if (stringsQueue.isEmpty()) {
                break;
            }
            map.put(stringBuilder.append(stringsQueue.peek()).toString(), value++);
        }
        int[] answer = new int[tmpAnswer.size()];
        for (int i = 0; i < tmpAnswer.size(); i++) {
            answer[i] = tmpAnswer.get(i);
        }
        return answer;
    }
}

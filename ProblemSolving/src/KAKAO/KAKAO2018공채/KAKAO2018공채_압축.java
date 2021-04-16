package KAKAO.KAKAO2018공채;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

// 20 : 18
public class KAKAO2018공채_압축 {
    public static void main(String[] args) {
        String msg = "TOBEORNOTTOBEORTOBEORNOT"; // [20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34]
        int[] answer = solution(msg);
        for (int e : answer) {
            System.out.println(e);
        }
    }

    public static int[] solution(String msg) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 1; i <= 26; i++) {
            hashMap.put(Character.toString((char) (i + 64)), i);
        }
        String[] strings = msg.split("");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < strings.length; i++) {
            queue.offer(strings[i]);
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        int lastKey = 27;
        while (!queue.isEmpty()) {
            String tmp = queue.poll();
            while (hashMap.containsKey(tmp + queue.peek())) {
                tmp += queue.poll();
            }
            arrayList.add(hashMap.get(tmp));
            tmp += queue.peek();
            hashMap.put(tmp, lastKey++);
        }

        int[] answer = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            answer[i]  = arrayList.get(i);
        }
        return answer;
    }
}
// 20 : 47 end 30분
package KAKAO.KAKAO2018공채;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// 11 : 35
public class KAKAO2018공채_다트게임 {
    public static void main(String[] args) {
        String[] strings = {"1S2D*3T", "1D2S#10S", "1D2S0T", "1S*2T*3S", "1D#2S*3S", "1T2D3D#", "1D2S3T*"};
        for (int i = 0; i < strings.length; i++) {
            System.out.println(solution(strings[i]));
        }
    }

    public static int solution(String dartResult) {
        int answer = 0;
        String[] strings = dartResult.split("");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < strings.length; i++) {
            queue.offer(strings[i]);
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!queue.isEmpty()) {
            String point = queue.poll();
            String tmp = queue.peek();
            if (!tmp.equals("S") && !tmp.equals("D") && !tmp.equals("T")) {
                point += queue.poll();
            }
            String option = queue.poll();
            int score = 0;
            if (option.equals("S")) {
                score += Math.pow(Integer.parseInt(point), 1);
            } else if (option.equals("D")) {
                score += Math.pow(Integer.parseInt(point), 2);
            } else {
                score += Math.pow(Integer.parseInt(point), 3);
            }

            if (!queue.isEmpty() && queue.peek().equals("*")) {
                score *= 2;
                if (!arrayList.isEmpty()) {
                    int index = arrayList.size() - 1;
                    arrayList.set(index, arrayList.get(arrayList.size() - 1) * 2);
                }
                queue.poll();
            }


            if (!queue.isEmpty() && queue.peek().equals("#")) {
                score *= -1;
                queue.poll();
            }

            arrayList.add(score);
        }
        for (int i = 0; i < arrayList.size(); i++) {
            answer += arrayList.get(i);
        }
        return answer;
    }
}
// 12: 08 // 약 30분
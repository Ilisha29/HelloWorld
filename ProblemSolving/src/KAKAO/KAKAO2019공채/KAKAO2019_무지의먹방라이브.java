package KAKAO.KAKAO2019공채;

import java.util.ArrayList;
import java.util.Collections;

public class KAKAO2019_무지의먹방라이브 {
    public static void main(String[] args) {
        int[] food_times = {4, 4, 1, 5, 3, 4, 5, 7, 8, 3, 1, 2};
        long k = 5;
        System.out.println(solution(food_times, k));
    }

    public static int solution(int[] food_times, long k) {
        int answer = 0;
        ArrayList<Food> arrayList = new ArrayList<>();
        for (int i = 0; i < food_times.length; i++) {
            answer += food_times[i];
            arrayList.add(new Food(food_times[i], i));
        }
        if (answer <= k) {
            return -1;
        } else {
            answer = 0;
        }
        Collections.sort(arrayList);
        ArrayList<Integer> indexArraylist = new ArrayList<>();
        int length = arrayList.size();
        for (int i = 0; i < arrayList.size(); i++) {
            if (k == 0) {
                return findAnswer(i + 1, indexArraylist);
            }
            if ((length - i) * arrayList.get(i).time < k) {

            }
        }
        return answer;
    }

    private static int findAnswer(int i, ArrayList<Integer> arrayList) {
        while (arrayList.contains(i)) {
            i++;
        }
        return i;
    }
}

class Food implements Comparable<Food> {
    int time;
    int index;

    Food(int time, int index) {
        this.time = time;
        this.index = index;
    }

    @Override
    public int compareTo(Food o) {
        if (this.time > o.time) {
            return 1;
        } else if (this.time < o.time) {
            return -1;
        } else
            return 0;
    }
}

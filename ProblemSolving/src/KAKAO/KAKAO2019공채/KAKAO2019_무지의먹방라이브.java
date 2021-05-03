package KAKAO.KAKAO2019공채;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class KAKAO2019_무지의먹방라이브 {
    public static void main(String[] args) {
        int[] food_times = {3, 1, 2};
        long k = 5;
        System.out.println(solution(food_times, k));
    }

    public static int solution(int[] food_times, long k) {
        int answer = -1;
        ArrayList<Food> foodArrayList = new ArrayList<Food>();
        for (int i = 0; i < food_times.length; i++) {
            foodArrayList.add(new Food(i + 1, food_times[i]));
        }
        Collections.sort(foodArrayList);

        long beforesize = 0;
        long list_size = foodArrayList.size();
        long sum = 0;
        for (int i = 0; i < list_size; i++) {
            long gap = (long) foodArrayList.get(i).time - beforesize;
            if (gap * (list_size - i) + sum > k) {
                break;
            }
            sum += gap * (list_size - i);
            beforesize = foodArrayList.get(i).time;
        }
        return answer;
    }
}

class Food implements Comparable<Food> {
    int num;
    int time;

    Food(int num, int time) {
        this.num = num;
        this.time = time;
    }

    @Override
    public int compareTo(Food o) {
        if (this.time > o.time) {
            return 1;
        } else if (this.time < o.time) {
            return -1;
        } else {
            return 0;
        }
    }
}

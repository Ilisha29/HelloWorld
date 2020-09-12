package KAKAO.KAKAO공채연습._2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 무지의먹방라이브 {
    public static void main(String[] args) {
        int[] foods = {3, 1, 2};
        int k = 5;
        System.out.println(solution(foods, k));
    }

    public static int solution(int[] food_times, long k) {
        int answer = 0;
        ArrayList<Food> foods = new ArrayList<>();
        long totalSum = 0;
        for (int i = 0; i < food_times.length; i++) {
            foods.add(new Food(food_times[i], i));
            totalSum += (long) food_times[i];
        }
        if (totalSum <= k) {
            return -1;
        }
        Collections.sort(foods);
        int beforeNum = 0;
        for (int i = 0; i < foods.size(); i++) {
            int size = foods.size() - i;
            int repNum = foods.get(i).time - beforeNum;
            while (true) {
                if (repNum == 0) {
                    break;
                }
                if (k == 0 || size > k) {
                    return calculateIndex(k, i, foods);
                }
                k -= size;
                repNum--;
            }
            beforeNum = foods.get(i).time;
        }
        return answer;
    }

    private static int calculateIndex(long k, int i, ArrayList<Food> foods) {
        int[] index = new int[foods.size() - i];
        for (int j = i; j < foods.size(); j++) {
            index[j - i] = foods.get(j).index;
        }
        Arrays.sort(index);
        return index[(int) k] + 1;
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
package KAKAO.KAKAO2019공채;

import java.util.*;

public class KAKAO2019_무지의먹방라이브2 {
    public static void main(String[] args) {
        int[] food_times = {3, 1, 2};
        long k = 5;
        System.out.println(solution(food_times, k));
    }

    public static int solution(int[] food_times, long k) {
        int answer = -1;
        Queue<Dish> foodTimesQueue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < food_times.length; i++) {
            foodTimesQueue.add(new Dish(i + 1, food_times[i]));
            set.add(food_times[i]);
        }
        int[] notDuplicateNum = new int[set.size()];
        int index = 0;
        for (Integer i : set) {
            notDuplicateNum[index++] = i;
        }
        Arrays.sort(notDuplicateNum);
        for (int i = notDuplicateNum.length - 1; i >= 1; i--) {
            notDuplicateNum[i] -= notDuplicateNum[i - 1];
        }
        int arrayIndex = 0;
        while (!foodTimesQueue.isEmpty() && k > 0) {
            int food_time = notDuplicateNum[arrayIndex];
            if ((long) food_time * foodTimesQueue.size() > k) {
                break;
            }
            arrayIndex++;
            k -= (long) food_time * foodTimesQueue.size();
            int queueSize = foodTimesQueue.size();
            for (int i = 0; i < queueSize; i++) {
                Dish tmp = foodTimesQueue.poll();
                tmp.value -= food_time;
                if (tmp.value != 0) {
                    foodTimesQueue.add(tmp);
                }
            }

        }
        if (foodTimesQueue.isEmpty()) {
            return -1;
        }
        if (k == 0) {
            answer = foodTimesQueue.peek().index;
            return answer;
        }

        while (!foodTimesQueue.isEmpty() && k > 0) {
            Dish tmp = foodTimesQueue.poll();
            tmp.value--;
            k--;
            if (tmp.value != 0) {
                foodTimesQueue.add(tmp);
            }
        }
        if (foodTimesQueue.isEmpty()) {
            return -1;
        }
        answer = foodTimesQueue.peek().index;
        return answer;
    }
}

class Dish {
    int index;
    int value;

    public Dish(int index, int value) {
        this.index = index;
        this.value = value;
    }
}
/*
        Dish dish = new Dish(food_times[0], 1);
        Dish start = dish;
        for (int i = 1; i < size; i++) {
            Dish after = new Dish(food_times[i], i + 1);
            after.before = dish;
            dish.next = after;
            dish = dish.next;
            if (i == size - 1) {
                start.before = dish;
                dish.next = start;
                dish = dish.next;
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < food_times.length; i++) {
            set.add(food_times[i]);
        }
        Integer[] notDuplicateFoodTimes = set.toArray(new Integer[set.size()]);
        while (size > 0 && k > 0) {

        }
        if (size == 0) {
            return -1;
        }
        return dish.index;
    }
}

class Dish {
    int value;
    int index;
    Dish before;
    Dish next;

    public Dish(int value, int index) {
        this.value = value;
        this.index = index;
    }
}
 */
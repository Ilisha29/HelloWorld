package TEST.L;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class P2 {
    public static void main(String[] args) {
        int[] ball = {1, 2, 3, 4, 5, 6};
        int[] order = {6, 2, 5, 1, 4, 3};
        int[] result = solution(ball, order);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static int[] solution(int[] ball, int[] order) {
        int[] answer = new int[ball.length];
        Deque<Integer> integers = new LinkedList<>();
        for (int i = 0; i < ball.length; i++) {
            integers.offer(ball[i]);
        }
        ArrayList<Integer> preOrders = new ArrayList<>();
        int index = 0;
        int readIndex = 0;
        int target = 0;
        while (!integers.isEmpty()) {
            int first = integers.peekFirst();
            int last = integers.peekLast();
            if (preOrders.contains(first)) {
                answer[index++] = integers.pollFirst();
            } else if (preOrders.contains(last)) {
                answer[index++] = integers.pollLast();
            } else {
                target = order[readIndex++];
                if (first == target) {
                    integers.pollFirst();
                    answer[index++] = target;
                } else if (last == target) {
                    integers.pollLast();
                    answer[index++] = target;
                } else {
                    preOrders.add(target);
                }
            }
        }
        return answer;
    }

}

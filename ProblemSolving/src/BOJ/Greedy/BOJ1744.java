package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(bufferedReader.readLine());
        }
        Arrays.sort(array);
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            deque.addLast(array[i]);
        }
        int sum = 0;
        while (!deque.isEmpty() && deque.peekLast() > 0) {
            int first = deque.pollLast();
            if (deque.isEmpty()) {
                sum += first;
                break;
            }
            if (deque.peekLast() > 1) {
                sum += first * deque.pollLast();
            } else if (deque.peekLast() == 1) {
                sum += first;
                sum += deque.pollLast();
            } else {
                sum += first;
            }
        }
        while (deque.size() > 1) {
            int first = deque.pollFirst();
            int second = deque.pollFirst();
            sum += first * second;
        }
        while (!deque.isEmpty()) {
            sum += deque.poll();
        }
        System.out.println(sum);
        bufferedReader.close();
    }
}

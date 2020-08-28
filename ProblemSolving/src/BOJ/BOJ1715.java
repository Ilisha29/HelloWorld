package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        for (int i = 0; i < N; i++) {
            priorityQueue.offer(Integer.parseInt(bufferedReader.readLine()));
        }
        int sum = 0;
        while (priorityQueue.size() != 1) {
            int tmp = priorityQueue.poll() + priorityQueue.poll();
            sum += tmp;
            priorityQueue.offer(tmp);
        }
        System.out.println(sum);
        bufferedReader.close();
    }
}

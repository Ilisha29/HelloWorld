package BOJ._1Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ11000_ {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[][] array = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            array[i][0] = Integer.parseInt(input[0]);
            array[i][1] = Integer.parseInt(input[1]);
        }
        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(array[0][1]);
        for (int i = 1; i < array.length; i++) {
            int compareNum = priorityQueue.peek();
            if (compareNum <= array[i][0]){
                priorityQueue.poll();
            }
            priorityQueue.add(array[i][1]);
        }
        System.out.println(priorityQueue.size());
        bufferedReader.close();
    }
}

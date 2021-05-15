package BOJ._7MinimumLength.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ13549 {
    private static final int maxLength = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());
        int[] minLength = new int[maxLength + 1];
        Arrays.fill(minLength, Integer.MAX_VALUE);
        PriorityQueue<Sulae> priorityQueue = new PriorityQueue<Sulae>(new Comparator<Sulae>() {
            @Override
            public int compare(Sulae o1, Sulae o2) {
                return o1.time - o2.time;
            }
        });
        minLength[N] = 0;
        priorityQueue.add(new Sulae(N, 0));
        while (!priorityQueue.isEmpty()) {
            Sulae sulae = priorityQueue.poll();
            if (minLength[sulae.to] < sulae.time) {
                continue;
            }
            int minusLocation = sulae.to - 1;
            int minusTime = sulae.time + 1;
            if (minusLocation >= 0) {
                if (minLength[minusLocation] > minusTime) {
                    minLength[minusLocation] = minusTime;
                    priorityQueue.add(new Sulae(minusLocation, minusTime));
                }
            }
            int plusLocation = sulae.to + 1;
            int plusTime = sulae.time + 1;
            if (plusLocation <= maxLength) {
                if (minLength[plusLocation] > plusTime) {
                    minLength[plusLocation] = plusTime;
                    priorityQueue.add(new Sulae(plusLocation, plusTime));
                }
            }
            int flashLocation = sulae.to * 2;
            if (flashLocation <= maxLength) {
                if (minLength[flashLocation] > sulae.time) {
                    minLength[flashLocation] = sulae.time;
                    priorityQueue.add(new Sulae(flashLocation, sulae.time));
                }
            }
        }
        System.out.println(minLength[K]);
        bufferedReader.close();
    }
}

class Sulae {
    int to;
    int time;

    public Sulae(int to, int time) {
        this.to = to;
        this.time = time;
    }
}
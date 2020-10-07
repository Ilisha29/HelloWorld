package BOJ.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1916 {
    final static int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(bufferedReader.readLine());
        int e = Integer.parseInt(bufferedReader.readLine());
        int[][] adjMatrix = new int[v + 1][v + 1];
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix.length; j++) {
                if (i != j) {
                    adjMatrix[i][j] = INF;
                }
            }
        }
        StringTokenizer stringTokenizer;
        for (int i = 0; i < e; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(stringTokenizer.nextToken());
            int to = Integer.parseInt(stringTokenizer.nextToken());
            int weight = Integer.parseInt(stringTokenizer.nextToken());
            adjMatrix[from][to] =  Math.min(adjMatrix[from][to],weight);
        }
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int start = Integer.parseInt(stringTokenizer.nextToken());
        int end = Integer.parseInt(stringTokenizer.nextToken());
        int[] minLengthTable = new int[v + 1];
        Arrays.fill(minLengthTable, INF);
        PriorityQueue<NODE> priorityQueue = new PriorityQueue<>();
        //minLengthTable[start] = 0;
        priorityQueue.offer(new NODE(start, 0));
        while (!priorityQueue.isEmpty()) {
            NODE node = priorityQueue.poll();
            for (int i = 0; i < minLengthTable.length; i++) {
                System.out.print(minLengthTable[i] + " ");
            }
            System.out.println();
            if (minLengthTable[node.to] < node.length) {
                continue;
            }
            for (int i = 0; i < adjMatrix.length; i++) {
                int dist = node.length + adjMatrix[node.to][i];
                if (dist < minLengthTable[i]) {
                    minLengthTable[i] = dist;
                    priorityQueue.offer(new NODE(i, dist));
                }
            }
        }
        System.out.println(minLengthTable[end]);
        bufferedReader.close();
    }
}

class NODE implements Comparable<NODE> {
    int to;
    int length;

    NODE(int to, int length) {
        this.to = to;
        this.length = length;
    }

    @Override
    public int compareTo(NODE o) {
        return this.length - o.length;
    }
}
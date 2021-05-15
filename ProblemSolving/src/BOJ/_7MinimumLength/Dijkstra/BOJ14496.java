package BOJ._7MinimumLength.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ14496 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int from = Integer.parseInt(stringTokenizer.nextToken());
        int to = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int[][] adjMatrix = new int[N + 1][N + 1];
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix.length; j++) {
                if (i != j) {
                    adjMatrix[i][j] = 1000000000;
                }
            }
        }
        int[] minLengthTable = new int[N + 1];
        for (int i = 0; i < minLengthTable.length; i++) {
            minLengthTable[i] = 1000000000;
        }
        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int adjX = Integer.parseInt(stringTokenizer.nextToken());
            int adjY = Integer.parseInt(stringTokenizer.nextToken());
            adjMatrix[adjX][adjY] = 1;
            adjMatrix[adjY][adjX] = 1;
        }
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Node(0, from));
        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();
            if (minLengthTable[node.index] < node.length) {
                continue;
            }
            for (int i = 1; i < adjMatrix.length; i++) {
                int dist = node.length + adjMatrix[node.index][i];
                if (dist < minLengthTable[i]) {
                    minLengthTable[i] = dist;
                    priorityQueue.offer(new Node(dist, i));
                }
            }
        }
        if (minLengthTable[to] == 1000000000) {
            System.out.println(-1);
        } else {
            System.out.println(minLengthTable[to]);
        }
        bufferedReader.close();
    }
}

class Node implements Comparable<Node> {
    int length;
    int index;

    Node(int length, int index) {
        this.length = length;
        this.index = index;
    }

    @Override
    public int compareTo(Node o) {
        return this.length - o.length;
    }
}
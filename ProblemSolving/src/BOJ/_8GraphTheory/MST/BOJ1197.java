package BOJ._8GraphTheory.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ1197 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] VE = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] table = new int[VE[0] + 1];
        for (int i = 0; i < table.length; i++) {
            table[i] = i;
        }
        PriorityQueue<Edge> edges = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });
        for (int i = 0; i < VE[1]; i++) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            edges.add(new Edge(info[0], info[1], info[2]));
        }
        bufferedReader.close();
        int weightSum = 0;
        int edgeCount = 0;
        while (edgeCount != VE[0] - 1) {
            Edge edge = edges.poll();
            int A = find(table, edge.vertex1);
            int B = find(table, edge.vertex2);
            if (A != B) {
                union(table, A, B);
                weightSum += edge.weight;
                edgeCount++;
            }
        }
        System.out.println(weightSum);
    }

    private static void union(int[] table, int vertex1, int vertex2) {
        if (vertex1 < vertex2) {
            table[vertex2] = vertex1;
        } else {
            table[vertex1] = vertex2;
        }
    }

    private static int find(int[] table, int vertex) {
        if (table[vertex] != vertex) {
            table[vertex] = find(table, table[vertex]);
        }
        return table[vertex];
    }
}

class Edge {
    int vertex1;
    int vertex2;
    int weight;

    public Edge(int vertex1, int vertex2, int weight) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
    }
}

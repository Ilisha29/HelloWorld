package BOJ.Dijkstra;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1753 {

    /*
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6
    첫째 줄에 정점의 개수 V와 간선의 개수 E가 주어진다.
    (1≤V≤20,000, 1≤E≤300,000) 모든 정점에는 1부터 V까지 번호가 매겨져 있다고 가정한다.
    둘째 줄에는 시작 정점의 번호 K(1≤K≤V)가 주어진다.
    셋째 줄부터 E개의 줄에 걸쳐 각 간선을 나타내는 세 개의 정수 (u, v, w)가 순서대로 주어진다.
    이는 u에서 v로 가는 가중치 w인 간선이 존재한다는 뜻이다. u와 v는 서로 다르며 w는 10 이하의 자연수이다.
    서로 다른 두 정점 사이에 여러 개의 간선이 존재할 수도 있음에 유의한다.
     */
    //16:00
    static final int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        //인접 행렬 : 752904
        //인접 리스트 :
        //long preUseMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int V = Integer.parseInt(stringTokenizer.nextToken());
        int E = Integer.parseInt(stringTokenizer.nextToken());
        int from = Integer.parseInt(bufferedReader.readLine());
        ArrayList<ArrayList<Edge>> arrayLists = new ArrayList<>();
        for (int i = 0; i < V + 1; i++) {
            arrayLists.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int u = Integer.parseInt(stringTokenizer.nextToken());
            int v = Integer.parseInt(stringTokenizer.nextToken());
            int w = Integer.parseInt(stringTokenizer.nextToken());
            arrayLists.get(u).add(new Edge(v,w));
        }
        int[] minLengthTable = new int[V + 1];
        Arrays.fill(minLengthTable, INF);
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Vertex(0, from));
        minLengthTable[from] = 0;
        while (!priorityQueue.isEmpty()) {
            Vertex vertex = priorityQueue.poll();
            if (minLengthTable[vertex.index] < vertex.length) {
                continue;
            }
            ArrayList<Edge> edges = arrayLists.get(vertex.index);
            for (int i = 0; i < edges.size(); i++) {
                Edge edge = edges.get(i);
                int dist = vertex.length + edge.weight;
                if (dist < minLengthTable[edge.to]) {
                    minLengthTable[edge.to] = dist;
                    priorityQueue.offer(new Vertex(dist, edge.to));
                }
            }
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i < minLengthTable.length; i++) {
            if (minLengthTable[i] == INF) {
                bufferedWriter.write("INF");
            } else {
                bufferedWriter.write(Integer.toString(minLengthTable[i]));
            }
            bufferedWriter.write("\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void fixArrayLists(ArrayList<ArrayList<Edge>> arrayLists, int u, int v, int w) {
        ArrayList<Edge> edges = arrayLists.get(u);
        for (int i = 0; i < edges.size(); i++) {
            if (edges.get(i).to == v) {
                edges.get(i).weight = Math.min(edges.get(i).weight, w);
                return;
            }
        }
        edges.add(new Edge(v, w));
    }
}

class Edge {
    int to;
    int weight;

    Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

class Vertex implements Comparable<Vertex> {
    int length;
    int index;

    Vertex(int length, int index) {
        this.length = length;
        this.index = index;
    }

    @Override
    public int compareTo(Vertex o) {
        return this.length - o.length;
    }
}

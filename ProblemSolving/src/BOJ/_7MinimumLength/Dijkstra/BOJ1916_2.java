package BOJ._7MinimumLength.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1916_2 {
    private static final int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(bufferedReader.readLine());
        int E = Integer.parseInt(bufferedReader.readLine());
        int[] table = new int[V + 1];
        Arrays.fill(table, INF);
        int[][] adjMatrix = new int[V + 1][V + 1];
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix.length; j++) {
                if (i != j) {
                    adjMatrix[i][j] = INF;
                }
            }
        }
        for (int i = 0; i < E; i++) {
            int[] busInput = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int from = busInput[0];
            int to = busInput[1];
            int price = busInput[2];
            adjMatrix[from][to] = price;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int start = Integer.parseInt(stringTokenizer.nextToken());
        int end = Integer.parseInt(stringTokenizer.nextToken());
        PriorityQueue<Bus> buses = new PriorityQueue<Bus>(new Comparator<Bus>() {
            @Override
            public int compare(Bus o1, Bus o2) {
                return o1.price - o2.price;
            }
        });
        buses.add(new Bus(start, 0));
        while (!buses.isEmpty()){
            Bus tmpBus = buses.poll();
            if (table[tmpBus.to] < tmpBus.price){
                continue;
            }
            for (int i = 0; i < adjMatrix.length; i++) {
                int dist = tmpBus.price + adjMatrix[tmpBus.to][i];
                if (dist < table[i]) {
                    table[i] = dist;
                    buses.offer(new Bus(i, dist));
                }
            }
        }
        System.out.println(table[end]);
        bufferedReader.close();
    }
}
class Bus {
    int to;
    int price;

    public Bus(int to, int price) {
        this.to = to;
        this.price = price;
    }
}
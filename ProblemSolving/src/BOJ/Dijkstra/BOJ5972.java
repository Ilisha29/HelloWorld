package BOJ.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ5972 {
    public static void main(String[] args) throws IOException {
        //초기화
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int[] table = new int[N + 1];
        Arrays.fill(table, Integer.MAX_VALUE);
        ArrayList<ArrayList<Road>> arrayLists = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            arrayLists.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);
            int cow = Integer.parseInt(input[2]);
            arrayLists.get(from).add(new Road(from, to, cow));
            arrayLists.get(to).add(new Road(to, from, cow));
        }
        table[1] = 0;
        PriorityQueue<Road> roads = new PriorityQueue<>(new Comparator<Road>() {
            @Override
            public int compare(Road o1, Road o2) {
                return o1.cow - o2.cow;
            }
        });
        roads.add(new Road(0, 1, 0));
        //priorityQueue계산
        while (!roads.isEmpty()) {
            Road road = roads.poll();
            if (table[road.to] < road.cow) {
                continue;
            }
            for (int i = 0; i < arrayLists.get(road.to).size(); i++) {
                Road tmpRoad = arrayLists.get(road.to).get(i);
                int to = tmpRoad.to;
                int dist = road.cow + tmpRoad.cow;
                if (table[to] > dist) {
                    table[to] = dist;
                    roads.add(new Road(0, to, dist));
                }
            }
        }
        //출력값
        System.out.println(table[N]);
        bufferedReader.close();
    }
}

class Road {
    int from;
    int to;
    int cow;

    public Road(int from, int to, int cow) {
        this.from = from;
        this.to = to;
        this.cow = cow;
    }
}
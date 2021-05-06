package KAKAO.K2021공채;

import java.util.*;

public class K4 {
    public static void main(String[] args) {
        int[] n = {6, 7, 6};
        int[] s = {4, 3, 4};
        int[] a = {6, 4, 5};
        int[] b = {2, 1, 6};
        int[][][] fares = {
                {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}},
                {{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}},
                {{2, 6, 6}, {6, 3, 7}, {4, 6, 7}, {6, 5, 11}, {2, 5, 12}, {5, 3, 20}, {2, 4, 8}, {4, 3, 9}}
        };
        for (int i = 0; i < n.length; i++) {
            System.out.println(solution(n[i], s[i], a[i], b[i], fares[i]));
        }
    }

    private static Map<Integer, List<Point5>> hashMap;
    private static final int INF = 10000000;

    public static int solution(int n, int s, int a, int b, int[][] fares) {
        hashMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            hashMap.put(i, new ArrayList<>());
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < fares.length; i++) {
            int x = fares[i][0];
            int y = fares[i][1];
            int length = fares[i][2];
            hashMap.get(x).add(new Point5(y, length));
            hashMap.get(y).add(new Point5(x, length));
        }
        for (int i = 1; i <= n; i++) {
            int length1 = Dijkstra(i, s, n);
            int length2 = Dijkstra(i, a, n);
            int length3 = Dijkstra(i, b, n);
            answer = Math.min(length1 + length2 + length3, answer);
        }
        return answer;
    }

    private static int Dijkstra(int i, int to, int size) {
        int[] minLength = new int[size + 1];
        Arrays.fill(minLength, INF);
        PriorityQueue<Point5> points = new PriorityQueue<>(new Comparator<Point5>() {
            @Override
            public int compare(Point5 o1, Point5 o2) {
                return o1.length - o2.length;
            }
        });
        points.add(new Point5(i, 0));
        while (!points.isEmpty()) {
            Point5 point = points.poll();
            if (minLength[point.to] < point.length) {
                continue;
            }
            minLength[point.to] = point.length;
            if (point.to == to) {
                break;
            }
            List<Point5> list = hashMap.get(point.to);
            for (int j = 0; j < list.size(); j++) {
                Point5 tmp = list.get(j);
                int dist = point.length + tmp.length;
                if (dist < minLength[tmp.to]) {
                    points.add(new Point5(tmp.to, dist));
                }
            }
        }
        return minLength[to];
    }
}

class Point5 {
    int to;
    int length;

    Point5(int to, int length) {
        this.to = to;
        this.length = length;
    }
}
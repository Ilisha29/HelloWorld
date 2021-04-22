package Programmers.그리디;

import java.util.*;

public class 섬연결하기 {
    public static void main(String[] args) {
        int[][] costs = {{0, 1, 1}, {0, 4, 5}, {2, 4, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 5;
        System.out.println(solution(n, costs));
    }

    public static int solution(int n, int[][] costs) {
        int answer = 0;
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < costs.length; i++) {
            points.add(new Point(costs[i][0], costs[i][1], costs[i][2]));
        }
        Collections.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                return p1.cost - p2.cost;
            }
        });
        boolean[] visit = new boolean[n];
        int count = 0;
        for (int i = 0; i < points.size(); i++) {
            if (count == n - 1) {
                break;
            }
            Point p = points.get(i);
            if (!visit[p.to] || !visit[p.from]) {
                visit[p.to] = true;
                visit[p.from] = true;
                answer += p.cost;
                count++;
            }
        }
        return answer;
    }
}

class Point {
    int to;
    int from;
    int cost;

    Point(int to, int from, int cost) {
        this.to = to;
        this.from = from;
        this.cost = cost;
    }
}
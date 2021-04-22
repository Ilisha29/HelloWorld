package Programmers.그리디.Kruskal;

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
        for (int i = 0; i < costs.length; i++){
            points.add(new Point(costs[i][0],costs[i][1],costs[i][2]));
        }
        Collections.sort(points, new Comparator<Point>(){
            @Override
            public int compare(Point p1, Point p2){
                return p1.cost - p2.cost;
            }
        });
        int count = 0;
        int[] parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        for(int i = 0; i < points.size(); i++){
            if (count == n - 1){
                break;
            }
            Point p = points.get(i);
            int to = find(parent, p.to);
            int from = find(parent, p.from);
            if (to != from){
                union(parent, p.to, p.from);
                answer += p.cost;
                count++;
            }
        }
        return answer;
    }

    private static void union(int[] parent, int A, int B) {
        A = find(parent, A);
        B = find(parent, B);
        if (A < B){
            parent[B] = A;
        } else {
            parent[A] = B;
        }
    }

    private static int find(int[] parent, int X) {
        if (parent[X] != X){
            parent[X] = find(parent, parent[X]);
        }
        return parent[X];
    }
}

class Point {
    int to;
    int from;
    int cost;

    Point(int to,  int from, int cost){
        this.to = to;
        this.from = from;
        this.cost = cost;
    }
}
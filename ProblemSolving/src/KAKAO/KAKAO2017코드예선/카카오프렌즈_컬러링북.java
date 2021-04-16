package KAKAO.KAKAO2017코드예선;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class 카카오프렌즈_컬러링북 {
    public static void main(String[] args) {
        int[][] pic = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int[] result = solution(6, 4, pic);
        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        boolean[][] visit = new boolean[m][n];
        int[][] newMap = new int[m][n];
        int areaNum = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && !visit[i][j]) {
                    Queue<Point> points = new LinkedList<>();
                    visit[i][j] = true;
                    newMap[i][j] = areaNum;
                    points.offer(new Point(i, j, picture[i][j]));
                    while (!points.isEmpty()) {
                        Point tmpPoint = points.poll();
                        int X = tmpPoint.x;
                        int Y = tmpPoint.y;
                        int[] dx = {-1, 0, 1, 0};
                        int[] dy = {0, 1, 0, -1};
                        for (int k = 0; k < 4; k++) {
                            int newX = X + dx[k];
                            int newY = Y + dy[k];
                            if (newX >= 0 && newX < m && newY >= 0 && newY < n && tmpPoint.color == picture[newX][newY] && !visit[newX][newY]) {
                                visit[newX][newY] = true;
                                newMap[newX][newY] = areaNum;
                                points.offer(new Point(newX, newY, tmpPoint.color));
                            }
                        }
                    }
                    areaNum++;
                }
            }
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (newMap[i][j] != 0) {
                    hashMap.put(newMap[i][j], hashMap.getOrDefault(newMap[i][j], 0) + 1);
                }
            }
        }
        for (Integer key : hashMap.keySet()) {
            numberOfArea = Math.max(numberOfArea, key);
            maxSizeOfOneArea = Math.max(maxSizeOfOneArea, hashMap.get(key));
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}

class Point {
    int x;
    int y;
    int color;

    Point(int x, int y, int color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
}
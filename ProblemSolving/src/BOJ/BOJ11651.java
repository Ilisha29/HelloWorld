package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int rep = Integer.parseInt(bufferedReader.readLine());
        ArrayList<Point> pointArrayList = new ArrayList<>();
        for (int i = 0; i < rep; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int X = Integer.parseInt(stringTokenizer.nextToken());
            int Y = Integer.parseInt(stringTokenizer.nextToken());
            pointArrayList.add(new Point(X, Y));
        }
        Collections.sort(pointArrayList);
        for (int i = 0; i < pointArrayList.size() ; i++) {
            System.out.println(pointArrayList.get(i).x+" "+ pointArrayList.get(i).y);
        }
        bufferedReader.close();
    }
}

class Point implements Comparable<Point> {
    public int x;
    public int y;

    Point(int X, int Y) {
        this.x = X;
        this.y = Y;
    }

    @Override
    public int compareTo(Point point) {
        if (this.y > point.y) {
            return 1;
        } else if (this.y < point.y) {
            return -1;
        } else {
            if (this.x > point.x) {
                return 1;
            } else if (this.x < point.x) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}

package BOJ.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ2170 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        Line[] lines = new Line[N];
        for (int i = 0; i < N; i++) {
            String[] strings = bufferedReader.readLine().split(" ");
            lines[i] = new Line();
            lines[i].x = Integer.parseInt(strings[0]);
            lines[i].y = Integer.parseInt(strings[1]);
        }
        Arrays.sort(lines, new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                if (o1.x == o2.x) return o2.y - o1.y;
                return o1.x - o2.x;
            }
        });
        int drawLength = 0;
        int end = Integer.MIN_VALUE;
        for (int i = 0; i < lines.length; i++) {
            int X = lines[i].x;
            int Y = lines[i].y;
            if (Y > end && X <= end){
                drawLength += Y - end;
                end = Y;
            } else if (Y > end && X > end){
                drawLength += Y - X;
                end = Y;
            }
        }
        System.out.println(drawLength);
        bufferedReader.close();
    }
}

class Line {
    int x;
    int y;
}

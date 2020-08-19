package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Time> arrayList = new ArrayList<>();
        int rep = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < rep; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());
            int gap = end - start;
            arrayList.add(new Time(start, end, gap));
        }
        Collections.sort(arrayList);
        Queue<Time> queue = new LinkedList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            queue.offer(arrayList.get(i));
        }
        int answer = 0;
        int time = 0;
        while (!queue.isEmpty()) {
            if (queue.peek().start >= time) {
                answer++;
                time = queue.poll().end;
            } else if (queue.peek().start < time) {
                queue.poll();
            }
        }
        System.out.println(answer);
        bufferedReader.close();
    }
}

class Time implements Comparable<Time> {
    int start;
    int end;
    int total;

    Time(int start, int end, int total) {
        this.start = start;
        this.end = end;
        this.total = total;
    }

    @Override
    public int compareTo(Time o) {
        if (this.end > o.end)
            return 1;
        else if (this.end < o.end)
            return -1;
        else {
            if (this.start > o.start) {
                return 1;
            } else if (this.start < o.start) {
                return -1;
            } else
                return 0;
        }
    }
}
package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2109 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int rep = Integer.parseInt(bufferedReader.readLine());
        ArrayList<Lecture> lectures = new ArrayList<Lecture>();
        for (int i = 0; i < rep; i++) {
            String[] strings = bufferedReader.readLine().split(" ");
            lectures.add(new Lecture(Integer.parseInt(strings[0]), Integer.parseInt(strings[1])));
        }
        Collections.sort(lectures, new Comparator<Lecture>() {
            @Override
            public int compare(Lecture o1, Lecture o2) {
                if (o2.day == o1.day) return o2.pay - o1.pay;
                return o2.day - o1.day;
            }
        });
        Queue<Lecture> queue = new LinkedList<>();
        queue.addAll(lectures);
        int incomes = 0;
        int d = 10000;
        if (!queue.isEmpty()) {
            d = queue.peek().day;
        }
        PriorityQueue<Lecture> priorityQueue = new PriorityQueue<>(new Comparator<Lecture>() {
            @Override
            public int compare(Lecture o1, Lecture o2) {
                return o2.pay - o1.pay;
            }
        });
        while (d != 0) {
            if (!queue.isEmpty()) {
                while (queue.peek().day == d) {
                    priorityQueue.add(queue.poll());
                    if (queue.isEmpty()) {
                        break;
                    }
                }
            }
            if (!priorityQueue.isEmpty()) {
                incomes += priorityQueue.poll().pay;
            }
            d--;
        }
        System.out.println(incomes);
        bufferedReader.close();
    }
}

class Lecture {
    int pay;
    int day;

    Lecture(int pay, int day) {
        this.pay = pay;
        this.day = day;
    }
}
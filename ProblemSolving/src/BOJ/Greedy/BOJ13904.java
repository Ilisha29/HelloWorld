package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ13904 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        ArrayList<Subject> arrayList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] strings = bufferedReader.readLine().split(" ");
            arrayList.add(new Subject(Integer.parseInt(strings[0]), Integer.parseInt(strings[1])));
        }
        Collections.sort(arrayList, new Comparator<Subject>() {
            @Override
            public int compare(Subject o1, Subject o2) {
                return o2.limit - o1.limit;
            }
        });
        int maxTime = arrayList.get(0).limit;
        PriorityQueue<Subject> priorityQueue = new PriorityQueue<>(new Comparator<Subject>() {
            @Override
            public int compare(Subject o1, Subject o2) {
                return o2.point - o1.point;
            }
        });
        int pointSum = 0;
        while (maxTime != 0) {
            while (arrayList.size() != 0 && arrayList.get(0).limit == maxTime){
                priorityQueue.add(arrayList.get(0));
                arrayList.remove(0);
            }
            if (!priorityQueue.isEmpty()){
                pointSum += priorityQueue.poll().point;
            }
            maxTime--;
        }
        System.out.println(pointSum);
        bufferedReader.close();
    }
}

class Subject{
    int limit;
    int point;

    Subject(int limit, int point) {
        this.limit = limit;
        this.point = point;
    }
}

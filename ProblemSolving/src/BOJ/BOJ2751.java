package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

//출력이 많다면 StringBuilder 를 쓰자
public class BOJ2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> priorityQueue =new PriorityQueue<>();
        int rep = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < rep; i++) {
           priorityQueue.add(Integer.parseInt(bufferedReader.readLine()));
        }
        StringBuilder stringBuilder = new StringBuilder();
        while(!priorityQueue.isEmpty()){
            stringBuilder.append(priorityQueue.poll());
            stringBuilder.append("\n");
        }
        System.out.print(stringBuilder);
        bufferedReader.close();
    }
}

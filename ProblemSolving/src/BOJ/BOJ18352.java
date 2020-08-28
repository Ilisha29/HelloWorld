package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ18352 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());
        int X = Integer.parseInt(stringTokenizer.nextToken());
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<ArrayList<Integer>>();
        int[] visit = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            arrayLists.add(new ArrayList<Integer>());
            visit[i] = -1;
        }
        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            arrayLists.get(Integer.parseInt(stringTokenizer.nextToken())).add(Integer.parseInt(stringTokenizer.nextToken()));
        }
        Queue<Integer> points = new LinkedList<>();
        visit[X] = 0;
        points.offer(X);
        while (!points.isEmpty()) {
            int now = points.poll();
            for (int i = 0; i < arrayLists.get(now).size(); i++) {
                int next = arrayLists.get(now).get(i);
                if (visit[next] == -1) {
                    visit[next] = visit[now] + 1;
                    points.offer(next);
                }
            }

        }
        boolean check = false;
        for (int i = 0; i < visit.length; i++) {
            if (visit[i] == K) {
                System.out.println(i);
                check = true;
            }
        }
        if (!check) {
            System.out.println(-1);
        }
        bufferedReader.close();
    }
}
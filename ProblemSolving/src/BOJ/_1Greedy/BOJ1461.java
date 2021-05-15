package BOJ._1Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1461 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = bufferedReader.readLine().split(" ");
        int M = Integer.parseInt(NM[1]);
        int[] books = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int min = Math.min(Arrays.stream(books).min().getAsInt(), 0);
        int max = Math.max(Arrays.stream(books).max().getAsInt(), 0);
        ArrayList<Integer> minusArray = new ArrayList<>();
        ArrayList<Integer> plusArrayList = new ArrayList<>();
        for (int i = 0; i < books.length; i++) {
            if (books[i] < 0) {
                minusArray.add(-books[i]);
            }
        }
        for (int i = 0; i < books.length; i++) {
            if (books[i] > 0) {
                plusArrayList.add(books[i]);
            }
        }
        Collections.sort(minusArray, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        Collections.sort(plusArrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        Queue<Integer> Minus = new LinkedList<>();
        Queue<Integer> Plus = new LinkedList<>();
        Minus.addAll(minusArray);
        Plus.addAll(plusArrayList);
        int answer = calculateLength(Minus, M);
        answer += calculateLength(Plus, M);
        System.out.println(answer - Math.max(-min, max));
        bufferedReader.close();
    }

    private static int calculateLength(Queue<Integer> queue, int m) {
        int tmpAnswer = 0;
        while (!queue.isEmpty()) {
            tmpAnswer += queue.poll() * 2;
            int count = 1;
            while (count < m && !queue.isEmpty()) {
                queue.poll();
                count++;
            }
        }
        return tmpAnswer;
    }

}

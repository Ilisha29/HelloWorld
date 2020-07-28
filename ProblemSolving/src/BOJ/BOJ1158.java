package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//14:50
public class BOJ1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }
        int i = 1;
        while (true) {
            if (queue.size() == 0)
                break;
            if (i == K) {
                arrayList.add(queue.poll());
                i = 1;
            } else {
                int tmp = queue.poll();
                queue.offer(tmp);
                i++;
            }
        }
        System.out.print("<");
        for (int j = 0; j < arrayList.size(); j++) {
            if (j == arrayList.size() - 1) {
                System.out.print(arrayList.get(j));
            } else {
                System.out.print(arrayList.get(j) + ", ");
            }
        }
        System.out.print(">");
    }
}
//15 : 05 (15')

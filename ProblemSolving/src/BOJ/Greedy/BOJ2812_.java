package BOJ.Greedy;

import java.io.*;
import java.util.*;

public class BOJ2812_ {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = bufferedReader.readLine().split(" ");
        int length = Integer.parseInt(input[0]);
        int deleteCount = Integer.parseInt(input[1]);
        char[] arr = bufferedReader.readLine().toCharArray();
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            while (deleteCount > 0 && !deque.isEmpty() && deque.getLast() < arr[i]) {
                deque.removeLast();
                deleteCount--;
            }
            deque.addLast(arr[i]);
        }
        StringBuilder ans = new StringBuilder();
        while (deque.size() > deleteCount) {
            ans.append(deque.removeFirst());
        }
        bufferedWriter.write(ans.toString() + "\n");
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}


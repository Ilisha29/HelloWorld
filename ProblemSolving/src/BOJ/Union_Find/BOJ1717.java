package BOJ.Union_Find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1717 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int[] parent = new int[N + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int YesNo = Integer.parseInt(stringTokenizer.nextToken());
            int A = Integer.parseInt(stringTokenizer.nextToken());
            int B = Integer.parseInt(stringTokenizer.nextToken());
            if (YesNo == 0) {
                union(A, B, parent);
            } else {
                parent[A] = find(A, parent);
                parent[B] = find(B, parent);
                if (parent[A] == parent[B]) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
        bufferedReader.close();
    }

    private static void union(int A, int B, int[] parent) {
        A = find(A, parent);
        B = find(B, parent);
        if (A < B) {
            parent[B] = A;
        } else {
            parent[A] = B;
        }
    }

    private static int find(int X, int[] parent) {
        if (parent[X] != X) {
            parent[X] = find(parent[X], parent);
        }
        return parent[X];
    }
}

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1260 {
    static int node[][];
    static int check[];
    static Queue<Integer> queue = new LinkedList<>();

    static void DFS(int startNum) { //스택활용가능 여기선 재귀함수 구현
        if (check[startNum] == 1) return;

        check[startNum] = 1;
        System.out.print(startNum + " ");

        for (int i = 1; i < node.length; i++) {
            if (node[i][startNum] == 1) {
                DFS(i);
            }
        }
    }

    static void BFS(int startNum){ // 큐 필요
        queue.offer(startNum);
        check[startNum] = 1;
        while (!queue.isEmpty()){
            int num = queue.poll();
            System.out.print(num+" ");
            for (int i = 1; i < node.length; i++) {
                if(node[i][num]==1 && check[i] == 0){
                    queue.offer(i);
                    check[i]=1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int startNum = scanner.nextInt();
        node = new int[N + 1][N + 1];
        check = new int[N + 1];
        for (int i = 0; i < M; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            node[x][y] = 1;
            node[y][x] = 1;
        }

        DFS(startNum);
        Arrays.fill(check, 0);
        System.out.println();
        BFS(startNum);
    }
}

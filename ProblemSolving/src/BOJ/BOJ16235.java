package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 13 : 05
public class BOJ16235 {
    static int[][] startMap;
    static int[][] annualNutrition;
    static PriorityQueue<Tree> treeQueue;
    static int N;
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // 조건 1 : 나무가 이미 있을 수 있지만, M개의 나무를 구매해 심음
        // 봄 : 나이만큼 양분 먹기 -> +1 살 / 어린나무 부터 양분섭취 / 양분이 나이만큼 부족하면 즉사
        // 여름 : 죽은나무 양분(죽은 나무 나이 /2 )으로(소수점 버림)
        // 가을 : 나무의 나이가 5배수때 번식 -> 인접 8개 칸에 나이 1
        // 겨울 : 양분추가 A[r][c]
        // 출력 K년 지난 후 나무의 갯수
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());
        startMap = new int[N][N];
        annualNutrition = new int[N][N];
        treeQueue = new PriorityQueue<Tree>();
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer1 = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                startMap[i][j] = 5;
                annualNutrition[i][j] = Integer.parseInt(stringTokenizer1.nextToken());
            }
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer stringTokenizer1 = new StringTokenizer(bufferedReader.readLine());
            treeQueue.offer(new Tree(Integer.parseInt(stringTokenizer1.nextToken()) - 1, Integer.parseInt(stringTokenizer1.nextToken()) - 1, Integer.parseInt(stringTokenizer1.nextToken())));
        }
        //입력끝

        for (int i = 0; i < K; i++) {
            ArrayList<Tree> deadTree = new ArrayList<>();
            ArrayList<Tree> tmpTree = new ArrayList<>();
            //spring
            while (!treeQueue.isEmpty()) {
                Tree tree = treeQueue.poll();
                if (startMap[tree.x][tree.y] >= tree.age) {
                    startMap[tree.x][tree.y] -= tree.age;
                    tree.age++;
                    tmpTree.add(tree);
                } else {
                    tree.age /= 2;
                    deadTree.add(tree);
                }
            }
            //summer
            for (int j = 0; j < deadTree.size(); j++) {
                startMap[deadTree.get(j).x][deadTree.get(j).y] += deadTree.get(j).age;
            }
            //fall
            for (int j = 0; j < tmpTree.size(); j++) {
                Tree tree = tmpTree.get(j);
                if (tree.age % 5 == 0) {
                    int X = tree.x;
                    int Y = tree.y;
                    for (int k = 0; k < 8; k++) {
                        int x = X + dx[k];
                        int y = Y + dy[k];
                        if (x >= 0 && x < N && y >= 0 && y < N) {
                            treeQueue.add(new Tree(x, y, 1));
                        }
                    }
                }
                treeQueue.add(tree);
            }
            //winter
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    startMap[j][k] += annualNutrition[j][k];
                }
            }
        }
        System.out.println(treeQueue.size());
        bufferedReader.close();
    }
}

class Tree implements Comparable<Tree> {
    public int x;
    public int y;
    public int age;

    Tree(int x, int y, int age) {
        this.x = x;
        this.y = y;
        this.age = age;
    }

    @Override
    public int compareTo(Tree tree) {
        if (this.age > tree.age) {
            return 1;
        } else if (this.age < tree.age) {
            return -1;
        } else {
            return 0;
        }
    }
}
// 14 : 55
// Iterator는 삭제에 시간복잡도가 O(N)이라 큐,스택에서 삭제 수정을 해야 0(1)을 보장 받는다.
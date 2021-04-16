package KAKAO.KAKAO2020공채;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 16 : 58분
public class KAKAO2020공채_외벽점검 {
    public static void main(String[] args) {
        //12	[1, 5, 6, 10]	[1, 2, 3, 4]	//2
        //12	[1, 3, 4, 9, 10]	[3, 5, 7]	//1
        int n = 12;
        int[] week = {1, 5, 6, 10};
        int[] dist = {1, 2, 3, 4};

        int[] week1 = {1, 3, 4, 9, 10};
        int[] dist1 = {3, 5, 7};
        System.out.println(solution(n, week, dist));
    }

    static int answer;
    static int[][] weakArray;
    static int N;
    static boolean answerIsFounded;

    public static int solution(int n, int[] weak, int[] dist) {
        N = n;
        answer = -1;
        answerIsFounded = false;
        int k = 1;

        Arrays.sort(weak);
        weakArray = new int[weak.length][weak.length];
        for (int i = 0; i < weak.length; i++) {
            int startIndex = i;
            int index = 0;
            for (int j = startIndex; j < startIndex + weak.length; j++) {
                if (j >= weak.length) {
                    weakArray[index][i] = weak[j - weak.length];
                    weakArray[index][i] += N;
                    index++;
                } else {
                    weakArray[index][i] = weak[j];
                    index++;
                }
            }
        }
        while (true) {
            if (answerIsFounded) {
                break;
            }
            perm(dist, 0, dist.length, k);
            k++;
        }
        return answer;
    }

    public static void perm(int[] arr, int depth, int n, int k) {
        if (depth == k) { // 한번 depth 가 k로 도달하면 사이클이 돌았음. 출력함.
            if (!answerIsFounded) {
                for (int i = 0; i < weakArray.length; i++) {
                    //여기서부터 newArray가 tmpArray를 모두 카바하는지 확인
                    Queue<Integer> queue = new LinkedList<>();
                    Queue<Integer> WeakQueue = new LinkedList<>();
                    for (int j = 0; j < k; j++) {
                        queue.offer(arr[j]);
                    }
                    for (int j = 0; j < weakArray.length; j++) {
                        WeakQueue.offer(weakArray[i][j]);
                    }
                    while (!queue.isEmpty()) {
                        int CoverRange = queue.poll();
                        int StartNum = WeakQueue.peek();
                        int EndRange = StartNum + CoverRange;
                        while (!WeakQueue.isEmpty() && (WeakQueue.peek() >= StartNum && WeakQueue.peek() <= EndRange)) {
                            WeakQueue.poll();
                        }
                    }
                    if (WeakQueue.isEmpty()) {
                        answerIsFounded = true;
                        answer = k;
                    }
                }
            }
            return;
        }
        for (int i = depth; i < n; i++) {
            swap(arr, i, depth);
            perm(arr, depth + 1, n, k);
            swap(arr, i, depth);
        }
    } // 자바에서는 포인터가 없기 때문에 아래와 같이, 인덱스 i와 j를 통해 바꿔줌.

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

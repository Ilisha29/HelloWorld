package KAKAO.KAKAO2020공채.prac1;

public class K5 {
    public static void main(String[] args) {
        int[] n = {12, 12};
        int[][] weak = {{1, 5, 6, 10}, {1, 3, 4, 9, 10}};
        int[][] dist = {{1, 2, 3, 4}, {3, 5, 7}};
        for (int i = 0; i < n.length; i++) {
            System.out.println(solution(n[i], weak[i], dist[i]));
        }
    }

    private static int[] doubleWeak;
    private static boolean isCanAnswer;
    private static int N;

    public static int solution(int n, int[] weak, int[] dist) {
        makeDoubleWeak(n, weak);
        isCanAnswer = false;
        N = n;
        for (int i = 1; i <= dist.length; i++) {
            perm(dist, 0, dist.length, i);
            if (isCanAnswer) {
                return i;
            }
        }
        return -1;//perm(dist, 0, 7, 7);
    }

    private static void makeDoubleWeak(int n, int[] weak) {
        doubleWeak = new int[weak.length * 2];
        for (int i = 0; i < weak.length; i++) {
            doubleWeak[i] = weak[i];
        }
        int index = 0;
        for (int i = weak.length; i < doubleWeak.length; i++) {
            doubleWeak[i] = weak[index++] + n;
        }
    }

    public static void perm(int[] arr, int depth, int n, int k) {
        if (depth == k) { // 한번 depth 가 k로 도달하면 사이클이 돌았음. 출력함.
            int[] tmpArr = new int[k];
            for (int i = 0; i < k; i++) {
                tmpArr[i] = arr[i];
            }
            check(tmpArr);
            return;
        }
        for (int i = depth; i < n; i++) {
            swap(arr, i, depth);
            perm(arr, depth + 1, n, k);
            swap(arr, i, depth);
        }
    } // 자바에서는 포인터가 없기 때문에 아래와 같이, 인덱스 i와 j를 통해 바꿔줌.

    private static void check(int[] tmpArr) {
        int startIndex = 0;
        int finishIndex = doubleWeak.length / 2;
        while (startIndex < finishIndex) {
            boolean[] totalLength = new boolean[N * 3];
            int start = startIndex;
            for (int i = 0; i < tmpArr.length; i++) {
                while (totalLength[doubleWeak[start]]) {
                    start++;
                }
                for (int j = doubleWeak[start]; j <= doubleWeak[start] + tmpArr[i]; j++) {
                    totalLength[j] = true;
                }
            }
            allCheck(totalLength, doubleWeak);
            startIndex++;
        }
    }

    private static void allCheck(boolean[] totalLength, int[] doubleWeak) {
        int[] weak = new int[doubleWeak.length / 2];
        for (int i = 0; i < weak.length; i++) {
            weak[i] = doubleWeak[i];
        }
        boolean[] check = new boolean[N];
        for (int i = 0; i < totalLength.length; i++) {
            if (totalLength[i]) {
                check[i % N] = true;
            }
        }
        boolean isAllCheck = true;
        for (int i = 0; i < weak.length; i++) {
            if (!check[weak[i]]) {
                isAllCheck = false;
            }
        }
        if (isAllCheck) {
            isCanAnswer = true;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
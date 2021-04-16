package KAKAO.KAKAO공채연습._2020;

import java.util.ArrayList;

public class 외벽점검 {
    public static void main(String[] args) {
        int n = 12;
        int[] weak = {1, 5, 6, 10};
        int[] dist = {1, 2, 3, 4};
        System.out.println(solution(n, weak, dist));
    }

    public static int solution(int n, int[] weak, int[] dist) {
        int[] newWeak = new int[weak.length * 2];
        for (int i = 0; i < weak.length; i++) {
            newWeak[i] = weak[i];
            newWeak[i + weak.length] = weak[i] + n;
        }
        for (int i = 1; i <= dist.length; i++) {
            ArrayList<int[]> arrayList = new ArrayList<>();
            perm(dist, 0, dist.length, i, arrayList);
            for (int j = 0; j < arrayList.size(); j++) {
                int[] tmpArray = arrayList.get(j);
                for (int k = 0; k < newWeak.length / 2; k++) {
                    int startIndex = k;
                    boolean[] booleans = new boolean[newWeak.length];
                    for (int m = 0; m < tmpArray.length; m++) {
                        int endRange = newWeak[startIndex] + tmpArray[m];
                        int endIndex = 0;
                        for (int l = startIndex; l < newWeak.length; l++) {
                            if (newWeak[l] > endRange) {
                                break;
                            } else {
                                endIndex = l;
                            }
                        }
                        for (int l = startIndex; l <= endIndex; l++) {
                            booleans[l] = true;
                        }
                        startIndex = endIndex + 1;
                    }
                    int count = newWeak.length / 2;
                    for (int z = 0; z < booleans.length / 2; z++) {
                        if (booleans[z] || booleans[z + booleans.length / 2]) {
                            count--;
                        }
                    }
                    if (count == 0) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    public static void perm(int[] arr, int depth, int n, int k, ArrayList arrayList) {
        if (depth == k) { // 한번 depth 가 k로 도달하면 사이클이 돌았음. 출력함.
            int[] tmpArray = new int[k];
            for (int i = 0; i < k; i++) {
                tmpArray[i] = arr[i];
            }
            arrayList.add(tmpArray);
            return;
        }
        for (int i = depth; i < n; i++) {
            swap(arr, i, depth);
            perm(arr, depth + 1, n, k, arrayList);
            swap(arr, i, depth);
        }
    } // 자바에서는 포인터가 없기 때문에 아래와 같이, 인덱스 i와 j를 통해 바꿔줌.

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

/*
for (int i = 0; i < newWeak.length / 2; i++) {
                int startIndex = i;
                boolean[] booleans = new boolean[newWeak.length];
                for (int j = 0; j < tmpArray.length; j++) {
                    int endRange = newWeak[startIndex] + tmpArray[j];
                    int endIndex = 0;
                    for (int l = startIndex; l < newWeak.length; l++) {
                        if (newWeak[l] > endRange) {
                            break;
                        } else {
                            endIndex = l;
                        }
                    }
                    for (int l = startIndex; l <= endIndex; l++) {
                        booleans[l] = true;
                    }
                    startIndex = endIndex + 1;
                }
                int count = newWeak.length / 2;
                for (int j = 0; j < booleans.length / 2; j++) {
                    if (booleans[j] || booleans[j + booleans.length / 2]) {
                        count--;
                    }
                }
                if (count == 0) {
                    return true;
                }
            }
 */
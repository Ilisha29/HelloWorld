package Programmers.완전탐색;

import java.util.HashMap;

public class 소수찾기 {
    public static void main(String[] args) {
        String[] strings = {"17", "011"};
        for (int i = 0; i < strings.length; i++) {
            System.out.println(solution(strings[i]));
        }
    }

    public static int solution(String numbers) {
        int answer = 0;
        String[] strings = numbers.split("");
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 1; i <= strings.length; i++) {
            perm(strings, 0, strings.length, i, hashMap);
        }
        for (int key : hashMap.keySet()) {
            if (isPrime(key)) {
                answer++;
            }
        }
        return answer;
    }

    private static boolean isPrime(int key) {
        if (key == 2 || key == 3) {
            return true;
        } else if (key == 0 || key == 1) {
            return false;
        } else {
            for (int i = 2; i <= key / 2; i++) {
                if (key % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void perm(String[] arr, int depth, int n, int k, HashMap hashMap) {
        if (depth == k) { // 한번 depth 가 k로 도달하면 사이클이 돌았음. 출력함.
            int num = insert(arr, k);
            hashMap.put(num, 1);
            return;
        }
        for (int i = depth; i < n; i++) {
            swap(arr, i, depth);
            perm(arr, depth + 1, n, k, hashMap);
            swap(arr, i, depth);
        }
    } // 자바에서는 포인터가 없기 때문에 아래와 같이, 인덱스 i와 j를 통해 바꿔줌.

    public static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int insert(String[] arr, int k) {
        String tmp = "";
        for (int i = 0; i < k; i++) {
            tmp += arr[i];
        }
        return Integer.parseInt(tmp);
    }
}
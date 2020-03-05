import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ14888 {
    static int[] numbers;
    static ArrayList<Integer> arrayList;

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());
        numbers = new int[length];
        arrayList = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < length; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        int[] operation = new int[4];
        StringTokenizer stringTokenizer1 = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < operation.length; i++) {
            operation[i] = Integer.parseInt(stringTokenizer1.nextToken());
        }

        //순열
        int operationLength = 0;
        for (int i = 0; i < 4; i++) {
            operationLength += operation[i];
        }
        int[] operations = new int[operationLength];
        int index = 0;
        for (int i = 0; i < operation.length; i++) {
            for (int j = 0; j < operation[i]; j++) {
                operations[index++] = i;
            }
        }
        perm(operations, 0, operations.length, operations.length);

        //결과출력
        Collections.sort(arrayList);
        System.out.println(arrayList.get(arrayList.size() - 1));
        System.out.println(arrayList.get(0));
        bufferedReader.close();
    }

    public static void perm(int[] arr, int depth, int n, int k) {
        if (depth == k) { // 한번 depth 가 k로 도달하면 사이클이 돌았음. 출력함.
            calculation(arr);
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

    public static void calculation(int[] arr) {
        int tmpAnswer = numbers[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                tmpAnswer = tmpAnswer + numbers[i + 1];
            } else if (arr[i] == 1) {
                tmpAnswer = tmpAnswer - numbers[i + 1];
            } else if (arr[i] == 2) {
                tmpAnswer = tmpAnswer * numbers[i + 1];
            } else {
                tmpAnswer = tmpAnswer / numbers[i + 1];
            }
        }
        arrayList.add(tmpAnswer);
    }

    /*public static void print(int[] arr, int k) {
        for (int i = 0; i < k; i++) {
            if (i == k - 1) System.out.println(arr[i]);
            else System.out.print(arr[i] + ",");
        }
    }*/
}

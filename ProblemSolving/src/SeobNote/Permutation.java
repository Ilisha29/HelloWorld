package SeobNote;

public class Permutation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        perm(arr, 0, 7, 7);
    }

    //매개변수로 arrayList를 넣어서 nPr에 맞는 배열만 넣어서 순열문제 해결하기
    public static void perm(int[] arr, int depth, int n, int k) {
        if (depth == k) { // 한번 depth 가 k로 도달하면 사이클이 돌았음. 출력함.
            print(arr, k);
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

    public static void print(int[] arr, int k) {
        for (int i = 0; i < k; i++) {
            if (i == k - 1) System.out.println(arr[i]);
            else System.out.print(arr[i] + ",");
        }
    }
}

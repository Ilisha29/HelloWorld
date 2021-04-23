public class ex {
    private static int count = 0;
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};

        permutation(array, 0, 5, 5);
    }

    private static void permutation(int[] array, int depth, int n, int k) {
        if (depth == k) {
            print2(array, k);
        }
        for (int i = depth; i < n; i++) {
            swap2(array, i, depth);
            permutation(array, depth + 1, n, k);
            swap2(array, i, depth);
        }
    }

    private static void swap2(int[] array, int i, int depth) {
        int tmp = array[i];
        array[i] = array[depth];
        array[depth] = tmp;
    }

    private static void print2(int[] array, int k) {
        for (int i = 0; i < k; i++) {
            System.out.print(array[i] + " ");
        }
        count = count + 1;
        System.out.println(count);
    }

}

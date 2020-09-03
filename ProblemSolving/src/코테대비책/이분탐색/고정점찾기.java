package 코테대비책.이분탐색;

public class 고정점찾기 {
    private static int fixPointBinarSearch(int[] array, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] == mid) {
                return mid;
            } else if (array[mid] > mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] N = {"5", "7", "7"};
        String[] inputs = {"-15 -6 1 3 7", "-15 -4 2 8 9 13 15", "-15 -4 3 8 9 13 15"};
        for (int i = 0; i < N.length; i++) {
            int n = Integer.parseInt(N[i]);
            int[] array = new int[n];
            String[] strings = inputs[i].split(" ");
            for (int j = 0; j < n; j++) {
                array[j] = Integer.parseInt(strings[j]);
            }
            System.out.println(fixPointBinarSearch(array, 0, array.length - 1));
        }
    }
}

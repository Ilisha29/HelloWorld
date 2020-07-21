package BOJ;

public class BOJ4673 {
    public static void main(String[] args) {
        int[] arr = new int[10001];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0)
                System.out.println(i);
            int sum = i;
            int n = i;
            while (true) {
                if (n == 0) break;
                sum += n % 10;
                n = n / 10;
            }
            if (sum <= 10000)
                arr[sum] = 1;
        }
    }
}

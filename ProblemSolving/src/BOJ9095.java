import java.util.Scanner;

public class BOJ9095 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int[] array = new int[T];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        int[] map = new int[10];
        map[0] = 1;
        map[1] = 2;
        map[2] = 4;
        for (int i = 3; i < 10; i++) {
            map[i] = map[i - 1] + map[i - 2] + map[i - 3];
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(map[array[i] - 1]);
        }
    }
}

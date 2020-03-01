import java.util.Scanner;

public class BOJ1924 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Month = scanner.nextInt();
        int Day = scanner.nextInt();
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 0; i < Month - 1; i++) {
            Day += months[i];
        }
        String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        System.out.println(day[Day % 7]);
    }
}

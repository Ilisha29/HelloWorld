import java.util.Scanner;

public class BOJ11021 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int F = scanner.nextInt();
        int[][] map = new int[F][2];
        for (int i = 0; i < F ; i++) {
            map[i][0] = scanner.nextInt();
            map[i][1] = scanner.nextInt();
        }

        for (int i = 0; i < F; i++) {
            System.out.println("Case #"+(i+1)+": "+(map[i][0]+map[i][1]));
        }
    }
}
